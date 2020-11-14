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

    // if there is a service in a cache we return the service by name
    public MessagingService getService(String serviceName) {
        for (MessagingService service : services) {
            if (service.getServiceName().equalsIgnoreCase(serviceName)) {
                System.out.println("Return cached  " + serviceName + " object");
                return service;
            }
        }
        return null;
    }

    // check that service is not exist in a cache and add it to cache
    public void addService(MessagingService newService) {
        boolean exists = false;
        for (MessagingService service : services) {
            if (service.getServiceName().equalsIgnoreCase(newService.getServiceName())) {
                exists = true;
            }
        }
        if (!exists) {
            services.add(newService);
        }
    }
}