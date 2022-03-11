package laborator2;

import java.util.Arrays;

public abstract class Algorithm {
    protected Problem problem;
    protected Solution sol;
    protected Boolean[][] graphAdjacency;
    protected Room[] assignment;
    protected int n;
    protected Event[] events;
    protected Room[] rooms;

    public Algorithm() {
    }

    public Algorithm(Problem problem) {
        this.problem = problem;
        this.n = problem.getEvents().length;
        this.events = problem.getEvents();
        this.rooms = problem.getRooms();
        this.graphAdjacency = new Boolean[this.n][this.n];

    }

    protected void representGraph(Problem problem) { //se creeaza matricea de adiacenta folosita de ambii algoritmi
        for (Event e : events)
            System.out.print(e.getName() + " ");
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (events[i].getBegin() <= events[j].getBegin() && events[i].getEnd() >= events[j].getEnd())
                    graphAdjacency[i][j] = true;
                else if (events[i].getBegin() > events[j].getBegin() && events[i].getBegin() < events[j].getEnd())
                    graphAdjacency[i][j] = true;
                else if (events[i].getEnd() > events[j].getBegin() && events[i].getEnd() < events[j].getEnd())
                    graphAdjacency[i][j] = true;
                else graphAdjacency[i][j] = false;
                graphAdjacency[i][i] = false;
                //System.out.print(graphAdjacency[i][j]);
            }
            //System.out.println();
        }
    }

    public Solution solve() {
        return sol;
    }

}
