package paterns.structural.proxy;

import paterns.structural.proxy.connectors.Connector;
import paterns.structural.proxy.connectors.SecurityProxyConnector;
import paterns.structural.proxy.connectors.SimpleConnector;

/**
 * Class ProxyPattern demonstrates the work of proxy pattern, which
 * allows to act as a layer between the client and the real service object.
 * The proxy receives calls from the client, performs its function (access control, caching, changing the request, etc.),
 * and then passes the call to the service object.
 *
 * @author Kamila Meshcheryakova
 * created by 03.11.2020
 */
public class ProxyPattern {
    public static void main(String[] args) {
        Connector securityProxyConnector = new SecurityProxyConnector("google.com");
        Connector simpleConnector = new SimpleConnector("javarush.ru");

        System.out.println("Connecting with SimpleConnector...");
        simpleConnector.connect();

        System.out.println("----------------------------------------------------");

        System.out.println("Connecting with SecurityProxyConnector...");
        securityProxyConnector.connect();
    }
}
