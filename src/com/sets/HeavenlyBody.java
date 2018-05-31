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

    Key getKey() {
        return theKey;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Set<HeavenlyBody> getSatellites() {
        return this.satellites;
    }

    StringBuilder printSatellites() {
        StringBuilder sb = new StringBuilder();
        for(HeavenlyBody hb : this.getSatellites()) {
            //System.out.println(hb.getKey().getName());
            sb.append(hb.getKey().getName()).append(" ");
        }
        return sb;

        //String
        //for(Object s : satellites) {
        //    System.out.println(((HeavenlyBody)s).getKey().getName());
        //}
//        String[] list1 = new String[this.satellites.size()]();
//        String[] list = new String[this.satellites.size()];
//        for(int i = 0; i < this.satellites.size(); i++) {
//            list1[i] = satellites;
//        }
//        return list.toString();
    }

    public void addSatellite(HeavenlyBody hb) {
        this.satellites.add(hb);
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

    static Key makeKey(String s, BodyTypes bt) {
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

    static class Comparators {

        static Comparator<HeavenlyBody> NAME =
                Comparator.comparing(o -> o.theKey.name);

        static Comparator<HeavenlyBody> TYPE =
                Comparator.comparing(o -> o.theKey.type);

        static Comparator<HeavenlyBody> ORB =
                Comparator.comparing(HeavenlyBody::getOrbitalPeriod);
    }

    @Override
    public String toString() {
        return this.theKey.name;
    }
}
