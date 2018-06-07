package com.adventure_random;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class old_Main {
    public static void main(String[] args) {
        try {
            int result = divide();
            System.out.println(result);
        } catch(ArithmeticException | NoSuchElementException e) {
            System.out.println(e.toString());
            System.out.println("Unable to perform division, " +
                                "autopilot shutting down");
        }
    }

    public static int getInt() {
        System.out.println("Enter a number");
        Scanner sc = new Scanner(System.in);
       while(true) {
           try {
               return sc.nextInt();
           } catch(InputMismatchException e) {
               sc.nextLine();
               System.out.println("Enter a number using only digits 0-9");
           }
       }
    }

    public static int divide() {
        int x, y;
//        try {
            x = getInt();
            y = getInt();
            System.out.println("x is " + x + ", y is " + y);
            return x/y;
//        } catch(NoSuchElementException e) {
//            throw new ArithmeticException("no suitable input");
//        } catch(ArithmeticException e) {
//            throw new ArithmeticException("attempt to divide by zero");
//        }
    }
}
