package com.burger;

public class Roll {
    private String type;

    public Roll(String type) {
        this.type = type;
    }

    public Roll() {
        this.type = "white";
    }

    public void setType(String type) {
        this.type = type;
    }
}
