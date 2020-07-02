package class_methods.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * Class GetMethods represents the way to show all methods and constructors of the desired class
 * using such methods as getMethods() and getConstructors()
 *
 * @author Kamila Meshcheryakova
 * created by 02.07.2020
 */
// Args: class_methods.reflection.GetMethods
// Args: class_methods.reflection.GetMethods java.lang.String
public class GetMethods {
    private static final String usage = "usage:\n" + "GetMethods qualified.class.name\n"
            + "To show all methods in class or:\n" + "GetMethods qualified.class.name word\n"
            + "To search for methods involving 'word'";

    private static final Pattern p = Pattern.compile("\\w+\\.");

    public static void main(String[] args) {
        if(args.length < 1) {
            System.out.println(usage);
            System.exit(0);
        }
        int lines = 0;
        try {
            // using the name of class as args[0] you can see all methods and constructors of that class
            Class<?> c = Class.forName(args[0]);
            Method[] methods = c.getMethods();
            Constructor<?>[] constructors = c.getConstructors();
            if(args.length == 1) {
                for(Method method: methods) {
                    System.out.println(p.matcher(method.toString()).replaceAll(""));
                }
                for(Constructor<?> constructor: constructors) {
                    System.out.println(p.matcher(constructor.toString()).replaceAll(""));
                }
                lines = methods.length + constructors.length;
            } else {
                // using the name of class as args[0] and some type like java.lang.String as args[1]
                // you can see all methods of that class having this type in signature
                for(Method method: methods) {
                    if(method.toString().contains(args[1])) {
                        System.out.println(p.matcher(method.toString()).replaceAll(""));
                        lines++;
                    }
                }
                for(Constructor<?> constructor: constructors) {
                    if(constructor.toString().contains(args[1])) {
                        System.out.println(p.matcher(constructor.toString()).replaceAll(""));
                        lines++;
                    }
                }
            }
            System.out.println(lines);
        } catch(ClassNotFoundException e) {
            System.out.println("No such class: " + e);
        }
    }
} /* Output with args 1
public static void main(String[])
public final void wait(long,int) throws InterruptedException
public final void wait() throws InterruptedException
public final native void wait(long) throws InterruptedException
public boolean equals(Object)
public String toString()
public native int hashCode()
public final native Class getClass()
public final native void notify()
public final native void notifyAll()
public GetMethods()
11

Output with args 2:
public static void main(String[])
public String toString()
2
*/
