package homework3;

import java.util.HashMap;
import java.util.Map;

public abstract class Node implements Comparable<Node> {
    private String name;
    private String hardwareAddress;
    private String location;
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

    public String getHardwareAddress() {
        return hardwareAddress;
    }

    public String getAddress() {
        return null;
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

    public String Print(Node n) {

        StringBuilder str = new StringBuilder();
        for (Node node : n.cost.keySet()) {
            if (node.getName().compareTo(n.getName()) > 0) {
                str.append("\n" + n.getName() + " - " + node.getName() + "->");
                str.append(cost.get(node));
            }
        }
        return str.toString();
    }

    @Override
    public String toString() {
        return Print(this);
    }

    @Override
    public int compareTo(Node other) {
        if (this.name.isEmpty() || other.name.isEmpty())
            return 0;
        return this.name.compareTo(other.name);
    }
}
