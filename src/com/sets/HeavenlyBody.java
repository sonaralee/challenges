package com.sets;

import java.util.HashSet;
import java.util.Set;

// Modify the previous HeavenlyBody example so that the HeavenlyBody
// class also has a "bodyType" field. This field will store the
// type of HeavenlyBody (such as STAR, PLANET, MOON, etc).
//
// You can include as many types as you want, but must support at
// least PLANET and MOON.
//
// For each of the types that you support, subclass the HeavenlyBody class
// so that your program can create objects of the appropriate type.

public class HeavenlyBody {
    private final String name;
    private final String bodyType;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public HeavenlyBody(String name, String bt, double orbitalPeriod) {
        this.name = name;
        this.bodyType = bt;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addSatellite(HeavenlyBody s) {
        return this.satellites.add(s);
    }

    public Set<? extends HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }


    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }

        System.out.println("obj.getClass() is " + obj.getClass());
        System.out.println("this.getClass() is " + this.getClass());
        if ((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }

        String objName = ((HeavenlyBody) obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public int hashCode() {
        System.out.println("hashcode called");
        return this.name.hashCode() + 57;
    }
}