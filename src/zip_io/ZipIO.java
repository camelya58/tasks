package zip_io;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * Class ZipIO allows to add new file to existing archive using ZipInputStream and ZipOutputStream.
 *
 * @author Kamila Meshcheryakova
 * created by 03.07.2020
 */
 // Args:
// args[0] -  C:/SomeFile.txt - file
//args[1] - C:/pathToTest/test.zip - archive
public class ZipIO {
    public static void main(String[] args) throws IOException {
        // creates map for name of ZipEntry and byte stream with ZipEntry content
        Map<String, ByteArrayOutputStream> map = new HashMap<>();
        // creates a zip stream to read from archive
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(args[1]))) {
            ZipEntry entry;
            // if archive hasn't another file then stop
            while ((entry = zis.getNextEntry()) != null) {
                // creates byte stream
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                // creates byte array
                byte[] bytes = new byte[1024*1024];
                int count;
                // reads up bytes of data from this input stream into an array of bytes
                while ((count = zis.read(bytes)) != -1) {
                    // writes len bytes from the specified byte array starting at offset off to this ByteArrayOutputStream
                    baos.write(bytes, 0, count);
                }
                map.put(entry.getName(), baos);
                baos.close();
                zis.closeEntry();
            }
        }

        // creates a zip stream to write in archive
        try (ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(args[1]))) {
            // get simple filename
            String fileName = args[0].substring(args[0].lastIndexOf("/") + 1);
            // get path from string
            Path newFile = Paths.get(args[0]);

            for (Map.Entry<String, ByteArrayOutputStream> pair :map.entrySet()) {
                // checks the equality of names newFile and files from archive
                // if they aren't equal add zipEntry to archive
                if (fileName.equals(pair.getKey().substring(pair.getKey().lastIndexOf("/") + 1))) continue;
                // creates a new ZipEntry using existing names
                zip.putNextEntry(new ZipEntry(pair.getKey()));
                // write data to zipEntry
                zip.write(pair.getValue().toByteArray());
            }

            ZipEntry newEntry = new ZipEntry("new/" + fileName);
            zip.putNextEntry(newEntry);
            Files.copy(newFile,zip);
            zip.closeEntry();
        }
    }
}
