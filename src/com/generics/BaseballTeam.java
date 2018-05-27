package com.generics;

public class BaseballTeam extends Team{
    public BaseballTeam(String name) {
        super(name);
    }

    @Override
    public int compareTo(Team t) {
        if(this.getRank() > t.getRank()) {
            return -1;
        } else if(this.getRank() == t.getRank()) {
            return 1;
        } else return 0;
    }
}
