package paterns.behavioral.state;

/**
 * Class StatePattern demonstrates the work of state pattern, which
 * allows the object for changing its behavior without changing its class.
 *
 * @author Kamila Meshcheryakova
 * created 23.12.2020
 */
public class StatePattern {
    public static void main(String[] args) {
        Context context = new Context(new LowerCaseState(), "Max");
        context.doAction();
        context.setState(new UpperCaseState());
        context.doAction();
    }
}
