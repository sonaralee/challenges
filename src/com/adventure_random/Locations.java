package com.adventure_random;

import java.io.*;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        // using object stream to write serialized file
        try (ObjectOutputStream locFile = new ObjectOutputStream(new BufferedOutputStream(
                                        new FileOutputStream("locations.dat")))) {
            for(Location l : locations.values()) {
                locFile.writeObject(l);
            }
        }
        // using data stream to write to .dat file
//        try (DataOutputStream locFile = new DataOutputStream(new BufferedOutputStream(
//                                        new FileOutputStream("locations.dat")))) {
//            for(Location l : locations.values()) {
//                locFile.writeInt(l.getLocationID());
//                locFile.writeUTF(l.getDescription());
//                System.out.println("Writing location " + l.getLocationID() + " : "
//                                                        + l.getDescription());
//                System.out.println("Writing " + (l.getExits().size()-1) + " exit(s).");
//                locFile.writeInt(l.getExits().size()-1);
//                for(String dir : l.getExits().keySet()) {
//                    if(!dir.equalsIgnoreCase("Q")) {
//                        System.out.println("\t\t" + dir + "," + l.getExits().get(dir));
//                        locFile.writeUTF(dir);
//                        locFile.writeInt(l.getExits().get(dir));
//                    }
//                }
//            }
//        }
    }

    static {
        // read the locations from file
        try(ObjectInputStream locFile = new ObjectInputStream(new BufferedInputStream(
                new FileInputStream("locations.dat")))) {
            boolean eof = false;
            while (!eof) {
                try {
                    Location loc = (Location) locFile.readObject();
                    System.out.println("Read location: " + loc.getLocationID()
                            + " : " + loc.getDescription());
                    System.out.println("Found " + loc.getExits().size()
                            + " exits");
                    locations.put(loc.getLocationID(), loc);
                } catch (EOFException e) {
                    eof = true;
                }
            }
        } catch(InvalidClassException ice) {
            System.out.println("Invalid class exception! " + ice.getMessage());
        } catch(IOException io) {
            System.out.println("IO exception! " + io.getMessage());
        } catch(ClassNotFoundException cnf) {
            System.out.println("Class not found exception! " + cnf.getMessage());
        }
    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();

    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}