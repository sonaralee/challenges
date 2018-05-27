package com.generics;

import java.util.ArrayList;
import java.util.Random;

//
// Only teams of the same type should be added to any particular
// instance of the league class - the program should fail to compile
// if an attempt is made to add an incompatible team.

public class Main {
    public static void main(String[] args) {
        League<Team> nl = new League<>("National League");
        //League<Team> al = new League<>("American League");
        //ArrayList theTeams = new ArrayList<Team>();
        Team cubs = new BaseballTeam("Cubs");
        Team braves = new BaseballTeam("Braves");
        Team dodgers = new BaseballTeam("Dodgers");
        Team cardinals = new BaseballTeam("Cardinals");

        cubs.addPlayer(new Player("Anthony Rizzo", "1B"));
        cubs.addPlayer(new Player("Kris Bryant", "3B"));
        cubs.addPlayer(new Player("Kyle Hendricks", "P"));
        //cubs.addPlayer(new Player());
        cubs.printRoster();

//        Team yankees = new BaseballTeam("Yankees");
//        theTeams.add(yankees);
//        Team twins = new BaseballTeam("Twins");
//        theTeams.add(twins);
//        Team whitesox = new BaseballTeam("White Sox");
//        theTeams.add(whitesox);
//        Team redsox = new BaseballTeam("Red Sox");
//        theTeams.add(redsox);

        nl.addTeam(cubs);
        nl.addTeam(braves);
        nl.addTeam(dodgers);
        nl.addTeam(cardinals);

//        al.addTeam(theTeams);

        System.out.println("Current NL teams: ");
        nl.print();

        playSeason(nl);
        nl.printInOrder();

//        System.out.println("Current AL teams: ");
//        al.print();
    }

    private static void playSeason(League l) {

        Random rand = new Random();
        final int numGames = 162;
        int i = 0;
        int num, num2, score, score2;

        System.out.println("Playing games...");
        while(i < numGames) {
            num = rand.nextInt(l.size());
            num2 = rand.nextInt(l.size());
            score = rand.nextInt();
            score2 = rand.nextInt();
            if(num == num2) {
                num = rand.nextInt(l.size());
                continue;
            }
            l.getTeamAt(num).playGame(l.getTeamAt(num2), score, score2);
            i++;
        }

//        cubs.playGame(dodgers, 10, 2);
//        braves.playGame(cardinals, 12, 1);
//        cubs.playGame(braves, 4, 3);
//        cardinals.playGame(dodgers, 0, 6);
//        dodgers.playGame(cardinals, 2, 1);
    }
}
