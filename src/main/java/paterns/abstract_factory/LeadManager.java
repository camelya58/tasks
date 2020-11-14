package paterns.abstract_factory;

/**
 * Класс LeadManager
 *
 * @author Kamila Meshcheryakova
 * created 21.09.2020
 */
public class LeadManager implements Manager{
    @Override
    public void manage() {
        System.out.println("Make management");
    }
}
