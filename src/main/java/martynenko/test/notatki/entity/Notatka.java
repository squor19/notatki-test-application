package martynenko.test.notatki.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class Notatka {

    @Id
    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    //Represents both a date and a time (yyyy-MM-dd-HH-mm-ss-ns)
    @Column(name = "last_updated")
    private LocalDateTime localDateAndTime;

    public Notatka(String title, String content, LocalDateTime localDateAndTime) {
        this.title = title;
        this.content = content;
        this.localDateAndTime = localDateAndTime;
    }

    public Notatka() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getLocalDateAndTime() {
        return localDateAndTime;
    }

    public void setLocalDateAndTime(LocalDateTime localDateAndTime) {
        this.localDateAndTime = localDateAndTime;
    }
}
