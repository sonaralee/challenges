package com.sets;

import java.util.HashSet;
import java.util.Set;

public class Planet extends HeavenlyBody{
    private final Set<Moon> moons;

    Planet(String name, String bt, double orbitalPeriod) {
        super(name, bt, orbitalPeriod);
        this.moons = new HashSet<>();
    }

    public Set<? extends HeavenlyBody> getSatellites() {
        return new HashSet<>(this.moons);
    }
}
