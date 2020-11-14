package file_methods;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Class ListFilesWithRecursion represents the methods of class File,
 * such as listFiles which allows to get information from all files and folders in current directory.
 *
 * @author Kamila Meshcheryakova
 * created by 29.06.2020
 */
public class ListFilesWithRecursion {
    public static void main(String[] args) throws IOException {
        File path = new File("/home/camelya/IdeaProjects/Tasks/checks");
        File resultFileAbsolutePath = new File("/home/camelya/IdeaProjects/Tasks/checks/result.txt");

        File destination = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");
        if (FileUtils.isExist(resultFileAbsolutePath)) {
            FileUtils.renameFile(resultFileAbsolutePath, destination);
        }
        resultFileAbsolutePath = destination;
        // find all files matching the request
        LinkedHashMap<File, String> nameFiles = makeMapOfFiles(path, resultFileAbsolutePath);

        // sort map by value (files names)
        LinkedHashMap<File, String> sortedMap = nameFiles.entrySet().stream().
                sorted(Map.Entry.comparingByValue()).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));

        // create a streaming writer to the selected file
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(resultFileAbsolutePath)));
        // read the information line by line from each file of the map sorted by file name
        for (Map.Entry<File, String> pair: sortedMap.entrySet()) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(pair.getKey())));
            while (reader.ready()){
                String text = reader.readLine();
                writer.write(text);
            }
            reader.close();
            writer.write("\n");
        }
        writer.close();
    }

    /**
     * This method allows to get map with all files which size is less than 50 and theirs file names
     * using the recursion.
     *
     * @param path current directory
     * @param destination the file to save text from all filtered files
     * @return map with filtered files and files names
     */
    public static LinkedHashMap<File, String> makeMapOfFiles(File path, File destination) {
        LinkedHashMap<File, String> nameFiles = new LinkedHashMap<>();
        for (File file : Objects.requireNonNull(path.listFiles())) {
            if (file.getName().equals(destination.getName())) continue;
            if (file.isDirectory()) {
                nameFiles.putAll(makeMapOfFiles(file, destination));
            } else {
                if (file.length() <= 50) {
                    nameFiles.put(file, file.getName());
                }
            }
        }
        return nameFiles;
    }
    @SuppressWarnings("unused")
    public static class FileUtils {

        public static void deleteFile(File file) {
            if (!file.delete()) System.out.println("Can not delete file with name " + file.getName());
        }

        /**
         * This method is used to rename a file to a different name.
         * @param source old filename
         * @param destination nea filename
         */
        public static void renameFile(File source, File destination) {
            if (!source.renameTo(destination)) System.out.println("Can not rename file with name " + source.getName());
        }

        public static boolean isExist(File file) {
            return file.exists();
        }
    }

}
