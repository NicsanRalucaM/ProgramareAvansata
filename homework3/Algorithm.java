package homework3;

import java.util.ArrayList;
import java.util.List;

public abstract class Algorithm {
    protected Network network;
    protected int[][] graphAdjacency;
    protected int n;
    protected List<Node> nodes = new ArrayList<>();

    public Algorithm() {
    }

    public Algorithm(Network network) {
        this.network = network;
        this.n = network.getNodesIdentifiable().size();
        this.nodes = network.getNodesIdentifiable();
        this.graphAdjacency = new int[this.n][this.n];
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
                    graphAdjacency[i][j] = n.getCost().get(m);
                else if (i == j)
                    graphAdjacency[i][j] = 0;
                else graphAdjacency[i][j] = 99999999;
                System.out.print(graphAdjacency[i][j] + " ");
            }
            j = -1;
            System.out.println();

        }
    }

    public void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(graphAdjacency[i][j] + " ");
            }
            System.out.println();
        }
    }
}

