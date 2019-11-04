package assignment7.Q3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountLines {

    public static void main(String[] args){
        CountLines c = new CountLines();
        c.count(args);
    }

    public void count(String[] s){
        for (int i = 0; i < s.length; i++) {
            try {
                FileInputStream fil = new FileInputStream(new File(s[i]));
                Scanner scanner = new Scanner(fil);

                int j = 0;

                while (scanner.hasNext()) {
                    j++;
                    scanner.nextLine();
                }
                System.out.println(s[i] + ": " + j);
            } catch (Exception e) {
                System.out.println("The File named " + s[i] + " can not be read, continue. error: " + e);
            }
        }
    }
}
