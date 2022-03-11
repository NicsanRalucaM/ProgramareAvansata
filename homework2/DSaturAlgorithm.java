package laborator2;

import javax.swing.*;
import java.util.Arrays;

public class DSaturAlgorithm extends Algorithm {
    public DSaturAlgorithm() {

    }

    public DSaturAlgorithm(Problem problem) {
        super(problem);
    }

    private int gradMax() {   // metoda calculeaza nodul cu grad maxim in graf
        int gradM = -1, gradC, p = 0;
        for (int i = 0; i < n; i++) {
            gradC = 0;
            for (int j = 0; j < n; j++)
                if (graphAdjacency[i][j])
                    gradC++;
            if (gradC > gradM) {
                gradM = gradC;
                p = i;
            }

        }
        return p;
    }

    private int nrNeighbors(int i) {   //metoda calculeaza nr de vecini a nodului i
        int nr = 0;
        for (int j = 0; j < n; j++) {
            if (graphAdjacency[i][j])
                nr++;
        }
        return nr;
    }

    private int next(int[] degreeOfSaturation, int[] eventsUsed) { //metoda calculeaza urmatorul nod ales in functie de gradul de saturatie si nodurile carora nu i s-au atribuit sali
        int max = -1, p = 0;
        for (int i = 0; i < n; i++) {
            if (eventsUsed[i] == -1) {
                if (degreeOfSaturation[i] > max) {
                    max = degreeOfSaturation[i];
                    p = i;
                } else if (degreeOfSaturation[i] == max) {
                    if (nrNeighbors(i) > nrNeighbors(p))
                        p = i;
                    else if (nrNeighbors(i) == nrNeighbors(p))
                        p = i;
                }
            }
        }
        return p;
    }

    @Override
    public Solution solve() {
        Arrays.sort(rooms);
        Arrays.sort(events);
        representGraph(problem);
        Solution sol = new Solution();
        assignment = new Room[n];

        int[] eventsUsed = new int[n];
        Arrays.fill(eventsUsed, -1);

        int[] degreeOfSaturation = new int[n];
        int i = 0, j, neighbor;
        int roomsUsed = 0;
        int nrEventUnused = 0;

        int v = gradMax(); //se alege primul nod, cel de grad maxim
        while (rooms[i].getCapacity() < events[v].getSize()) { //se gaseste prima sala potrivita
            i++;
        }
        eventsUsed[v] = i;
        assignment[v] = rooms[i];

        for (int k = 0; k < n; k++) {  // se cresete gradul de saturatie al turor vecinilor lui v
            if (graphAdjacency[v][k])
                degreeOfSaturation[k]++;
        }
        // se repeta acelasi procedeu ca la greedy
        int l = 1;
        while (l < events.length) {
            v = next(degreeOfSaturation, eventsUsed); //dar se alege mereu urmatorul nod caruia ii atribum o sala
            for (int q = 0; q < n; q++) {            // ca fiind nodul cu cel mai mare grad de saturatie dintre cele necolorate
                if (graphAdjacency[v][q])
                    degreeOfSaturation[q]++;
            }
            i = v;
            j = -1;
            do {
                j++;
                neighbor = -1;
                for (int k = 0; k < n && neighbor == -1; k++) {//se parcurge graful pentru a vedea daca nodul are vecini
                    if (eventsUsed[k] == j) {         // in multimea curenta
                        if (graphAdjacency[i][k])
                            neighbor = k;
                    }
                }
                if (neighbor == -1) {    //daca nu are i se poate atribui sala j
                    neighbor = -2;
                    if (events[i].getSize() <= rooms[j].getCapacity()) {
                        assignment[i] = rooms[j];
                        eventsUsed[i] = j;
                    } else neighbor = -1;

                }
            } while (neighbor != -2 && j != roomsUsed && j < rooms.length);
            if (neighbor != -2 && j + 1 < rooms.length) { //daca s-au niciuna din incaperile atribuite deja nu se poate da, atunci se atrbuie una noua
                if (events[i].getSize() <= rooms[j + 1].getCapacity()) {
                    assignment[i] = rooms[j + 1];
                    eventsUsed[i] = j + 1;
                    roomsUsed++;
                }
            }
            l++;
        }
        sol.setAssignment(assignment);
        return sol;
    }

}
