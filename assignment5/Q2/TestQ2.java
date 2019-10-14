package assignment5.Q2;

import java.util.Scanner;

public class TestQ2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please type in the num1");
        int num1 = input.nextInt();
        System.out.println("Please type in the num2");
        int num2 = input.nextInt();
        int quo = 0;

        try {
            quo = new Number().count(num1, num2);
        } catch (ArithmeticException ar) {
            throw new RuntimeException(ar);
        }

        System.out.println("The quotient is " + quo);
    }
}
