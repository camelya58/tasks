package paterns.behavioral.chain_of_responsibility;

/**
 * Class ChainOfResponsibilityPattern demonstrates the work of chain of responsibility pattern, which
 * allows to handle the request by yourself or to hand over the request to next handler.
 *
 * @author Kamila Meshcheryakova
 * created 29.12.2020
 */
public class ChainOfResponsibilityPattern {
    public static void main(String[] args) {
        Notifier simpleReportNotifier = new SimpleReportNotifier(Priority.NORMAL);
        Notifier emailNotifier = new EmailNotifier(Priority.IMPORTANT);
        Notifier smsNotifier = new SmsNotifier(Priority.CRITICAL);

        simpleReportNotifier.setNextNotifier(emailNotifier);
        emailNotifier.setNextNotifier(smsNotifier);

        simpleReportNotifier.notifyManager("Everything is Ok.", Priority.NORMAL);
        simpleReportNotifier.notifyManager("Something went wrong!", Priority.IMPORTANT);
        simpleReportNotifier.notifyManager("SOS!!", Priority.CRITICAL);
    }
}
