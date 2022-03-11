package laborator2;


public class Main {
    public static void main(String[] args) {

        Event C1 = new Event("C1", 100, 8, 10);
        Event C2 = new Event("C2", 100, 10, 12);
        Event L1 = new Event("L1", 30, 8, 10);
        Event L4 = new Event("L4", 30, 10, 12);
        Event L2 = new Event("L2", 30, 8, 10);
        Event L5 = new Event("L5", 30, 8, 10);
        Event L6 = new Event("L6", 30, 8, 10);
        Event L3 = new Event("L3", 30, 10, 12);
        //System.out.println("Events: " + C1.toString() + ", " + C2.toString() + ", " + L1.toString() + ", " + L2.toString() + ", " + L3.toString());

        Room R1 = new ComputerLab("401", 30, "Linux");
        Room R2 = new ComputerLab("403", 30, "Linux");
        Room R3 = new ComputerLab("405", 30, "Linux");

        Room R4 = new LectureHall("309", 100, "VideoProjector");
        Room R5 = new LectureHall("319", 100, "VideoProjector");

        //System.out.println("Rooms: " + R1 + ", " + R2.toString() + ", " + R3.toString() + ", " + R4.toString());
        Problem pb = new Problem();
        pb.setEvents(C1, C2, L1, L2, L3, L4, L5);
        pb.setRooms(R1, R2, R3, R4);
        // System.out.println(pb);
        Algorithm greedy = new GreedyAlgorithm(pb);
        Solution solGreedy = greedy.solve();
        System.out.println(solGreedy);

        /*Algorithm dsatur = new DSaturAlgorithm(pb);
       Solution sol = dsatur.solve();
        System.out.println(sol);*/


    }
}
