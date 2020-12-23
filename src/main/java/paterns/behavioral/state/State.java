package paterns.behavioral.state;

/**
 * Interface State
 *
 * @author Kamila Meshcheryakova
 * created 23.12.2020
 */
public interface State {
    void doAction(Context context);
}

class LowerCaseState implements State {

    @Override
    public void doAction(Context context) {
        System.out.println(context.name.toLowerCase());
    }
}

class UpperCaseState implements State {

    @Override
    public void doAction(Context context) {
        System.out.println(context.name.toUpperCase());
    }
}

class Context {
    State state;
    String name;

    public Context(State state, String name) {
        this.state = state;
        this.name = name;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void doAction() {
        state.doAction(this);
    }
}