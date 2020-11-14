package generics.bounded_wildcards;

import java.util.ArrayList;
import java.util.List;

/**
 * Class LowerBoundedWildcards provides a way to collect classes of different types into one collection:
 * the class and its ancestors.
 *
 * @author Kamila Meshcheryakova
 * created by 06.07.2020
 */
public class LowerBoundedWildcards {
    public static void main(String[] args) {
        List<? super Magazine> storage;
        Book book1 = new Book("American tragedy", "Theodore Dreiser");
        Book book2 = new Book("Trilogy of Desire: The Financier. The Titan. The Stoic.", "Theodore Dreiser");
        Magazine magazine1 = new Magazine("Around the World", "Alexander Belayev");
        Magazine magazine2 = new Magazine("People", "Larry Hackett");

        List<Book> booksStorage = new ArrayList<>();
        List<Magazine> magazinesStorage = new ArrayList<>();
        booksStorage.add(book1);
        booksStorage.add(book2);
        magazinesStorage.add(magazine1);
        magazinesStorage.add(magazine2);

        storage = booksStorage;
        storage.addAll(magazinesStorage);

        for (Object type: storage){
            System.out.println(type.getClass());
        }
    }
} /* Output:
class generics.bounded_wildcards.Book
class generics.bounded_wildcards.Book
class generics.bounded_wildcards.Magazine
class generics.bounded_wildcards.Magazine
*/
