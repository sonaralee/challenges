package com.burger;

import java.util.ArrayList;

public class HealthBurger extends Hamburger {
    private Roll roll;
    private ArrayList<String> addons;

    public HealthBurger(ArrayList<String> add) {
        this.roll = new Roll("rye");
        this.addons = add;
    }
}
