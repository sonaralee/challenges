package com.interfaces;

import java.util.ArrayList;
import java.util.List;
// Create a few sample classes that implement your Saveable interface (we've used the idea of a game,
// with Players and Monsters, but you can create any type of classes that you want).
//
// Override the toString() method for each of your classes so that they can be easily printed to enable
// the program to be tested easier.

public class Player implements ISaveable {
    private List<String> stats;
    private Integer hp, level;
    private String name;

    public Player(String name) {
        this.stats = new ArrayList<>();
        this.level = 1;
        this.hp = 50;
        this.name = name;
    }

    public List<String> getStats() {
        return this.stats;
    }

    @Override
    public List<String> save() {
        stats.clear();
        stats.add(this.name);
        stats.add(this.level.toString());
        stats.add(this.hp.toString());
        return stats;
    }

    @Override
    public void populate(List<String> list) {
        this.name = list.get(0);
        this.level = Integer.parseInt(list.get(1));
        this.hp = Integer.parseInt(list.get(2));
    }
}
