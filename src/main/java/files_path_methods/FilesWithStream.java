package files_path_methods;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class FilesWithStream represents to way to use Stream API to change data from file
 * using the method Files.lines(Path path, StandardCharsets.UTF_8).
 *
 * @author Kamila Meshcheryakova
 * created by 06.07.2020
 */
public class FilesWithStream {
    public static void main(String[] args) throws IOException {
        // Files.lines allows to read all lines from a file as a Stream
        Stream<String> stream = Files.lines(
                Paths.get("/home/camelya/IdeaProjects/JavaRushTasks/AnotherFile.txt"));
/*
Я помню чудное мгновенье:
Передо мной явилась ты,
Как мимолетное виденье,
Как гений чистой красоты.

В томленьях грусти безнадежной,
В тревогах шумной суеты,
Звучал мне долго голос нежный
И снились милые черты.
 */
        List<String> result  = stream
                .filter(line -> line.startsWith("Как"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        result.forEach(System.out::println);
    }
} /* Output:
КАК МИМОЛЕТНОЕ ВИДЕНЬЕ,
КАК ГЕНИЙ ЧИСТОЙ КРАСОТЫ.
*/
