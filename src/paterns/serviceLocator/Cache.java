package paterns.serviceLocator;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Cache allows to add service in cache and receive the service by name.
 *
 * @author Kamila Meshcheryakova
 * created by 07.09.2020
 */
public class Cache {
    private final List<MessagingService> services = new ArrayList<>();

    public MessagingService getService(String serviceName) {
        for (MessagingService service: services) {
            if (service.getServiceName().equals(serviceName)) {
                return service;//retrieve from the list
            }
        }
        throw new RuntimeException("There are not such service");
    }

    public void addService(MessagingService newService) {
        services.add(newService);
        //add to the list
    }
}