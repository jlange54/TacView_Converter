import java.time.LocalDateTime;
import java.util.Objects;
import java.util.stream.Stream;

public class MetaInfo {

    private int referenceLongitude = -1000;
    private int referenceLatitude = -1000;
    private LocalDateTime referenceTime = null;
    private LocalDateTime recordingTime = null;
    private String title;
    private String dataSource;
    private String author;

    public int getReferenceLongitude() {
        return referenceLongitude;
    }

    public void setReferenceLongitude(int referenceLongitude) {
        this.referenceLongitude = referenceLongitude;
    }

    public int getReferenceLatitude() {
        return referenceLatitude;
    }

    public void setReferenceLatitude(int referenceLatitude) {
        this.referenceLatitude = referenceLatitude;
    }

    public LocalDateTime getReferenceTime() {
        return referenceTime;
    }

    public void setReferenceTime(LocalDateTime referenceTime) {
        this.referenceTime = referenceTime;
    }

    public LocalDateTime getRecordingTime() {
        return recordingTime;
    }

    public void setRecordingTime(LocalDateTime recordingTime) {
        this.recordingTime = recordingTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "MetaInfo{" +
                "referenceLongitude=" + referenceLongitude +
                ", referenceLatitude=" + referenceLatitude +
                ", referenceTime=" + referenceTime +
                ", recordingTime=" + recordingTime +
                ", title='" + title + '\'' +
                ", dataSource='" + dataSource + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
