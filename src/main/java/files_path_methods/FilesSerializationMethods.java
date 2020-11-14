package files_path_methods;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Class FilesSerializationMethods contains methods for work with object.
 *
 * @author Kamila Meshcheryakova
 * created 21.10.2020
 */
public class FilesSerializationMethods {

    private Path path;

    public FilesSerializationMethods() {
        try {
            // the method allows to create temp file
            path = Files.createTempFile(null, null);
            // this method delete a file if it already exists
            Files.deleteIfExists(path);
            // this method allows to create a file by path
            Files.createFile(path);
            // this method deletes the file on exit
            path.toFile().deleteOnExit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public long getFileSize() {
        try {
            // get a file size
            return Files.size(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void putEntry(Entry entry) {
        try {
            // allows to get outputStream to path and serialize the object
            OutputStream outputStream = Files.newOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(outputStream);
            oos.writeObject(entry);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Entry getEntry() {
        try {
            // allows to get inputStream from path and deserialize the object
            InputStream inputStream = Files.newInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(inputStream);
            if (getFileSize() == 0) {
                return null;
            } else {
                return (Entry) ois.readObject();
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public void remove() {
        try {
            // allows to delete a file from path
            Files.delete(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
