package paterns.creational.factory;

/**
 * Class FactoryPattern demonstrates the work of factory pattern, which
 * allows to create different objects depending on some conditions.
 *
 * @author Kamila Meshcheryakova
 * created 23.12.2020
 */
public class FactoryPattern {
    public static void main(String[] args) {
        CoffeeFactory coffeeFactory = new CoffeeFactory();
        CoffeeShop coffeeShop = new CoffeeShop(coffeeFactory);
        coffeeShop.orderCoffee(CoffeeType.CAPPUCCINO);
        coffeeShop.orderCoffee(CoffeeType.LATTE);
        coffeeShop.orderCoffee(CoffeeType.ESPRESSO);
    }
}
