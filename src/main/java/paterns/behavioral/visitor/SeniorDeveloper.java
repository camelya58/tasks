package paterns.behavioral.visitor;

/**
 * Class SeniorDeveloper
 *
 * @author Kamila Meshcheryakova
 * created 29.12.2020
 */
public class SeniorDeveloper implements IDeveloper {

    @Override
    public void create(ProjectClass projectClass) {
        System.out.println("Write code with design patterns and correct the classes of junior");
    }

    @Override
    public void create(Test test) {
        System.out.println("Write super functional integration and unit tests, even use groovy");
    }

    @Override
    public void create(Database database) {
        System.out.println("Restore database from data after junior");
    }
}
