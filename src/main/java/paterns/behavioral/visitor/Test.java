package paterns.behavioral.visitor;

/**
 * Class Test
 *
 * @author Kamila Meshcheryakova
 * created 29.12.2020
 */
public class Test implements IProjectElement {

    @Override
    public void beWrittenBy(IDeveloper developer) {
        developer.create(this);
    }
}
