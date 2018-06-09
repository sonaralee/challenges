package com.interfaces;
// Create a simple interface (tip: name it Saveable or ISaveable)
//
// In OldMain, write a method that takes an object that implements the interface as a parameter and
// "saves" the values e.g. calls the method defined in the interface.
// We haven't covered I/O yet, so your method should just print the values to the screen.
// Also in the OldMain class, write a method that restores the values to a Saveable object
// e.g. calls the method from the interface for populating fields (see above).

// Again, we are not going to use Java file I/O; instead use the readValues() method below to
// simulate getting values from a file – this allows you to type as many values as your class
// requires, and returns an ArrayList.
// There is a whole Java I/O section later in the course where you will get to use files, etc.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" +
                "1 to enter a string\n" +
                "0 to quit");

        while (!quit) {
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.print("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }

    public static void stats(List<String> list) {
        System.out.println("Player stats:");
        for(String item : list) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        List<String> theList = readValues();
        ISaveable p;
        p = new Player("Emma");

        p.save();
        stats(((Player) p).getStats());

        p.populate(theList);
        p.save();
        stats(theList);


    }
}