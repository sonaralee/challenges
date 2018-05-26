package com.burger;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> toppings = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);
        String roll;
        String burgerType;

        System.out.println("What type of burger do you want?\n" +
                "(Regular, Healthy, Deluxe)");
        burgerType = sc.nextLine().toUpperCase();

        switch(burgerType) {
            case "REGULAR":
                System.out.println("What type of roll do you want?\n" +
                        "(white, wheat, rye)");
                roll = sc.nextLine().toLowerCase();
                System.out.println("What toppings do you want?\n(enter 1 topping on " +
                        "each line, or 'stop' to stop)");
                while(sc.nextLine() != "stop" && toppings.size() < 4) {
                    toppings.add(sc.nextLine().toLowerCase());
                }
                Hamburger hb = new Hamburger(roll, toppings);

                break;
            case "HEALTHY":
                System.out.println("What toppings do you want?\n(enter 1 topping on " +
                        "each line, or 'stop' to stop)");
                while(sc.nextLine() != "stop" && toppings.size() < 6) {
                    toppings.add(sc.nextLine().toLowerCase());
                }
                hb = new HealthBurger("rye", toppings);
                break;
            case "DELUXE":
                toppings.add("chips");
                toppings.add("drink");
                System.out.println("What type of roll do you want?\n" +
                        "(white, wheat, rye)");
                roll = sc.nextLine().toLowerCase();
                hb = new DeluxeBurger(roll, toppings);
                break;
        }

    }
}
