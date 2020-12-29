package paterns.behavioral.chain_of_responsibility;

/**
 * Class EmailNotifier
 *
 * @author Kamila Meshcheryakova
 * created 29.12.2020
 */
public class EmailNotifier extends Notifier {

    public EmailNotifier(int priority) {
        super(priority);
    }

    @Override
    public void write(String message) {
        System.out.println("Sending email with message: " + message);
    }
}
