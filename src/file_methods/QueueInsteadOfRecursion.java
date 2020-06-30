package file_methods;

import java.io.File;
import java.util.*;

/**
 * Class QueueInsteadOfRecourse represents the way to get list of files without using recursion
 * with help of Queue.
 *
 * @author Kamila Meshcheryakova
 * created by 29.06.2020
 */
public class QueueInsteadOfRecursion {

    /**
     * This method allows to get list of files in directory include files in subdirectories using Queue.
     *
     * @param root current directory
     * @return list of files
     */
    public static List<String> getFileTree(String root) {
        // create a directory by the received name
        File rootDir = new File(root);
        // create result list for files
        List<String> result = new ArrayList<>();
        // create a queue for files
        Queue<File> fileTree = new PriorityQueue<>();

        // add all files of the current directory in a queue
        Collections.addAll(fileTree, Objects.requireNonNull(rootDir.listFiles()));

        // if the queue is not empty
        while (!fileTree.isEmpty())
        {
            // the method "remove" retrieve and remove the file
            File currentFile = fileTree.remove();
            // if current file is a directory add this file to a queue
            if(currentFile.isDirectory()){
                Collections.addAll(fileTree, Objects.requireNonNull(currentFile.listFiles()));
            }
            // if current file is a file add this file in a list
            else {
                result.add(currentFile.getAbsolutePath());
            }
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(getFileTree("/home/camelya/IdeaProjects/Tasks/checks"));

    }
}
