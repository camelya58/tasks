package paterns.behavioral.iterator;

/**
 * Class IteratorPattern demonstrates the realization of iterator pattern,
 * which allows to create own way to iterate the elements of object.
 *
 * @author Kamila Meshcheryakova
 * created 21.12.2020
 */
public class IteratorPattern {

    public static void main(String[] args) {
        MyCollection collection = new MyCollectionImpl(new String[]{"Max", "Olya", "Vasya", "Yana", "Nikolay", "Anna"});
        MyIterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
