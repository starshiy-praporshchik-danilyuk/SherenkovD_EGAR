package com.example.sherenkovd.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "lessons")
@Data
public class Lesson implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "teacher_id")
    private User teacher;

    @Column(length = 100, name = "theme")
    private String theme;

    @Column(name = "les_date")
    private LocalDate lesDate;

    @Column(name = "file")
    private String file;

    @Column(name="finish")
    private short finish;

    public Lesson() {
    }

    public Lesson(User teacher, String theme, LocalDate lesDate, String file, short finish) {
        this.teacher = teacher;
        this.theme = theme;
        this.lesDate = lesDate;
        this.file = file;
        this.finish = finish;
    }
}
