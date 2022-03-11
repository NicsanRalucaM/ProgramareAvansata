package laborator2;

import java.util.Arrays;

public class Problem {
    private Event[] events;
    private Room[] rooms;

    public Problem() {
    }

    public Room[] getRooms() {
        return rooms;
    }

    public void setRooms(Room... rooms) {
        this.rooms = rooms;
    }

    public Event[] getEvents() {
        return events;
    }

    public void setEvents(Event... events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "Problem: " +
                "events=" + Arrays.toString(events) +
                ";\n rooms=" + Arrays.toString(rooms) +
                ';';
    }
}
