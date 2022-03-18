package laborator4;

public class Street implements Comparable<Street>{
    private String name;
    private Intersection intersection1;
    private Intersection intersection2;
    private int length;

    public Street() {
    }

    public Street(String name, Intersection intersection1, Intersection intersection2, int length) {
        this.name = name;
        this.intersection1 = intersection1;
        this.intersection2 = intersection2;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Intersection getIntersection1() {
        return intersection1;
    }

    public void setIntersection1(Intersection intersection1) {
        this.intersection1 = intersection1;
    }

    public Intersection getIntersection2() {
        return intersection2;
    }

    public void setIntersection2(Intersection intersection2) {
        this.intersection2 = intersection2;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public int compareTo(Street o) {
        if(this.length>o.length)
            return 1;
        else if(this.length==o.length)
            return 0;
        else
            return -1;
    }
}
