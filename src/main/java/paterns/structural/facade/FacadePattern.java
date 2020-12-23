package paterns.structural.facade;

/**
 * Class FacadePattern demonstrates the work of facade pattern, which
 * allows to hide a difficult realization and give a simple realization instead.
 *
 * @author Kamila Meshcheryakova
 * created by 24.08.2020
 */
public class FacadePattern {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.run();
    }
}
