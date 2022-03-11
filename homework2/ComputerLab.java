package laborator2;

public class ComputerLab extends Room {
    private String system;

    public ComputerLab() {

    }

    public ComputerLab(String name, int capacity, String system) {
        super(name, capacity);
        this.system = system;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }


}
