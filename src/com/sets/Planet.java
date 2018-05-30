package com.sets;

import java.util.HashSet;
import java.util.Set;

class Planet extends HeavenlyBody{
    private final Set<Moon> moons;

    Planet(String n, double orbitalPeriod) {
        super(n, orbitalPeriod, BodyTypes.PLANET);
        this.moons = new HashSet<>();
    }

    @Override
    public boolean addSatellite(HeavenlyBody hb) {
        return this.moons.add((Moon)hb);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(moons);
    }
}
