package com.series;
// Create a suitably named package containing a class called Series
// with the following static methods:

// When you have tested your functions, delete the OldMain class and
// produce a jar file.
//
// Create a new project and add your Series library, then test the
// three methods in the main() method of your new project.


public class Series {
    // nSum(int n) returns the sum of all numbers from 0 to n.
    // The first 10 numbers are:
    // 0, 1, 3, 6, 10, 15, 21, 28, 36, 45, 55.
    public static int nSum(int n) {
        int i = 0;
        int sum = 0;

        while(i <= n) {
            sum += i;
            i++;
        }
        return sum;
    }

    // factorial(int n) returns the product of all numbers from 1 to n
    // i.e. 1 * 2 * 3 * 4 ... * (n - 1) * n.
    // The first 10 factorials are:
    // 0, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800.
    public static int factorial(int n) {
        if(n == 0) {
            return 0;
        }

        int i = 1;
        int product = 1;

        while(i <= n) {
            product *= i;
            i++;
        }

        return product;
    }

    // fibonacci(n) returns the nth Fibonacci number. These are defined as:
    // f(0) = 0
    // f(1) = 1
    // f(n) = f(n-1) + f(n-2)
    // so f(2) is also 1. The first 10 fibonacci numbers are:
    // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55.
    public static int fibonacci(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }
}
