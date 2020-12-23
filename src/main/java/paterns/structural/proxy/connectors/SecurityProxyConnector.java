package paterns.structural.proxy.connectors;


import paterns.structural.proxy.security.SecurityChecker;
import paterns.structural.proxy.security.SecurityCheckerImpl;

/**
 * Class SecurityProxyConnector
 *
 * @author Kamila Meshcheryakova
 * created by 03.11.2020
 */
public class SecurityProxyConnector implements Connector {

    private final SecurityChecker securityChecker = new SecurityCheckerImpl();
    private final SimpleConnector simpleConnector;

    public SecurityProxyConnector(String resourceString) {
        simpleConnector = new SimpleConnector(resourceString);
    }

    @Override
    public void connect() {
        if (securityChecker.performSecurityCheck()) {
            simpleConnector.connect();
        }
    }
}
