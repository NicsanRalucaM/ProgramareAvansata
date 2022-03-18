package homework3;

public class Computer extends Node implements Identifiable, Storage {
    private String addressIP;
    private int storageCapacity;

    public Computer() {
    }

    public Computer(String name, int storageCapacity, String addressIP) {
        super(name);
        this.addressIP = addressIP;
        this.storageCapacity = storageCapacity;
    }

    @Override
    public String getAddress() {
        return addressIP;
    }

    public void setAddress(String address) {
        this.addressIP = address;
    }

    public void setStorageCapacity(int storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    @Override
    public int getStorageCapacity() {
        return storageCapacity;
    }
}
