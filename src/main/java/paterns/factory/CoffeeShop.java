package paterns.factory;

/**
 * Класс CoffeShop
 *
 * @author Kamila Meshcheryakova
 * created 21.09.2020
 */
public class CoffeeShop {

    private final CoffeeFactory coffeeFactory;

    public CoffeeShop(CoffeeFactory coffeeFactory) {
        this.coffeeFactory = coffeeFactory;
    }

    public Coffee orderCoffee(CoffeeType coffeeType) {
        Coffee coffee = coffeeFactory.getCoffee(coffeeType);
        coffee.makeCoffee();
        coffee.pourIntoCup();
        return coffee;
    }
 }
