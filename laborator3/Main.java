package laborator3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Node v1 = new Computer("ComputerA");
        Node v2 = new Router("RouterA");
        Node v3 = new Switch("SwitchA");
        Node v4 = new Switch("SwitchB");
        Node v5 = new Router("RouterB");
        Node v6 = new Computer("ComputerB");
        Node v7 = new Computer("");

        Network A = new Network();
        A.addNode(v1);
        A.addNode(v2);
        A.addNode(v3);
        A.addNode(v4);
        A.addNode(v5);
        A.addNode(v6);
        A.addNode(v7);
        System.out.println(A);
    }
}
