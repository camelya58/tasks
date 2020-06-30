package file_methods;

import java.io.File;
import java.util.Objects;

/**
 * Class MethodListFiles represents the way to find the folder of current file
 * and get the names of other files in that folder.
 *
 * @author Kamila Meshcheryakova
 * created by 29.06.2020
 */
public class MethodListFiles {
    public static void main(String[] args) {
        // create current file
        File currentFile = new File("/home/camelya/IdeaProjects/Tasks/cat.txt");

        // find the directory of the current file
        File folder = currentFile.getParentFile();

        // iterate over all files of the desired folder
        for (File file : Objects.requireNonNull(folder.listFiles())) {
            // display the file name without absolute path
            System.out.println(file.getName());
        }
    }
}
