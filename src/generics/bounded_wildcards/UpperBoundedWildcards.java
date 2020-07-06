package generics.bounded_wildcards;

import java.util.ArrayList;
import java.util.List;

/**
 * Class UpperBoundedWildcards provides a way to collect classes of different types into one collection:
 * the class and its descendants.
 *
 * @author Kamila Meshcheryakova
 * created by 06.07.2020
 */
class Storage <T extends Book> extends ArrayList<T> {
}
class Book {
    String title;
    String author;
    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}

class Magazine extends Book {
    Magazine(String title, String author) {
        super(title, author);
    }
}

public class UpperBoundedWildcards {
    public static void main(String[] args) {
        Storage<Book> books = new Storage<>();
        Storage<Magazine> magazines = new Storage<>();
        Book book1 = new Book("American tragedy", "Theodore Dreiser");
        Book book2 = new Book("Trilogy of Desire: The Financier. The Titan. The Stoic.", "Theodore Dreiser");
        books.add(book1);
        books.add(book2);
        Magazine magazine1 = new Magazine("Around the World", "Alexander Belayev");
        Magazine magazine2 = new Magazine("People", "Larry Hackett");
        magazines.add(magazine1);
        magazines.add(magazine2);

        List<Storage<?>> storage = new ArrayList<>();
        storage.add(books);
        storage.add(magazines);
        for(Storage<?> s: storage)
        System.out.println(s);
    }
} /* Output:
[generics.bounded_wildcards.Book@6b884d57, generics.bounded_wildcards.Book@38af3868]
[generics.bounded_wildcards.Magazine@77459877, generics.bounded_wildcards.Magazine@5b2133b1]
*/
