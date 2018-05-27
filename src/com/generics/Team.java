package com.generics;

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
    }

    public void playGame(Team t, int ourScore, int theirScore) {
        String message;

        if(ourScore > theirScore) {
            wins++;
            message = " beat ";
        } else if (ourScore == theirScore) {
            message = " tied with ";
        } else {
            losses++;
            message = " lost to ";
        }

        if(t != null) {
            System.out.println(this.getName() + message + t.getName());
            t.playGame(null, theirScore, ourScore);
        }
    }

    public String getName() {
        return this.name;
    }

    public int getRank() {
        return wins*2;
    }

    public void addPlayers(List<Player> lp) {
        this.players = lp;
    }

    public abstract int compareTo(Team t);

}
