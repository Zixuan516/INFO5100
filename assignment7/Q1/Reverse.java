package assignment7.Q1;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Stack;

public class Reverse {
    public static void main(String[] args) {
       Reverse r = new Reverse();
       r.reverse("src/main/java/assignment7/Q1/input.txt", "src/main/java/assignment7/Q1//output.txt");
    }


    public void reverse(String filePath, String newFilePath) {
        File file = new File(filePath);
        FileInputStream fis;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        File newFile = new File(newFilePath);

        String reversedSentence;
        try(FileOutputStream fos = new FileOutputStream(newFile)) {
            while (true) {
                reversedSentence = reverseOneSentence(fis);
                if (!reversedSentence.equals("-1")) {
                    fos.write(reversedSentence.getBytes(StandardCharsets.UTF_8));
                    fos.write(' ');
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }





    private String reverseOneSentence(FileInputStream fis) throws IOException {
        StringBuffer sb = new StringBuffer();
        Stack<String> s = new Stack<>();
        while (true) {
            String word = readOneWord(fis);
            if(word.equals("-1")) {
                break;
            } else if(word.isEmpty()) {
                break;
            } else {
                s.push(word);
            }
        }
        if(s.isEmpty()){
            return "-1";
        }
        while (!s.isEmpty()) {
            sb.append(s.pop());
            sb.append(' ');
        }

        sb.delete(sb.length() - 1, sb.length());
        sb.append('.');
        return sb.toString();
    }

    public String readOneWord(FileInputStream fis) throws IOException {
        int x;
        StringBuffer sb = new StringBuffer();
        while (true) {
            x = fis.read();
            if (x == -1) {
                return "-1";
            }
            if ((char) x == '.') {
                return sb.toString();
            }
            if ((char) x == ' ' || (char) x == '\n') {
                return sb.toString();
            }
            sb.append((char) x);
        }
    }

}


