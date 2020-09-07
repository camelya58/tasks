package paterns.serviceLocator;

/**
 * Class SmsService represents the realization of MessagingService.
 *
 * @author Kamila Meshcheryakova
 * created by 07.09.2020
 */
public class SmsService implements MessagingService {

    public String getMessageBody() {
        return "sms message";
    }

    public String getServiceName() {
        return "SmsService";
    }
}
