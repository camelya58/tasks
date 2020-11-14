package class_methods;

import java.lang.reflect.InvocationTargetException;

/**
 * Class NewInstance represents the collection of class Class methods such as
 * newInstance(), getName(), isInterface(),
 * getSimpleName(), getCanonicalName(), forName(String str),
 * getInterfaces(), getSuperclass(), getClass().
 *
 * @author Kamila Meshcheryakova
 * created by 30.06.2020
 */
interface HasBatteries {}
interface Waterproof {}
interface Shoots {}

class Toy {
    Toy() {}
    Toy(int i) {}

}
class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
    FancyToy() {super(1);}
}
public class NewInstance {
    static void printInfo(Class cc) {
        // the method getName() returns the whole name
        System.out.println("Name of the class: " + cc.getName() +
                ", is it interface? [" + cc.isInterface() + "]");
        // the method getSimpleName() returns the name without the package
        System.out.println("Simple name: " + cc.getSimpleName());
        // the method getCanonicalName() returns the whole name
        System.out.println("Canonical name: " + cc.getCanonicalName());
    }

    public static void main(String[] args) {
        Class c = null;
        try {
            // allows to get name of class from string
            c = Class.forName("class_methods.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to find FancyToy");
            System.exit(1);
        }
        printInfo(c);
        for(Class face: c.getInterfaces())
            printInfo(face);
        // allows to get the base class of that class
        Class up = c.getSuperclass();
        Object obj = null;
        try {
            // the method newInstance() allows to get another instance of that class
            obj = up.getDeclaredConstructor().newInstance();
        } catch (NoSuchMethodException | SecurityException | InstantiationException e) {
            System.out.println("Failed to create an instance of the class");
            System.exit(1);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
            System.out.println("Access denied");
            System.exit(1);
        }
        printInfo(obj.getClass());
    }
} /* Output:
Name of the class: class_methods.FancyToy, is it interface? [false]
Simple name: FancyToy
Canonical name: class_methods.FancyToy
Name of the class: class_methods.HasBatteries, is it interface? [true]
Simple name: HasBatteries
Canonical name: class_methods.HasBatteries
Name of the class: class_methods.Waterproof, is it interface? [true]
Simple name: Waterproof
Canonical name: class_methods.Waterproof
Name of the class: class_methods.Shoots, is it interface? [true]
Simple name: Shoots
Canonical name: class_methods.Shoots
Name of the class: class_methods.Toy, is it interface? [false]
Simple name: Toy
Canonical name: class_methods.Toy
*/
