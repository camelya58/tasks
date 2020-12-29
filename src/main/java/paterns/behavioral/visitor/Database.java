package paterns.behavioral.visitor;

/**
 * Class Database
 *
 * @author Kamila Meshcheryakova
 * created 29.12.2020
 */
public class Database implements IProjectElement {

    @Override
    public void beWrittenBy(IDeveloper developer) {
        developer.create(this);
    }
}
