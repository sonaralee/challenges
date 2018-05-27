package com.generics2;

// Create a generic class to implement a league table for a sport.
// The class should allow teams to be added to the list, and store
// a list of teams that belong to the league.
//
// Your class should have a method to print out the teams in order,
// with the team at the top of the league printed first.

import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Team> {
    private ArrayList<T> league = new ArrayList<>();
    private String name;

    public League(String n) {
        this.name = n;
    }

    public void addTeam(T team) {
        if(league.contains(team)) {
            System.out.println("Team " + team.getName() + " already in league.");
        }
        else {
            this.league.add(team);
            System.out.println("Team " + team.getName() + " added to league.");
        }
    }
    public void addTeam(ArrayList<T> ts) {
        for(T team : ts) {
            if (league.contains(team)) {
                System.out.println("Team " + team.getName() + " already in league.");
            } else {
                this.league.add(team);
                System.out.println("Team " + team.getName() + " added to league.");
            }
        }
    }

    public int size() {
        return this.league.size();
    }

    public ArrayList<T> getTeams() {
        return this.league;
    }

    public T getTeamAt(int i) {
        return this.league.get(i);
    }

    public void print() {
        for(T team : league) {
            System.out.println(team.getName());
        }
    }

    public void printInOrder() {
        // order teams by ranking
        Collections.sort(league);
        String winPercent;
        System.out.println("Printing sorted list of teams in: " + this.name);
        for(T team : league) {
            winPercent = team.getRank().toString().replaceFirst("^0\\.", ".");
            System.out.print(team.getName() + " (");
            System.out.printf("%.4s", winPercent);
            System.out.println(")");
        }
    }
}
