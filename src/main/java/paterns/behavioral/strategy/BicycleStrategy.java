package paterns.behavioral.strategy;

/**
 * Класс BicycleStrategy
 *
 * @author Kamila Meshcheryakova
 * created 21.12.2020
 */
public class BicycleStrategy implements Strategy {
    @Override
    public void calculatePath() {
        System.out.println("Calculate path for bicycle");
    }
}
