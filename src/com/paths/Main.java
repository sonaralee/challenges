package com.paths;

/* files in:
    working directory
    res directory
    outside directory
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        Path path = FileSystems.getDefault()
                            .getPath("WorkingDirectory.txt");
        printFile(path);

        Path subPath = FileSystems.getDefault()
                .getPath("res", "Subdirectory.txt");
        printFile(subPath);

        Path outPath = Paths.get("C:\\Users\\annal_000\\IdeaProjects\\OutThere.txt");
        printFile(outPath);

        subPath = Paths.get(".");
        System.out.println(subPath.toAbsolutePath());
    }

    private static void printFile(Path path) {
        try(BufferedReader fileReader = Files.newBufferedReader(path)) {
            String line;
            while((line = fileReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
