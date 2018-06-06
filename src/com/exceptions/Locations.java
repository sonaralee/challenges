package com.exceptions;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        // write data to file
        try (DataOutputStream locFile = new DataOutputStream(new BufferedOutputStream(
                                        new FileOutputStream("locations.dat")))) {
            for(Location l : locations.values()) {
                locFile.writeInt(l.getLocationID());
                locFile.writeUTF(l.getDescription());
                System.out.println("Writing location " + l.getLocationID() + " : "
                                                        + l.getDescription());
                System.out.println("Writing " + (l.getExits().size()-1) + " exit(s).");
                locFile.writeInt(l.getExits().size()-1);
                for(String dir : l.getExits().keySet()) {
                    if(!dir.equalsIgnoreCase("Q")) {
                        System.out.println("\t\t" + dir + "," + l.getExits().get(dir));
                        locFile.writeUTF(dir);
                        locFile.writeInt(l.getExits().get(dir));
                    }
                }
            }
        }
    }

    static {
        // read the locations from file
        try(DataInputStream locFile = new DataInputStream(new BufferedInputStream(
                new FileInputStream("locations.dat")))) {
            boolean eof = false;
            while(!eof) {
                try {
                    Map<String, Integer> exits = new LinkedHashMap<>();
                    int locID = locFile.readInt();
                    String desc = locFile.readUTF();
                    int numExits = locFile.readInt();
                    System.out.println("Read location " + locID + " : " + desc);
                    System.out.println("Found " + numExits + " exits");
                    for (int i = 0; i < numExits; i++) {
                        String dir = locFile.readUTF();
                        int dest = locFile.readInt();
                        exits.put(dir, dest);
                        System.out.println("\t\t" + dir + "," + dest);
                    }
                    Location l = new Location(locID, desc, exits);
                    locations.put(locID, l);
                } catch(EOFException e) {
                    eof = true;
                }
            }
        } catch(IOException e) {
            System.out.println("IO exception!!!!!");
        }


//        try(Scanner sc = new Scanner(new BufferedReader(new FileReader(
//                                                "locations_big.txt")))) {
//            sc.useDelimiter(",");
//            while(sc.hasNextLine()) {
//                int loc = sc.nextInt();
//                sc.skip(sc.delimiter());
//                String description = sc.nextLine();
//                System.out.println("Imported loc: " + loc + ": " + description);
//                Map<String, Integer> tempExit = new HashMap<>();
//                locations.put(loc, new Location(loc, description, tempExit));
//            }
//        } catch(IOException e) {
//            e.printStackTrace();
//        }
//
//        // Now read the exits
//        try (BufferedReader dirFile = new BufferedReader(new FileReader("directions_big.txt"))) {
//            String input;
//            while((input = dirFile.readLine()) != null) {
//                String[] data = input.split(",");
//                int loc = Integer.parseInt(data[0]);
//                String direction = data[1];
//                int destination = Integer.parseInt(data[2]);
//
//                System.out.println(loc + ": " + direction + ": " + destination);
//                Location location = locations.get(loc);
//                location.addExit(direction, destination);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

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