package laborator3;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class Node implements Comparable<Node> {
    private String name;
    private String hardwareAddress;
    private String location;
    private String addressIP;
    private Map<Node, Integer> cost = new HashMap<>();

    public Node() {
    }

    public Node(String name) {
        this.name = name;
    }

    public Node(Map<Node, Integer> cost, String name, String hardwareAddress, String addressIP, String location) {
        this.cost = cost;
        this.name = name;
        this.hardwareAddress = hardwareAddress;
        this.location = location;
        this.addressIP = addressIP;
    }

    public Map<Node, Integer> getCost() {
        return cost;
    }

    public void setCost(Map<Node, Integer> cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(Node node, int value) {
        cost.put(node, value);
    }

    public String getAddressIP() {
        return addressIP;
    }

    public void setAddressIP(String addressIP) {
        this.addressIP = addressIP;
    }

    public String getHardwareAddress() {
        return hardwareAddress;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setHardwareAddress(String hardwareAddress) {
        this.hardwareAddress = hardwareAddress;
    }

    @Override
    public String toString() {
        return "(" +
                "name='" + name + "'" +
                ')';
    }

    @Override
    public int compareTo(Node other) {
        if (this.name.isEmpty() || other.name.isEmpty())
            return 0;
        return this.name.compareTo(other.name);
    }
}
