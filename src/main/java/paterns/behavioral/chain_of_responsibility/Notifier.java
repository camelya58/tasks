package paterns.behavioral.chain_of_responsibility;

/**
 * Class Notifier represents the request handler which allows to notify manager using special message
 * depends on the situation priority.
 *
 * @author Kamila Meshcheryakova
 * created 29.12.2020
 */
public abstract class Notifier {

    private int priority;
    private Notifier nextNotifier;

    public Notifier(int priority) {
        this.priority = priority;
    }

    public void setNextNotifier(Notifier nextNotifier) {
        this.nextNotifier = nextNotifier;
    }

    public void notifyManager(String message, int level) {
        if (level >= priority) {
            write(message);
        }
        if (nextNotifier != null) {
            nextNotifier.notifyManager(message, level);
        }
    }

    public abstract void write(String message);
}
