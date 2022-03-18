package homework3;

public interface Storage {

    public int getStorageCapacity();

    default int getStorageCapacity(StorageType storageType) {
        switch (storageType) {
            case MEGABYTE:
                return 1024 * getStorageCapacity();
            case KILOBYTE:
                return 1024 * 1024 * getStorageCapacity();
            case BYTE:
                return 1024 * 1024 * 1024 * getStorageCapacity();
            default:
                return getStorageCapacity();
        }

    }

}
