package homework3;

import java.util.ArrayList;
import java.util.List;

public abstract class Algorithm {
    protected Network network;
    protected int[][] graph;
    protected int n;
    protected List<Node> nodes = new ArrayList<>();

    public Algorithm() {
    }

    public Algorithm(Network network) {
        this.network = network;
        this.n = network.getNodesIdentifiable().size();
        this.nodes = network.getNodesIdentifiable();
        this.graph= new int[this.n][this.n];
        representGraph(network);
    }

    protected void representGraph(Network network) {
        int i = -1, j = -1;
        double inf = Double.POSITIVE_INFINITY;

        for (Node n : nodes) {
            i++;
            for (Node m : nodes) {
                j++;
                if (n.getCost().containsKey(m))
                    graph[i][j] = n.getCost().get(m);
                else if (i == j)
                    graph[i][j] = 0;
                else graph[i][j] = 99999999;
                System.out.print(graph[i][j] + " ");
            }
            j = -1;
            System.out.println();

        }
    }

    public void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}

