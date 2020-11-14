package class_methods.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.List;

/**
 * Class ConstructorReflection demonstrates how to use reflection to find special class which:
 * - implements List;
 * - is public static class of Collections;
 * - throws IndexOutOfBoundException in the method - get(index).
 *
 * @author Kamila Meshcheryakova
 * created 09.10.2020
 */
public class ConstructorReflection {

    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    private static Class getExpectedClass() {
        Class[] classes = Collections.class.getDeclaredClasses();
        for (Class c : classes) {
            int mods = c.getModifiers();
            if (List.class.isAssignableFrom(c)
                    && Modifier.isPrivate(mods)
                    && Modifier.isStatic(mods)) {
                try {
                    Constructor constructor = c.getDeclaredConstructor();
                    constructor.setAccessible(true);
                    try {
                        List list = (List) constructor.newInstance();
                        list.get(0);
                    } catch (IndexOutOfBoundsException e) {
                        return c;
                    }
                } catch (Exception e) {
                        continue;
                }
            }

        }
        return null;
    }
}
