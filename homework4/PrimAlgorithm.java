package homework4;

import org.jgrapht.alg.interfaces.SpanningTreeAlgorithm;
import org.jgrapht.alg.spanning.PrimMinimumSpanningTree;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import java.util.List;

public class PrimAlgorithm {
    private SimpleWeightedGraph<String, DefaultEdge> graph;

    public PrimAlgorithm() {
    }

    public PrimAlgorithm(City cityMap, List<Street> streetsList) {
        graph = new SimpleWeightedGraph<String, DefaultEdge>(DefaultWeightedEdge.class);
        for (Intersection i : cityMap.getCityMap().keySet()) {
            graph.addVertex(i.getName());
        }
        for (Street s : streetsList) {
            DefaultEdge e = graph.addEdge(s.getIntersection1().getName(), s.getIntersection2().getName());
            graph.setEdgeWeight(e, s.getLength());

        }
    }

    public void printTree() {
        SpanningTreeAlgorithm.SpanningTree<DefaultEdge> primMinimumSpanningTree = new PrimMinimumSpanningTree<>(graph).getSpanningTree();
        System.out.println(primMinimumSpanningTree);
    }
}

