package paterns.behavioral.strategy;

/**
 * Класс Navigator
 *
 * @author Kamila Meshcheryakova
 * created 21.12.2020
 */
public class Navigator {

    private Strategy strategy;

    public Navigator(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void calculatePath() {
        strategy.calculatePath();
    }
}
