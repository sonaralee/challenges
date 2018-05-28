package com.scope;

import java.util.Scanner;

public class X {
    private int x;

    X(Scanner x) {
        System.out.println("Enter an integer: ");
        this.x = x.nextInt();
    }

    void x() {
        int x = 0;
        while (x <= 12) {
            System.out.println(this.x*x + " ");
            x++;
        }
    }
}
