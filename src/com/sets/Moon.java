package com.sets;

import java.util.Collection;

class Moon extends HeavenlyBody{
    Moon(String name, BodyTypes bt, double orbitalPeriod) {
        super(name, bt, orbitalPeriod);
    }

    @Override
    public <T> void addSatellite(T s) {
        System.out.println("Nothing to add");
    }

    @Override
    public <T> Collection<? extends HeavenlyBody> getSatellites() {
        return null;
    }
}
