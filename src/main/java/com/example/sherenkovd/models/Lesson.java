package com.example.sherenkovd.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Lessons")
@Data
public class Lesson implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "teacher")
    private User teacher;

    @Column(length = 100)
    private String theme;

    @Column(name = "les_date")
    private Date lesDate;

    @Column(length = 255)
    private String file;

    private boolean finish;

    public Lesson() {
    }

    public Lesson(User teacher, String theme, Date lesDate, String file, boolean finish) {
        this.teacher = teacher;
        this.theme = theme;
        this.lesDate = lesDate;
        this.file = file;
        this.finish = finish;
    }
}
