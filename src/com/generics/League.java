package com.generics;

// Create a generic class to implement a league table for a sport.
// The class should allow teams to be added to the list, and store
// a list of teams that belong to the league.
//
// Your class should have a method to print out the teams in order,
// with the team at the top of the league printed first.

import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Team> {
    private ArrayList<T> teams = new ArrayList<>();
    private String name;

    public League(String n) {
        this.name = n;
    }

    public boolean addTeam(T team) {
        if(teams.contains(team)) {
            System.out.println("Team " + team.getName() + " already in league.");
            return false;
        }
        else {
            this.teams.add(team);
            System.out.println("Team " + team.getName() + " added to league.");
            return true;
        }
    }

    public int size() {
        return this.teams.size();
    }

    public ArrayList<T> getTeams() {
        return this.teams;
    }

    public Team getTeamAt(int i) {
        return this.teams.get(i);
    }

    public void print() {
        for(T team : teams) {
            System.out.println(team.getName());
        }
    }

    public void printInOrder() {
        // order teams by ranking
        Collections.sort(teams);
        System.out.println("Printing sorted list of teams in: " + this.name);
        for(T team : teams) {
            System.out.println(team.getName() + " (" + team.getRank() + ")");
        }
    }
}
