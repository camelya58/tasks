package paterns.factory;

/**
 * Класс Cappuccino
 *
 * @author Kamila Meshcheryakova
 * created 21.09.2020
 */
public class Cappuccino implements Coffee {
    @Override
    public void makeCoffee() {
        System.out.println("Make Capuchino");
    }

    @Override
    public void pourIntoCup() {
        System.out.println("Pour capuchino");
    }
}
