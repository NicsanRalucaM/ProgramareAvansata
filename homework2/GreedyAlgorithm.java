package laborator2;

import java.util.Arrays;

public class GreedyAlgorithm extends Algorithm {

    public GreedyAlgorithm() {
    }

    public GreedyAlgorithm(Problem problem) {
        super(problem);
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

        int p = 0;
        int roomsUsed = 0;
        while (rooms[0].getCapacity() > events[p].getSize() && p < n) { //se cauta prima incapere disponibila
            p++;
        }
        if (p == n - 1)
            return sol;
        else {
            assignment[p] = rooms[0];
            eventsUsed[p] = 0;
            roomsUsed = 1;
        }
        int nrRoomsUsed = 1, j, neighbor;
        for (int i = p + 1; i < n; i++) {  //pentru restul evenimentelor
            j = -1;
            do {
                j++;
                neighbor = -1;
                for (int k = 0; k < n && neighbor == -1; k++) { //se parcurge graful pentru a vedea daca nodul are vecini
                    if (eventsUsed[k] == j) {     // in multimea curenta
                        if (graphAdjacency[i][k])
                            neighbor = k;
                    }
                }
                if (neighbor == -1) { //daca nu are i se poate atribui sala j
                    neighbor = -2;
                    if (events[i].getSize() <= rooms[j].getCapacity()) {
                        assignment[i] = rooms[j];
                        eventsUsed[i] = j;
                    } else neighbor = -1;

                }
            } while (neighbor != -2 && j != roomsUsed && j < rooms.length);
            if (neighbor != -2 && j + 1 < rooms.length) {  //daca s-au niciuna din incaperile atribuite deja nu se poate da, atunci se atrbuie una noua
                if (events[i].getSize() <= rooms[j + 1].getCapacity()) {
                    assignment[i] = rooms[j + 1];
                    eventsUsed[i] = j + 1;
                    roomsUsed++;
                }
            }
        }
        sol.setAssignment(assignment);
        return sol;
    }

}
