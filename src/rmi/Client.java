package rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Class Client
 * Package rmi is a client for connecting to server in hometasks project package rmi.
 *
 * @author Kamila Meshcheryakova
 * created by 01.09.2020
 */
public class Client {
    public static final String UNIC_BINDING_NAME = "server.reverse";

    public static void main(String[] args) throws Exception {
        //get shared object registry
        final Registry registry = LocateRegistry.getRegistry(2099);

        //receive an object - proxy-object
        Reverse service = (Reverse) registry.lookup(UNIC_BINDING_NAME);

        //invoke remoted method
        String result = service.reverse("Home sweet home.");
        System.out.println(result);
    }
}
