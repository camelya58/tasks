package paterns.behavioral.mediator;

/**
 * Class MediatorPattern demonstrates the work of mediator pattern, which
 * allows to reduce the complexity and dependencies between tightly coupled objects communicating directly
 * with one another.
 *
 * @author Kamila Meshcheryakova
 * created 23.12.2020
 */
public class MediatorPattern {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();
        ConcreteColleague one = new ConcreteColleague(mediator, "one");
        ConcreteColleague two = new ConcreteColleague(mediator, "two");
        mediator.add(one);
        mediator.add(two);
        ConcreteColleague three = new ConcreteColleague(mediator, "three");
        mediator.add(three);
        three.changeStatus();
        two.changeStatus();
    }
}
