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
}
