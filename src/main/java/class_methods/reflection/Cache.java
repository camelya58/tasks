package class_methods.reflection;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * Class Cache demonstrates reflection methods to get new Instance from constructor and private method.
 *
 * @author Kamila Meshcheryakova
 * created 05.10.2020
 */
public class Cache<K,V> {
    private final Map<K,V> cache = new WeakHashMap<>();

    public V getByKey(K key, Class<V> clazz) throws Exception {
        V value = cache.get(key);
        if (value == null) {
            value = clazz.getDeclaredConstructor(key.getClass()).newInstance(key);
            cache.put(key, value);
        }
        return value;
    }

    @SuppressWarnings("unchecked")
    public boolean put(V obj) {
        try {
            Method method = obj.getClass().getDeclaredMethod("getKey");
            method.setAccessible(true);
            K key = (K) method.invoke(obj);
            cache.put(key, obj);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public int size() {
        return cache.size();
    }
}

class Solution {
    public static void main(String[] args) throws Exception {
        SomeKey someKey = new SomeKey();
        someKey.name = "test";

        SomeKey newKey = new SomeKey();
        newKey.name = "newTest";

        SomeValue value = new SomeValue(someKey);

        Cache<SomeKey, SomeValue> cache = new Cache<>();
        System.out.println(cache.put(value));
        System.out.println(cache.put(value));

        SomeValue existingValueFromCache = cache.getByKey(someKey, SomeValue.class);
        System.out.println(existingValueFromCache);

        SomeValue newValue = cache.getByKey(newKey, SomeValue.class);
        System.out.println(newValue);
        System.out.println(cache.size());
    }
}


class SomeKey {
    String name;

    @Override
    public String toString() {
        return "SomeKey{" +
                "name='" + name + '\'' +
                '}';
    }
}
@SuppressWarnings("unused")
class SomeValue {
    private SomeKey key;

    public SomeValue() {
    }

    public SomeValue(SomeKey key) {
        this.key = key;
    }

    private SomeKey getKey() {
        return key;
    }

    @Override
    public String toString() {
        return "SomeValue{" +
                "key=" + key +
                '}';
    }
}
