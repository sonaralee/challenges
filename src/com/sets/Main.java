package com.sets;

import java.util.*;
/*
Although astronomers may shudder at this, our solar systems will
allow two bodies to have the same name as long as they are not the
same type of body: so you could have a star called "BetaMinor" and
an asteroid also called "BetaMinor", for example.

Hint: This is much easier to implement for the Set than it is for the Map,
because the Map will need a key that uses both fields.

There is a restriction that the only satellites that planets can have must
be moons. Even if you don't implement a STAR type, though, your program
should not prevent one being added in the future (and a STAR's satellites
can be almost every kind of HeavenlyBody).

Test cases:
1. The planets and moons that we added in the previous video should appear in
the solarSystem collection and in the sets of moons for the appropriate planets.

2. a.equals(b) must return the same result as b.equals(a) - equals is symmetric.

3. Attempting to add a duplicate to a Set must result in no change to the set (so
the original value is not replaced by the new one).

4. Attempting to add a duplicate to a Map results in the original being replaced
by the new object.

5. Two bodies with the same name but different designations can be added to the same set.

6. Two bodies with the same name but different designations can be added to the same map,
and can be retrieved from the map.
*/

public class Main {
        private static Map<HeavenlyBody.Key, HeavenlyBody> solarSystem = new HashMap<>();
        private static Set<HeavenlyBody> planets = new HashSet<>();

        public static void main(String[] args) {
            HeavenlyBody temp = new Planet("Mercury", 88);
            solarSystem.put(temp.getKey(), temp);
            planets.add(temp);

            temp = new Planet("Venus", 225);
            solarSystem.put(temp.getKey(), temp);
            planets.add(temp);

            temp = new Planet("Earth", 365);
            solarSystem.put(temp.getKey(), temp);
            planets.add(temp);

            HeavenlyBody tempMoon = new Moon("Moon", 27);
            solarSystem.put(tempMoon.getKey(), tempMoon);
            temp.addSatellite(tempMoon);

            temp = new Planet("Mars", 687);
            solarSystem.put(temp.getKey(), temp);
            planets.add(temp);

            tempMoon = new Moon("Deimos", 1.3);
            solarSystem.put(tempMoon.getKey(), tempMoon);
            temp.addSatellite(tempMoon); // temp is still Mars

            tempMoon = new Moon("Phobos", 0.3);
            solarSystem.put(tempMoon.getKey(), tempMoon);
            temp.addSatellite(tempMoon); // temp is still Mars

            temp = new Planet("Jupiter", 4332);
            solarSystem.put(temp.getKey(), temp);
            planets.add(temp);

            tempMoon = new Moon("Io", 1.8);
            solarSystem.put(tempMoon.getKey(), tempMoon);
            temp.addSatellite(tempMoon); // temp is still Jupiter

            tempMoon = new Moon("Europa", 3.5);
            solarSystem.put(tempMoon.getKey(), tempMoon);
            temp.addSatellite(tempMoon); // temp is still Jupiter

            tempMoon = new Moon("Ganymede", 7.1);
            solarSystem.put(tempMoon.getKey(), tempMoon);
            temp.addSatellite(tempMoon); // temp is still Jupiter

            tempMoon = new Moon("Callisto", 16.7);
            solarSystem.put(tempMoon.getKey(), tempMoon);
            temp.addSatellite(tempMoon); // temp is still Jupiter

            temp = new Planet("Saturn", 10759);
            solarSystem.put(temp.getKey(), temp);
            planets.add(temp);

            temp = new Planet("Uranus", 30660);
            solarSystem.put(temp.getKey(), temp);
            planets.add(temp);

            temp = new Planet("Neptune", 165);
            solarSystem.put(temp.getKey(), temp);
            planets.add(temp);

            temp = new Planet("Pluto", 248);
            solarSystem.put(temp.getKey(), temp);
            planets.add(temp);

            // solar system with default sort
            System.out.println("The solar system (no sort):");
            for(HeavenlyBody heavenlyBody : solarSystem.values()) {
                System.out.println(heavenlyBody.getKey().getName() + " ("
                        + heavenlyBody.getOrbitalPeriod() + ")");
            }


            // copy solar system to list for sorting
            List<HeavenlyBody> solarList = new ArrayList<>(solarSystem.values());

            // display solar system sorted by name, then type, then orbital period
            solarList.sort(HeavenlyBody.Comparators.NAME);
            System.out.println();
            System.out.println("The solar system (sorted by name/nested moons):");
            for(HeavenlyBody heavenlyBody : solarList) {
                if(heavenlyBody.getKey().getType() == HeavenlyBody.BodyTypes.PLANET) {
                    System.out.println(heavenlyBody);
                    if(heavenlyBody.getSatellites().size() > 0) {
                        System.out.println("\t" + heavenlyBody.printSatellites());
                    }
                }
            }

            solarList.sort(HeavenlyBody.Comparators.TYPE);
            System.out.println();
            System.out.println("The solar system (sorted by type):");
            for(HeavenlyBody heavenlyBody : solarList) {
                System.out.println(heavenlyBody.getKey().getName() + " ("
                                + heavenlyBody.getKey().getType() + ")");
            }


            solarList.sort(HeavenlyBody.Comparators.ORB);
            Collections.reverse(solarList); // sort descending
            System.out.println();
            System.out.println("The solar system (sorted by orbital period):");
            for(HeavenlyBody heavenlyBody : solarList) {
                System.out.println(heavenlyBody.getKey().getName() + " ("
                        + heavenlyBody.getOrbitalPeriod() + ")");
            }
        }
}
