package paterns.behavioral.chain_of_responsibility;

/**
 * Class SmsNotifier
 *
 * @author Kamila Meshcheryakova
 * created 29.12.2020
 */
public class SmsNotifier extends Notifier {

    public SmsNotifier(int priority) {
        super(priority);
    }

    @Override
    public void write(String message) {
        System.out.println("Sending sms to manager with message: " + message);
    }
}
