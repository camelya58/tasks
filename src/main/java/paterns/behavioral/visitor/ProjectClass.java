package paterns.behavioral.visitor;

/**
 * Class ProjectClass
 *
 * @author Kamila Meshcheryakova
 * created 29.12.2020
 */
public class ProjectClass implements IProjectElement {

    @Override
    public void beWrittenBy(IDeveloper developer) {
        developer.create(this);
    }
}
