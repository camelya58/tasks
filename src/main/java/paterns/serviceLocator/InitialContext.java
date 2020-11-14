package paterns.serviceLocator;

/**
 * Class InitialContext represents the initialization of 2 services.
 *
 * @author Kamila Meshcheryakova
 * created by 07.09.2020
 */
public class InitialContext {
    // allows to initiate the service by name or return null if that service has another name
    public Object lookup(String serviceName) {
        if (serviceName.equalsIgnoreCase("EmailService")) {
            System.out.println("Looking up and creating a new EmailService object");
            return new EmailService();
        } else if (serviceName.equalsIgnoreCase("SMSService")) {
            System.out.println("Looking up and creating a new SMSService object");
            return new SmsService();
        }
        return null;
    }
}