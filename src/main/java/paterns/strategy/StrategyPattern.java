package paterns.strategy;

/**
 * Class StrategyPattern demonstrates the realization of strategy pattern,
 * which allows to perform some actions depending on the chosen strategy.
 *
 * @author Kamila Meshcheryakova
 * created 21.12.2020
 */
public class StrategyPattern {

    public static void main(String[] args) {
        Navigator navigator = new Navigator(new CarStrategy());
        navigator.calculatePath();
        navigator.setStrategy(new BicycleStrategy());
        navigator.calculatePath();
        navigator.setStrategy(new WalkStrategy());
        navigator.calculatePath();
    }
}
