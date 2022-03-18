package homework3;

public class AlgorithmFloydWarshall extends Algorithm {
    public AlgorithmFloydWarshall() {
    }

    public AlgorithmFloydWarshall(Network network) {
        super(network);
    }

    public String solve() {

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graphAdjacency[i][j] > graphAdjacency[i][k] + graphAdjacency[k][j]) {
                        graphAdjacency[i][j] = graphAdjacency[i][k] + graphAdjacency[k][j];
                        if (i == j && graphAdjacency[i][j] < 0)
                            return "circuit negativ";
                    }
                }
            }
        }
        return "";
    }

}
