package files_path_methods;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Class Files_Path.ReadFromUrl
 *
 * @author Kamila Meshcheryakova
 * created by 29.06.2020
 */
public class ReadFromUrl {
    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt",
                Paths.get("/home/camelya/IdeaProjects/JavaRushTasks"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        URL url = new URL(urlString);
        InputStream is = url.openStream();
        Path fileName = Path.of(urlString).getFileName();
        Path tempFile = Files.createTempFile("temp-", ".tmp");
        try {
            Files.copy(is, tempFile, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println("A download error has occurred.");
        }
        is.close();
        Path resultPath = downloadDirectory.resolve(fileName);
        Files.move(tempFile, resultPath, StandardCopyOption.REPLACE_EXISTING);
        return resultPath;
        // implement this method
    }
}
