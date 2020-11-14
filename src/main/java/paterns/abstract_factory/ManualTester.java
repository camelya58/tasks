package paterns.abstract_factory;

/**
 * Класс ManualTester
 *
 * @author Kamila Meshcheryakova
 * created 21.09.2020
 */
public class ManualTester implements Tester{
    @Override
    public void writeTest() {
        System.out.println("Make tests");
    }
}
