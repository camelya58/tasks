package paterns.serviceLocator;

/**
 * Class InitialContext represents the initialization of 2 services.
 *
 * @author Kamila Meshcheryakova
 * created by 07.09.2020
 */
public class InitialContext {
    public Object lookup(String serviceName) {
        if (serviceName.equalsIgnoreCase("EmailService")) {
            return new EmailService();
        } else if (serviceName.equalsIgnoreCase("SMSService")) {
            return new SmsService();
        }
        return null;
    }
}