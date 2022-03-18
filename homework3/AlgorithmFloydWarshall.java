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
                    if (graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                        if (i == j && graph[i][j] < 0)
                            return "circuit negativ";
                    }
                }
            }
        }
        return "";
    }

}
