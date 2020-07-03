package files_path_methods;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/**
 * Class VisitFileFailed represents the way to show the methods of utilite Files.walkFileTree
 * such as visitFile(Path file, BasicFileAttributes attrs), visitFileFailed(Path file, IOException exc).
 *
 * @author Kamila Meshcheryakova
 * created by 02.07.2020
 */
public class VisitFileFailed extends SimpleFileVisitor<Path> {
    @Override
    // allows to add all files which are archived in list
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (file.toString().endsWith(".zip") || file.toString().endsWith(".rar"))
            archived.add(file.toString());
        return super.visitFile(file, attrs);
    }

    @Override
    // allows to add the names of failed file in list
    public FileVisitResult visitFileFailed(Path file, IOException exc) {
        failed.add(file.toString());
        return FileVisitResult.SKIP_SUBTREE;
    }

    public static void main(String[] args) throws IOException {
        EnumSet<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
        final VisitFileFailed solution = new VisitFileFailed();
        Files.walkFileTree(Paths.get("/home/camelya/IdeaProjects"), options, 20, solution);

        List<String> result = solution.getArchived();
        System.out.println("All archived files:");
        for (String path : result) {
            System.out.println("\t" + path);
        }

        List<String> failed = solution.getFailed();
        System.out.println("All failed files:");
        for (String path : failed) {
            System.out.println("\t" + path);
        }
    }

    private final List<String> archived = new ArrayList<>();
    private final List<String> failed = new ArrayList<>();

    public List<String> getArchived() {
        return archived;
    }

    public List<String> getFailed() {
        return failed;
    }
}
