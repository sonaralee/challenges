package com.interfaces;

import java.util.ArrayList;
import java.util.List;
// Create a few sample classes that implement your Saveable interface (we've used the idea of a game,
// with Players and Monsters, but you can create any type of classes that you want).
//
// Override the toString() method for each of your classes so that they can be easily printed to enable
// the program to be tested easier.

public class Player implements ISaveable {
    private List<String> theList;
    private Integer hp, level;
    private String name;

    public Player(String name) {
        this.level = 1;
        this.hp = 50;
        this.name = name;
    }

    @Override
    public List<String> save() {
        //theList = new ArrayList()
        return theList;
    }

    @Override
    public void populate(List<String> theList) {

    }
}
