package assignment7.Q2;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Decode {

    public static void main(String[] args) {
        Decode d  = new Decode();
        d.decodeFile("src/main/java/assignment7/Q2/input.txt", "src/main/java/assignment7/Q2//output.txt");
    }

    public void decodeFile(String filePath, String newFilePath) {
        StringBuffer sb = new StringBuffer();
        try(FileInputStream fis = new FileInputStream(new File(filePath))) {
            int x;
            while ((x = fis.read()) != -1) {
                sb.append((char)x);
            }
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }

        File newFile = new File(newFilePath);
        try(FileOutputStream fos = new FileOutputStream(newFile)) {
            String s = decodeString(sb.toString());
            fos.write(s.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String decodeString(String s) {
        int[] end = new int[1];
        end[0] = s.length()+3;
        return decodeString2("1[" + s + "]", 0, end);
    }

    private String decodeString2(String s, int start, int[] end) {
        int num = 0;
        StringBuilder res = new StringBuilder();
        StringBuilder sb = new StringBuilder();

        while(Character.isDigit(s.charAt(start))){
            num = num * 10 + s.charAt(start) - '0';
            start++;
        }
        start++;
        while(s.charAt(start) != ']') {
            if (Character.isLetter(s.charAt(start))) {
                sb.append(s.charAt(start));
                start++;
            } else if (Character.isDigit(s.charAt(start))){
                sb.append(decodeString2(s, start, end));
                start = end[0] + 1;
            }
        }
        end[0] = start;
        String single = sb.toString();
        for(int i= 0; i<num;i++ ){
            res.append(single);
        }
        return res.toString();

    }
}
