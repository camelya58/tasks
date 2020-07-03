package files_path_methods;

import java.io.IOException;
import java.util.List;
import  java.nio.file.*;
import  java.nio.charset.*;

/**
 * Class ReadAndWriteMethods represents the way to use own realization of methods of class Files
 * such as readAllBytes(Path path), readAllLinesPath path, Charset chs), write(Path path, byte[] bytes),
 * copy(Path resource, Path destination, CopyOption options).
 *
 * @author Kamila Meshcheryakova
 * created by 02.07.2020
 */
public class ReadAndWriteMethods {
    public static byte[] readBytes(String fileName) throws IOException {
        // the method readAllBytes(Path path) allows to read the array of bytes from file
        return Files.readAllBytes(Paths.get(fileName));
    }

    public static List<String> readLines(String fileName) throws IOException {
        // the method readAllLinesPath path, Charset chs) allows to read the list of strings from file
        // using encoding UTF-8
        return Files.readAllLines(
                Paths.get(fileName), StandardCharsets.UTF_8);
    }

    public static void writeBytes(String fileName, byte[] bytes) throws IOException {
        // the method write(Path path, byte[] bytes) allows to write the array of bytes to file
        Files.write(Paths.get(fileName), bytes);
    }

    public static void copy(String resourceFileName, String destinationFileName) throws IOException {
        // the method copy(Path resource, Path destination, CopyOption options) allows to copy one file to another place
        // StandardCopyOption.REPLACE_EXISTING allows to avoid FileAlreadyExistsException
        Files.copy(Paths.get(resourceFileName), Paths.get(destinationFileName),
                StandardCopyOption.REPLACE_EXISTING);
    }

    public static void main(String[] args) throws IOException {
        byte[] bytes = readBytes("secretPasswords.txt");
        System.out.println(java.util.Arrays.toString(bytes));
        System.out.println(readLines("secretPasswords.txt"));
        writeBytes("SomeFile.txt", bytes);
        copy("SomeFile.txt", "AnotherFile.txt");
    }
}
