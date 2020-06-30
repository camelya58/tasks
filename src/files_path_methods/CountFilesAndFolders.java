package files_path_methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/**
 * Class Files.CountFilesAndFolders contains utilite Files.walkFileTree.
 *
 * @author Kamila Meshcheryakova
 * created 26.06.2020
 */
public class CountFilesAndFolders {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine(); // "/home/camelya/IdeaProjects/save"
        reader.close();

        Path pathDirectory = Paths.get(line);
        if (!Files.isDirectory(pathDirectory)) {
            System.out.println(pathDirectory + " - is not a folder");
        } else {
            SearchFileVisitor searchFileVisitor = new SearchFileVisitor();
            Files.walkFileTree(pathDirectory, searchFileVisitor);
            List<Path> foundFiles = searchFileVisitor.foundFiles;
            List<Path> foundFolders = searchFileVisitor.foundFolders;
            System.out.println("Total folders - " + (foundFolders.size()-1));
            System.out.println("Total files - " + foundFiles.size());
            System.out.println("Total size - " + searchFileVisitor.totalSize);
        }
    }
    static class SearchFileVisitor extends SimpleFileVisitor<Path> {

        private final List<Path> foundFiles = new ArrayList<>();
        private final List<Path> foundFolders = new ArrayList<>();
        private int totalSize;

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
            foundFolders.add(dir); // it counts all folders including the start folder
            return FileVisitResult.CONTINUE;
        }
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            foundFiles.add(file);
            totalSize += Files.size(file);
            return FileVisitResult.CONTINUE;
        }
    }
}
