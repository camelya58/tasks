package paterns.behavioral.visitor;

/**
 * Interface IDeveloper
 *
 * @author Kamila Meshcheryakova
 * created 29.12.2020
 */
public interface IDeveloper {

    void create(ProjectClass projectClass);
    void create(Test test);
    void create(Database database);
}
