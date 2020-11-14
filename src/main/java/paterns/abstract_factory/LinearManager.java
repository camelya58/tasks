package paterns.abstract_factory;

/**
 * Класс LinearManager
 *
 * @author Kamila Meshcheryakova
 * created 21.09.2020
 */
public class LinearManager implements Manager{
    @Override
    public void manage() {
        System.out.println("Manage");
    }
}
