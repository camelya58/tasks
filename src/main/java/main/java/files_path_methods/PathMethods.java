package main.java.files_path_methods;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Class PathMethods demonstrates such methods of Path as resolve() and relativize().
 *
 * @author Kamila Meshcheryakova
 * created 01.12.2020
 */
public class PathMethods {
    public static void main(String[] args) {
        Path p1 = Paths.get("Users", "igor", "IdeaProjects", "test");
        Path p2 = Paths.get("File.txt");
        // this method allows to join root directory to filename in this directory
        Path result = p1.resolve(p2);
        System.out.println(result);
        // Users/igor/IdeaProjects/test/File.txt

        Path p3 = Paths.get("Users", "igor", "IdeaProjects", "SomeFile.txt");
        // this method allows to construct relative path relatively the given path
        Path relative = result.relativize(p3);
        System.out.println(relative);
        // ../../SomeFile.txt
    }
}
