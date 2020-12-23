package paterns.structural.flyweight;

/**
 * Class FlyWeightPattern demonstrates the work of flyweight pattern, which
 * allows to optimize the creation of already existed objects.
 * Saves memory by sharing the common state, rendered in one object, between many objects.
 *
 * @author Kamila Meshcheryakova
 * created 23.12.2020
 */
public class FlyWeightPattern {
    public static void main(String[] args) {
        Storage storage = new Storage();
        Mercedes mercedes = storage.getCar("green");
        Mercedes mercedes2 = storage.getCar("green");
        System.out.println(mercedes.hashCode());
        System.out.println(mercedes2.hashCode());
    }
}
