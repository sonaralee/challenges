package com.generics;

public class Player {
    private String name;
    private String position;

    public Player() {
        this("Default Baseballplayer", "default pos");
    }

    public Player(String n, String p) {
        this.name = n;
        this.position = p;
    }
}
