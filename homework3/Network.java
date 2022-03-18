package homework3;

import java.util.*;

public class Network {
    private List<Node> nodes = new ArrayList<>();
    private List<Node> nodesIdentifiable = new ArrayList<>();

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

    public List<Node> getNodesIdentifiable() {
        return nodesIdentifiable;
    }

    @Override
    public String toString() {
        Collections.sort(nodes);
        return "Network{" +
                nodes +
                '}';
    }

    public String print() {
        for (Node e : nodes)
            if (e.getAddress() != null)
                nodesIdentifiable.add(e);
        Collections.sort(nodesIdentifiable, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.getAddress().compareTo(o2.getAddress());
            }
        });
        return "Network{" +
                nodesIdentifiable +
                '}';

    }

}