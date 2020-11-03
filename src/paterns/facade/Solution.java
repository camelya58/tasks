package paterns.facade;

/**
 * Pattern Facade allows to hide a difficult realization and give a simple realization instead.
 */
public class Solution {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.run();
    }
}
