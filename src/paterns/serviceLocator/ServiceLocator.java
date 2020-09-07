package paterns.serviceLocator;

/**
 * Class ServiceLocator allows to initialize and retrieve any services which implements MessageService.
 *
 * @author Kamila Meshcheryakova
 * created by 07.09.2020
 */
public class ServiceLocator {

    private static final Cache cache = new Cache();

    public static MessagingService getService(String serviceName) {

        InitialContext context = new InitialContext();
        MessagingService service1 = (MessagingService) context
                .lookup(serviceName);
        cache.addService(service1);

        MessagingService service = cache.getService(serviceName);

        if (service != null) {
            return service;
        }

        return service1;
    }

    public static void main(String[] args) {
        MessagingService service
                = ServiceLocator.getService("EmailService");
        String email = service.getMessageBody();
        System.out.println(email);

        MessagingService smsService
                = ServiceLocator.getService("SmsService");
        String sms = smsService.getMessageBody();
        System.out.println(sms);

        MessagingService emailService
                = ServiceLocator.getService("EmailService");
        String newEmail = emailService.getMessageBody();
        System.out.println(newEmail);
    }
}
