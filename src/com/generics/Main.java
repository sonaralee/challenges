package com.generics;

import java.util.ArrayList;

//
// Only teams of the same type should be added to any particular
// instance of the league class - the program should fail to compile
// if an attempt is made to add an incompatible team.

public class Main {
    public static void main(String[] args) {
        League nl = new League("National League");
        Team cubs = new BaseballTeam("Cubs");
        Team braves = new BaseballTeam("Braves");
        Team dodgers = new BaseballTeam("Dodgers");
        Team cardinals = new BaseballTeam("Cardinals");

        nl.addTeam(cubs);
        nl.addTeam(braves);
        nl.addTeam(dodgers);
        nl.addTeam(cardinals);

        System.out.println("Current NL teams: ");
        nl.print();

        System.out.println("Playing games...");
        cubs.playGame(dodgers, 10, 2);
        braves.playGame(cardinals, 12, 1);
        cubs.playGame(braves, 4, 3);
        cardinals.playGame(dodgers, 0, 6);
        dodgers.playGame(cardinals, 2, 1);
        nl.printInOrder();
    }
}
