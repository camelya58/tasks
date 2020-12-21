package paterns.iterator;

/**
 * Класс MyCollectionImpl
 *
 * @author Kamila Meshcheryakova
 * created 21.12.2020
 */
public class MyCollectionImpl implements MyCollection {

    private String[] array;

    public MyCollectionImpl(String[] array) {
        this.array = array;
    }

    @Override
    public MyIterator iterator() {
        return new MyIterator() {

            private int pos = array.length - 1;

            @Override
            public boolean hasNext() {
                return pos >= 0;
            }

            @Override
            public Object next() {
                Object object = array[pos];
                pos -=2;
                return object;
            }
        };
    }
}
