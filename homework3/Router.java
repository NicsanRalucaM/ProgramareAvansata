package homework3;

public class Router extends Node implements Identifiable {
    private String addressIP;

    public Router() {
    }

    public Router(String name, String addressIP) {
        super(name);
        this.addressIP = addressIP;
    }

    @Override
    public String getAddress() {
        return addressIP;
    }
}
