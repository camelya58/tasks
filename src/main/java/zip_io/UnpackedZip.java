package zip_io;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Class UnpackedZip demonstrates how to unpack the zip file.
 *
 * @author Kamila Meshcheryakova
 * created 01.12.2020
 */
public class UnpackedZip {
    public static void main(String[] args) throws IOException {
        Path zipFile = Paths.get("C:","Users", "Игорь", "IdeaProjects", "demo.zip");
        Path outputFolder =  Paths.get("C:","Users", "Игорь", "IdeaProjects", "unpacked2");
        if (Files.notExists(zipFile) || !zipFile.toString().endsWith(".zip"))
            throw new RuntimeException("It's not a zip file");
        if (Files.notExists(outputFolder)) {
            Files.createDirectories(outputFolder);
        }
        try (ZipInputStream zipInputStream = new ZipInputStream(Files.newInputStream(zipFile))) {
            ZipEntry zipEntry;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                Path entryPath = outputFolder.resolve(zipEntry.getName());
                if (Files.notExists(entryPath)) {
                    Files.createDirectories(entryPath.getParent());
                    Files.createFile(entryPath);
                }
                try (OutputStream os = Files.newOutputStream(entryPath)) {
                    byte[] buffer = new byte[8 * 1024];
                    int len;
                    while ((len = zipInputStream.read(buffer)) > 0) {
                        os.write(buffer, 0, len);
                    }
                }
                zipInputStream.closeEntry();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
