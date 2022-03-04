package laborator2;

import static laborator2.RoomType.*;

public class Main {
    public static void main(String[] args) {


      
        Course C1 = new Course("C1", 100, 8, 10);
        Course C2 = new Course("C2", 100, 10, 12);
        Lab L1 = new Lab("L1", 30, 8, 10);
        Lab L2 = new Lab("L2", 30, 8, 10);
        Lab L3 = new Lab("L3", 30, 10, 12);
        System.out.println("Events: " + C1.toString() + ", " + C2.toString() + ", " + L1.toString() + ", " + L2.toString() + ", " + L3.toString());

        Room R1 = new Room("401", 30, COMPUTER_LAB);
        Room R2 = new Room("403", 30, COMPUTER_LAB);
        Room R3 = new Room("405", 30, COMPUTER_LAB);
        Room R4 = new Room("309", 100, LECTURE_HALL);
        System.out.println("Rooms: " + R1.toString() + ", " + R2.toString() + ", " + R3.toString() + ", " + R4.toString());


    }
}
