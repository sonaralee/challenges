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
import java.nio.file.attribute.BasicFileAttributes;

public class Main {

    public static void main(String[] args) {

        try {
//            Path sourceFile = FileSystems.getDefault().getPath("res","data.txt");
//            Path copyFile = FileSystems.getDefault().getPath("res", "data_copy.txt");
//            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);
//
//            sourceFile = FileSystems.getDefault().getPath("res");
//            copyFile = FileSystems.getDefault().getPath("rescopy");
//            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);
            Path file = FileSystems.getDefault().getPath("res","data.txt");
            BasicFileAttributes attrs = Files.readAttributes(file, BasicFileAttributes.class);
            System.out.println((attrs.size()));
            Object i;

        } catch(IOException e) {
            System.out.println("Exception: " + e.getMessage());
        }



//        Path path = FileSystems.getDefault()
//                            .getPath("WorkingDirectory.txt");
//        printFile(path);
//
//        // Path filePath = FileSystems.getDefault().getPath("res", "Subdirectory.txt");
//        Path filePath = Paths.get(".","res", "Subdirectory.txt");
//        printFile(filePath);
//
//        // filePath = Paths.get("C:\\Users\\annal_000\\IdeaProjects\\OutThere.txt");
//        filePath = Paths.get("C:\\", "Users\\annal_000\\IdeaProjects", "OutThere.txt");
//        printFile(filePath);
//
//        filePath = Paths.get(".");
//        System.out.println(filePath.toAbsolutePath());
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
