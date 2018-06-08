package com.testing;

public class Main {

    //public static int mult = 5;

    /* TYPE PARAMETERS EXAMPLES
        E - Element (used by collections framework)
        K - Key
        T - Type
        V - Value
        S, U, V, etc - 2nd, 3rd, 4th types
    */
    public static void main(String[] args) {
        IterableList<String> il = new IterableList<>();
        il.add("Hello");
        il.add("Goodbye");
        System.out.println(il);

        for(String item : il) {
            System.out.println(item.toString());
        }

    }

    
}
