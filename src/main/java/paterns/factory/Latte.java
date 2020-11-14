package paterns.factory;

/**
 * Класс Latte
 *
 * @author Kamila Meshcheryakova
 * created 21.09.2020
 */
public class Latte implements Coffee {
    @Override
    public void makeCoffee() {
        System.out.println("Make Latte");
    }

    @Override
    public void pourIntoCup() {
        System.out.println("Pour Latte");
    }
}
