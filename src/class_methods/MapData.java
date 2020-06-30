package class_methods;

import java.util.LinkedHashMap;

/**
 * Class MapData is supporting class.
 *
 * @author Kamila Meshcheryakova
 * created by 30.06.2020
 */
public class MapData<K, V> extends LinkedHashMap<K, V> {
    // A single Pair Generator:
    public MapData(Generator<Pair<K, V>> gen, int quantity) {
        for (int i = 0; i < quantity; i++) {
            Pair<K, V> p = gen.next();
            put(p.key, p.value);
        }
    }

    // Two separate Generators:
    public MapData(Generator<K> genK, Generator<V> genV, int quantity) {
        for (int i = 0; i < quantity; i++) {
            put(genK.next(), genV.next());
        }
    }

    // A key Generator and a single value:
    public MapData(Generator<K> genK, V value, int quantity) {
        for (int i = 0; i < quantity; i++) {
            put(genK.next(), value);
        }
    }

    // An Iterable and a value Generator:
    public MapData(Iterable<K> genK, Generator<V> genV) {
        for (K key : genK) {
            put(key, genV.next());
        }
    }

    // An Iterable and a single value:
    public MapData(Iterable<K> genK, V value) {
        for (K key : genK) {
            put(key, value);
        }
    }

    // Generic convenience methods:
    public static <K, V> MapData<K, V> map(Generator<Pair<K, V>> gen, int quantity) {
        return new MapData<>(gen, quantity);
    }

    public static <K, V> MapData<K, V> map(Generator<K> genK, Generator<V> genV, int quantity) {
        return new MapData<>(genK, genV, quantity);
    }

    public static <K, V> MapData<K, V> map(Generator<K> genK, V value, int quantity) {
        return new MapData<>(genK, value, quantity);
    }

    public static <K, V> MapData<K, V> map(Iterable<K> genK, Generator<V> genV) {
        return new MapData<>(genK, genV);
    }

    public static <K, V> MapData<K, V> map(Iterable<K> genK, V value) {
        return new MapData<>(genK, value);
    }
}
interface Generator<T> {
    T next();
}
class Pair<K, V> {
    public final K key;
    public final V value;

    public Pair(K k, V v) {
        key = k;
        value = v;
    }
}