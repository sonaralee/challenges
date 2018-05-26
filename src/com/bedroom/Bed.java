package com.bedroom;

public class Bed {
    private int numPillows;
    private String typePillows;

    public Bed(int np, String tp) {
        this.numPillows = np;
        this.typePillows = tp;
    }

    public void clean() {
        System.out.println("Making the bed using " + numPillows + " " + typePillows + " pillows ... done!");
    }
}
