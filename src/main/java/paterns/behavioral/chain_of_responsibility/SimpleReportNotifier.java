package paterns.behavioral.chain_of_responsibility;

/**
 * Class SimpleReportNotifier
 *
 * @author Kamila Meshcheryakova
 * created 29.12.2020
 */
public class SimpleReportNotifier extends Notifier {

    public SimpleReportNotifier(int priority) {
        super(priority);
    }

    @Override
    public void write(String message) {
        System.out.println("Notifying using simple report: " + message);
    }
}
