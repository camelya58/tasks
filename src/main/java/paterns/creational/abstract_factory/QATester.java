package paterns.creational.abstract_factory;

/**
 * Класс QATester
 *
 * @author Kamila Meshcheryakova
 * created 21.09.2020
 */
public class QATester implements Tester{
    @Override
    public void writeTest() {
        System.out.println("Make qa tests");
    }
}
