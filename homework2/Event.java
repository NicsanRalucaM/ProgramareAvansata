package laborator2;

public class Event implements Comparable<Event> {
    private String name;
    private int size;
    private int begin;
    private int end;

    public Event() {
    }

    public Event(String name, int size, int begin, int end) {
        this.name = name;
        this.size = size;
        this.begin = begin;
        this.end = end;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return name + "(" +
                "size=" + size +
                ", begin=" + begin +
                ", end=" + end +
                ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return name.equals(event.name);
    }

    public int compareTo(Event e) {
        int a = e.getSize();
        return a - this.size;
    }
}
