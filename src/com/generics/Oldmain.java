package com.generics;

import java.util.ArrayList;

public class Oldmain {
    // Messing around with a list without generics
    public static void testmain(String[] args) {
        //String s = "Hello";
        ArrayList list = new ArrayList();
        ArrayList<String> stringList = new ArrayList<>();

        list.add("Hello");
        list.add(100);
        list.add(5.5);

        stringList.add("Hello");
        stringList.add("9 Whatever 9");
        stringList.add("I like turtles");

        System.out.println("Here's the generic list:");
        for(Object o : stringList) {
            System.out.println(o.getClass().getSimpleName() + ": " + o);
        }

        System.out.println("\nGeneric list with items changed:");
        printChangedItems(stringList);

        System.out.println("\nHere's the non-generic list:");
        for(Object o : list) {
            System.out.println(o.getClass().getSimpleName() + ": " + o);
        }

        System.out.println("\nNon-generic list with items changed:");
        printChangedItems(list);
    }

    private static void printChangedItems(ArrayList l) {
        for(Object o : l) {
            if (o instanceof String){
                StringBuilder sb = new StringBuilder();
                sb.append(o);
                System.out.println(sb.reverse());
            } else if (o instanceof Integer) {
                System.out.println((Integer) o*10);
            } else if (o instanceof Double){
                System.out.println("This is a double: " + o);
            }
        }
    }
}
