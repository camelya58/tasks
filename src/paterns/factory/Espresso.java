package paterns.factory;

/**
 * Класс Espresso
 *
 * @author Kamila Meshcheryakova
 * created 21.09.2020
 */
public class Espresso implements Coffee {
    @Override
    public void makeCoffee() {
        System.out.println("Make Espresso");
    }

    @Override
    public void pourIntoCup() {
        System.out.println("Pour Espresso");
    }
}
