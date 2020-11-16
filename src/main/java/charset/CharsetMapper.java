package charset;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Class CharsetMapper demonstrates different charset coding.
 * Args: Windows_1251.txt UTF_8.txt
 *
 * @author Kamila Meshcheryakova
 * created by 16.11.2020
 */
public class CharsetMapper {
    public static void main(String[] args) throws IOException {
        String fileNameForWindows_1251 = args[0];
        String fileNameForUtf_8 = args[1];

        String string = "Я помню чудное мгновенье:\n" +
                "Передо мной явилась ты,\n" +
                "Как мимолетное виденье,\n" +
                "Как гений чистой красоты.\n" +
                "\n" +
                "В томленьях грусти безнадежной,\n" +
                "В тревогах шумной суеты,\n" +
                "Звучал мне долго голос нежный\n" +
                "И снились милые черты.";

        Files.writeString(Paths.get(fileNameForWindows_1251), string, Charset.forName("Windows-1251"));

        byte[] bytes = Files.readAllBytes(Paths.get(fileNameForWindows_1251));
        String phrase = new String(bytes, Charset.forName("Windows-1251"));
        Files.writeString(Paths.get(fileNameForUtf_8), phrase, StandardCharsets.UTF_8);
    }
}
