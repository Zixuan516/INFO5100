package assignment5.Q2;

import java.util.Scanner;

public class Number {
    public int count(int num1, int num2) {
        if (num2 == 0) {
            throw new ArithmeticException(" 0 can't divide Integer");
        }

        return num1/num2;
    }
}
