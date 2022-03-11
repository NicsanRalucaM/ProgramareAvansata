package laborator2;

public class LectureHall extends Room {
    private String videoProjector;

    public LectureHall() {
    }

    public LectureHall(String name, int capacity, String videoProjector) {
        super(name, capacity);
        this.videoProjector = videoProjector;
    }

    public String getVideoProjector() {
        return videoProjector;
    }

    public void setVideoProjector(String videoProjector) {
        this.videoProjector = videoProjector;
    }
}
