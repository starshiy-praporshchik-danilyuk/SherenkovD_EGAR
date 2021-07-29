package com.example.sherenkovd.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "question")
@Data
public class Question implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "lesson")
    private Lesson lesson;

    @Column(length = 255)
    private String phrasing;

    public Question() {
    }

    public Question(Lesson lesson, String phrasing) {
        this.lesson = lesson;
        this.phrasing = phrasing;
    }
}
