package com.car;
// Create a base class called Car

// Now create 3 sub classes for your favorite vehicles.
// Override the appropriate methods to demonstrate polymorphism in use.
// put all classes in the one java file (this one).
public class Main {
    public static void main(String[] args) {
        Car c = new Car("My Car", 6);
        System.out.println(c.toString());
        c.startEngine();
        c.accelerate(20);
        c.brake();
        c.turnOffEngine();

        System.out.println("\n\n");

        Convertible conv = new Convertible();
        System.out.println(conv.toString());
        conv.startEngine();
        conv.accelerate(20);
        conv.putDownRoof();
    }
}
