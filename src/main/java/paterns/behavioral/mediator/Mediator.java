package paterns.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс Mediator
 *
 * @author Kamila Meshcheryakova
 * created 23.12.2020
 */
public interface Mediator {
    void requestAll(Colleague colleague);
}

class ConcreteMediator implements Mediator {

    List<Colleague> colleagues = new ArrayList<>();

    void add(Colleague colleague) {
        colleagues.add(colleague);
    }

    @Override
    public void requestAll(Colleague colleague) {
        colleague.setTrue();
        colleagues.stream().filter(colleague1 -> !colleague1.equals(colleague))
                .forEach(Colleague::setFalse);
    }
}

interface Colleague {
    void setFalse();
    void setTrue();
    void changeStatus();
}

class ConcreteColleague implements Colleague {
    boolean status;
    Mediator mediator;
    String name;

    public ConcreteColleague(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    @Override
    public void setFalse() {
        status = false;
        System.out.println(name + ": My status is False");
    }

    @Override
    public void setTrue() {
        status = true;
        System.out.println(name + ": My status is True");
    }

    @Override
    public void changeStatus() {
      mediator.requestAll(this);
    }
}