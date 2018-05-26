package com.car;

public class Convertible extends Car {
    private boolean isRoofUp;

    public Convertible() {
        super("My convertible", 8);
        this.isRoofUp = true;
    }

    public void putDownRoof() {
        this.isRoofUp = false;
    }

    @Override
    public void accelerate(int accelBy) {
        super.accelerate(accelBy + 20);
        System.out.println("ZOOOOOOOOOOOOOM!");
    }

    @Override
    public String toString() {
        String s = super.toString();
        s += "\nRoof up? " + this.isRoofUp;
        return s;
    }
}
