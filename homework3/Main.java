package homework3;

import static homework3.StorageType.*;

public class Main {
    public static void main(String[] args) {
        Node v1 = new Computer("v1", 10, "192.158. 1.38");
        Node v2 = new Router("v2", "192.158. 2.38");
        Node v3 = new Switch("v3");
        Node v4 = new Switch("v4");
        Node v5 = new Router("v5", "196.158. 1.38");
        Node v6 = new Computer("v6", 10, "192.158. 1.39");
        System.out.println(((Computer) v1).getStorageCapacity(MEGABYTE));

        Network A = new Network();
        A.addNode(v1);
        A.addNode(v2);
        A.addNode(v3);
        A.addNode(v4);
        A.addNode(v5);
        A.addNode(v6);

        v1.setCost(v2, 10);
        v1.setCost(v3, 50);
        v2.setCost(v3, 20);
        v2.setCost(v4, 20);
        v2.setCost(v1, 10);
        v2.setCost(v5, 20);
        v3.setCost(v2, 20);
        v3.setCost(v4, 10);
        v4.setCost(v5, 30);
        v4.setCost(v6, 10);
        v4.setCost(v3, 10);
        v5.setCost(v6, 20);
        v5.setCost(v2, 20);
        v5.setCost(v4, 30);
        v6.setCost(v5, 20);
        v6.setCost(v4, 10);
        System.out.println(A);

        System.out.println(A.print());
        Algorithm alg = new AlgorithmFloydWarshall(A);

        System.out.println(((AlgorithmFloydWarshall) alg).solve());
        alg.print();


    }
}
