package paterns.serviceLocator;

/**
 * Class ServiceLocator allows to initialize and retrieve any services which implements MessageService.
 *
 * @author Kamila Meshcheryakova
 * created by 07.09.2020
 */
public class ServiceLocator {

    private static final Cache cache = new Cache();

    // allows to get service from a cache by name
    // if it doesn't exist in a cache, service is created and than added to a cache
    public static MessagingService getService(String serviceName) {
        MessagingService service = cache.getService(serviceName);
        if (service != null) {
            return service;
        }
        InitialContext context = new InitialContext();
        MessagingService service1 = (MessagingService) context
                .lookup(serviceName);
        cache.addService(service1);
        return service1;
    }

    public static void main(String[] args) {
        MessagingService service
                = ServiceLocator.getService("EmailService");
        System.out.println(service.getMessageBody());

        MessagingService smsService
                = ServiceLocator.getService("SmsService");
        System.out.println(smsService.getMessageBody());

        MessagingService emailService
                = ServiceLocator.getService("EmailService");
        System.out.println(emailService.getMessageBody());
    }
}
