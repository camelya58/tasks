package paterns.creational.factory;

/**
 * Класс CoffeeFactory
 *
 * @author Kamila Meshcheryakova
 * created 21.09.2020
 */
public class CoffeeFactory {

    public Coffee getCoffee(CoffeeType coffeeType) {
        switch (coffeeType) {
            case LATTE: return new Latte();
            case CAPPUCCINO: return new Cappuccino();
            case ESPRESSO: return new Espresso();
            default: return null;
        }
    }
}
