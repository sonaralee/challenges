package com.burger;

import java.util.ArrayList;

public class Hamburger {
    private String name;
    private Roll roll;
//    private String meat;
    private ArrayList<String> addons;

    public Hamburger(Roll r, ArrayList<String> add) {
        this.name = "Hamburger";
        this.roll = r;
        this.addons = add;
    }

    public Hamburger() {
        // make a standard burger automatically
        this.name = "Our Basic Burger";
        this.roll.setType("white");
        this.addons.add("lettuce");
    }
}
