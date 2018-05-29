package com.sets;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
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
    private static Map<String, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<Planet> planets = new HashSet<>();

    public static void main(String[] args) {
        Planet temp = new Planet("Mercury", "planet", 88);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new Planet("Venus", "planet", 225);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new Planet("Earth", "planet", 365);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        Moon tempMoon = new Moon("Moon", "moon", 27);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addSatellite(tempMoon);

        temp = new Planet("Mars", "planet", 687);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        tempMoon = new Moon("Deimos", "moon", 1.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Mars

        tempMoon = new Moon("Phobos", "moon", 0.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Mars

        temp = new Planet("Jupiter", "moon", 4332);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        tempMoon = new Moon("Io", "moon", 1.8);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Europa", "moon", 3.5);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Ganymede", "moon", 7.1);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Callisto", "moon", 16.7);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        temp = new Planet("Saturn", "moon", 10759);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new Planet("Uranus", "moon", 30660);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new Planet("Neptune", "moon", 165);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new Planet("Pluto", "moon", 248);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        System.out.println("Planets");
        for(Planet planet : planets) {
            System.out.println("\t" + planet.getName());
        }

        HeavenlyBody body = solarSystem.get("Mars");
        System.out.println("Moons of " + body.getName());
        for(HeavenlyBody m : body.getSatellites()) {
            System.out.println("\t" + m.getName());
        }

        HashSet<HeavenlyBody> moons = new HashSet<>();
        for(Planet planet : planets) {
            moons.addAll(planet.getSatellites());
        }

        System.out.println("All Moons");
        for(HeavenlyBody moon : moons) {
            System.out.println("\t" + moon.getName());
        }

        Planet pluto = new Planet("Pluto", "planet", 842);
        planets.add(pluto);

        for(Planet planet : planets) {
            System.out.println(planet.getName() + ": " + planet.getOrbitalPeriod());
        }

        Object o = new Object();
        o.equals(o);
        "pluto".equals("");



    }
}
