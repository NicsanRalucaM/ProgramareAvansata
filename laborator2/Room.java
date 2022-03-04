package laborator2;

public class Room {
    private String name;
    private RoomType type;
    private int capacity;

    public Room() {
    }

    public Room(String name, int capacity,RoomType type) {
        this.name = name;
        this.type = type;
        this.capacity = capacity;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return name+"(" +
                "type=" + type +
                ", capacity=" + capacity +
                ')';
    }
}
