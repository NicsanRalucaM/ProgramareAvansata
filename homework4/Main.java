package homework4;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String args[]) { //instantierea intersectilor
        var nodes = IntStream.rangeClosed(0, 8)
                .mapToObj(i -> new Intersection("v" + i))
                .toArray(Intersection[]::new);

        //instantierea strazilor
        Street s1 = new Street("s1", nodes[0], nodes[1], 2);
        Street s2 = new Street("s2", nodes[0], nodes[2], 2);
        Street s3 = new Street("s3", nodes[0], nodes[3], 2);
        Street s4 = new Street("s4", nodes[1], nodes[2], 2);
        Street s5 = new Street("s5", nodes[2], nodes[3], 1);
        Street s6 = new Street("s6", nodes[2], nodes[4], 2);
        Street s7 = new Street("s7", nodes[3], nodes[4], 3);
        Street s8 = new Street("s8", nodes[4], nodes[5], 1);
        Street s9 = new Street("s9", nodes[1], nodes[5], 3);
        Street s10 = new Street("s10", nodes[5], nodes[6], 1);
        Street s11 = new Street("s11", nodes[7], nodes[6], 1);
        Street s12 = new Street("s12", nodes[5], nodes[8], 2);
        Street s13 = new Street("s13", nodes[7], nodes[8], 1);
        Street s14 = new Street("s14", nodes[7], nodes[2], 2);
        Street s15 = new Street("s15", nodes[6], nodes[8], 1);
        Street s16 = new Street("s16", nodes[4], nodes[8], 3);

        List<Street> streetsList = new ArrayList<>();
        Set<Intersection> intersectionsSet = new HashSet();

        streetsList.addAll(Arrays.asList(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16));

        Collections.sort(streetsList,  //compararea strazilor in functie de length-->metoda compareTo implementata in Street
                ((u, v) -> u.compareTo(v)));

        for (Intersection v : nodes) {
            intersectionsSet.add(v);
        }

        City A = new City(nodes, streetsList);
        A.addToCity(nodes[0], Arrays.asList(s1, s2, s3));
        A.addToCity(nodes[1], Arrays.asList(s1, s4, s9));
        A.addToCity(nodes[2], Arrays.asList(s2, s5, s4, s6, s14));
        A.addToCity(nodes[3], Arrays.asList(s3, s5, s7));
        A.addToCity(nodes[4], Arrays.asList(s6, s7, s9));
        A.addToCity(nodes[5], Arrays.asList(s8, s10, s9, s12));
        A.addToCity(nodes[6], Arrays.asList(s10, s11, s15));
        A.addToCity(nodes[7], Arrays.asList(s11, s13, s14));
        A.addToCity(nodes[8], Arrays.asList(s13, s15, s16));

        A.print();
        A.printStreets(3, streetsList, 3);

        //A.nameStreetsIntersections(streetsList);
       // A.print();
        PrimAlgorithm primAlgorithm = new PrimAlgorithm(A, streetsList);
        primAlgorithm.printTree();
    }
}
