package paterns.structural.proxy.connectors;

public class SimpleConnector implements Connector {
    private final String resourceString;

    public SimpleConnector(String resourceString) {
        this.resourceString = resourceString;
    }

    @Override
    public void connect() {
        System.out.println("Successfully connected to " + resourceString);
    }
}
