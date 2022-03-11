package laborator3;

import java.util.*;

public class Network {
    private List<Node> nodes = new ArrayList<>();

    public Network() {
    }

    public Network(List<Node> nodes) {
        this.nodes = nodes;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    @Override
    public String toString() {
        Collections.sort(nodes);
        return "Network{" +
                "nodes=" + nodes +
                '}';
    }

}