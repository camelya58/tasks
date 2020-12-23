package paterns.behavioral.strategy;

/**
 * Класс CarStrategy
 *
 * @author Kamila Meshcheryakova
 * created 21.12.2020
 */
public class CarStrategy implements Strategy {

    @Override
    public void calculatePath() {
        System.out.println("Calculate path for car");
    }
}
