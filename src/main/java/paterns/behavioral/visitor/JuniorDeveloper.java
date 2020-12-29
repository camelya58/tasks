package paterns.behavioral.visitor;

/**
 * Class JuniorDeveloper
 *
 * @author Kamila Meshcheryakova
 * created 29.12.2020
 */
public class JuniorDeveloper implements IDeveloper {
    @Override
    public void create(ProjectClass projectClass) {
        System.out.println("Write code without using design patterns");
    }

    @Override
    public void create(Test test) {
        System.out.println("Write unworkable tests");
    }

    @Override
    public void create(Database database) {
        System.out.println("Drop database");
    }
}
