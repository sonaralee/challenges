package com.sets;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

class Planet extends HeavenlyBody{
    private final Set<Moon> moons;

    Planet(String name, BodyTypes bt, double orbitalPeriod) {
        super(name, bt, orbitalPeriod);
        this.moons = new HashSet<>();
    }

    @Override
    public <T> void addSatellite(T s) {
        this.moons.add((Moon)s);
    }

    public Collection<? extends HeavenlyBody> getSatellites() {
        return new HashSet<>(moons);
    }
}
