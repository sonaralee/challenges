package com.generics;

import java.util.ArrayList;
import java.util.List;

public abstract class Team implements Comparable<Team> {
    private List<Player> players;
    private int numPlayers;
    private int rank, wins, losses;
    private String name;

    public Team(String n) {
        this.name = n;
        this.wins = 0;
        this.losses = 0;
        this.rank = 0;
        this.players = new ArrayList<>();
    }

    public void playGame(Team t, int ourScore, int theirScore) {
        String message;

        if(ourScore > theirScore) {
            wins++;
            //message = " beat ";
        } else if (ourScore == theirScore) {
            //message = " tied with ";
        } else {
            losses++;
            //message = " lost to ";
        }

        if(t != null) {
            //System.out.println(this.getName() + message + t.getName());
            t.playGame(null, theirScore, ourScore);
        }
    }

    public String getName() {
        return this.name;
    }

    public int getRank() {
        return wins*2;
    }

    public void addPlayer(Player lp) {
        this.players.add(lp);
    }

    public void printRoster() {
        System.out.println("Roster for the " + this.getName() + ":");
        for(Player p : players) {
            System.out.println(p.getPosition() + " " + p.getName());
        }
    }

    public abstract int compareTo(Team t);

}
