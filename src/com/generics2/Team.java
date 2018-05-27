package com.generics2;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Team<T extends Player> implements Comparable<Team<T>> {
    private List<T> players;
    private int numPlayers;
    private Double wins, losses, gamesPlayed;
    private Double rank;
    private String name;

    public Team(String n) {
        this.name = n;
        this.wins = 0.0;
        this.losses = 0.0;
        this.rank = 0.0;
        this.gamesPlayed = 0.0;
        this.players = new ArrayList<>();
    }

    public void playGame(Team<T> t, int ourScore, int theirScore) {
        //String message;
        gamesPlayed++;

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

    public Double getRank() {
        //DecimalFormat form = new DecimalFormat(".###");
        //return Double.parseDouble(form.format(wins/gamesPlayed));
        return wins/gamesPlayed;
    }

    public Double getGamesPlayed(){
        return gamesPlayed;
    }


    public void addPlayer(T lp) {
        this.players.add(lp);
    }

    public void printRoster() {
        System.out.println("Roster for the " + this.getName() + ":");
        for(Player p : players) {
            System.out.println(p.getPosition() + " " + p.getName());
        }
    }

    @Override
    public int compareTo(Team<T> t) {
        if(this.getRank() > t.getRank()) {
            return -1;
        } else if(this.getRank() == t.getRank()) {
            return 1;
        } else return 0;
    }

}
