package com.sets;

import java.util.*;

// Modify the previous HeavenlyBody example so that the HeavenlyBody
// class also has a "bodyType" field. This field will store the
// type of HeavenlyBody (such as STAR, PLANET, MOON, etc).
//
// You can include as many types as you want, but must support at
// least PLANET and MOON.
//
// For each of the types that you support, subclass the HeavenlyBody class
// so that your program can create objects of the appropriate type.

public abstract class HeavenlyBody implements Comparable<HeavenlyBody> {
    private final Key theKey;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public enum BodyTypes {
        MOON,
        PLANET,
        //STAR
    }

    HeavenlyBody(String name, double orbitalPeriod, BodyTypes bt) {
        this.theKey = new Key(name, bt);
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public Key getKey() {
        return theKey;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Set<HeavenlyBody> getSatellites() {
        return this.satellites;
    }

//    public String printSatellites() {
//        String[] list1 = new String[this.satellites.size()]();
//        String[] list = new String[this.satellites.size()];
//        for(int i = 0; i < this.satellites.size(); i++) {
//            list1[i] = satellites;
//        }
//        return list.toString();
//    }

    public boolean addSatellite(HeavenlyBody hb) {
        return this.satellites.add(hb);
    }

    @Override
    public final boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }

        if (obj instanceof HeavenlyBody) {
            HeavenlyBody theObj = (HeavenlyBody) obj;
            if(this.theKey.equals(theObj.getKey())) {
                return this.getClass() == theObj.getClass();
            }
        }
        return false;
    }

    @Override
    public final int hashCode() {
        //System.out.println("hashcode called");
        return this.theKey.hashCode() + 57;
    }

    @Override
    public int compareTo(HeavenlyBody hb) {
        return Comparators.NAME.compare(this, hb);
    }

    public static Key makeKey(String s, BodyTypes bt) {
        return new Key(s, bt);
    }

    public static final class Key {
        private String name;
        private BodyTypes type;

        Key(String n, BodyTypes bt) {
            this.name = n;
            this.type = bt;
        }

        public String getName() {
            return this.name;
        }

        public BodyTypes getType() {
            return this.type;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + 57 + this.type.hashCode();
        }

        @Override
        public final boolean equals(Object obj) {
            if(this == obj) {
                return true;
            }

            Key newKey = (Key) obj;
            if(this.getName().equals(newKey.getName())) {
                return this.getType() == newKey.getType();
            }
            return false;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }

    public static class Comparators {

        public static Comparator<HeavenlyBody> NAME = new Comparator<HeavenlyBody>() {
            @Override
            public int compare(HeavenlyBody o1, HeavenlyBody o2) {
                return o1.theKey.name.compareTo(o2.theKey.name);
            }
        };
        public static Comparator<HeavenlyBody> TYPE = new Comparator<HeavenlyBody>() {
            @Override
            public int compare(HeavenlyBody o1, HeavenlyBody o2) {
                return o1.theKey.type.compareTo(o2.theKey.type);
            }
        };
    }

    @Override
    public String toString() {
        String tabStr = "";
        if(this.theKey.type == BodyTypes.MOON) {
            tabStr = "\t";
        }
        return tabStr + this.theKey.name + " (" + this.theKey.type + ")";
    }
}
