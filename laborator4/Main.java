package laborator4;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String args[]) { //instantierea intersectilor
        var nodes = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Intersection("v" + i))
                .toArray(Intersection[]::new);

        //instantierea strazilor
        Street s1 = new Street("s1", nodes[0], nodes[1], 3);
        Street s2 = new Street("s2", nodes[1], nodes[2], 2);
        Street s3 = new Street("s3", nodes[0], nodes[3], 1);

        List<Street> streetsList = new ArrayList<>();
        Set<Intersection> intersectionsSet = new HashSet();

        streetsList.add(s1);
        streetsList.add(s2);
        streetsList.add(s3);

        Collections.sort(streetsList,  //compararea strazilor in functie de length-->metoda compareTo implementata in Street
                ((u, v) -> u.compareTo(v)));

        for (Street e : streetsList)
            System.out.println(e.getName());

        for (Intersection v : nodes) {
            intersectionsSet.add(v);
        }
        intersectionsSet.add(new Intersection("v0"));

        for (Intersection v : intersectionsSet)
            System.out.println(v.getName());
    }
}
