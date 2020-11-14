package paterns.serviceLocator;

/**
 * Class EmailService represents the realization of MessagingService.
 *
 * @author Kamila Meshcheryakova
 * created by 07.09.2020
 */
public class EmailService implements MessagingService {

    public String getMessageBody() {
        return "email message";
    }

    public String getServiceName() {
        return "EmailService";
    }
}
