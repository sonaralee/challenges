package com.sets;

import java.util.Collection;
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

public abstract class HeavenlyBody implements Comparable {
    private final String name;
    private final BodyTypes bodyType;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public enum BodyTypes {
        MOON,
        PLANET,
        //STAR
    }

    HeavenlyBody(String name, BodyTypes bt, double orbitalPeriod) {
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

    public abstract <T> void addSatellite(T s);

    public abstract <T> Collection<? extends HeavenlyBody> getSatellites();


    @Override
    public final boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }

        if (obj instanceof HeavenlyBody) {
            HeavenlyBody theObj = (HeavenlyBody) obj;
            if(this.name.equals(theObj.getName())) {
                return this.getClass() == theObj.getClass();
            }
        }
        return false;
    }

    @Override
    public final int hashCode() {
        //System.out.println("hashcode called");
        return this.name.hashCode() + 57;
    }

    @Override
    public int compareTo(Object hb) {
        if(orbitalPeriod > ( (HeavenlyBody)hb ).orbitalPeriod) {
            return 1;
        } else if (orbitalPeriod == ( (HeavenlyBody)hb ).orbitalPeriod) {
            return 0;
        } else {
            return -1;
        }
    }
}
