package paterns.factory;

/**
 * Класс CoffeeFactory
 *
 * @author Kamila Meshcheryakova
 * created 21.09.2020
 */
public class CoffeeFactory {

    public Coffee getCoffee(CoffeeType coffeeType) {
        return switch (coffeeType) {
            case LATTE -> new Latte();
            case CAPPUCCINO -> new Cappuccino();
            case ESPRESSO -> new Espresso();
        };
    }
}
