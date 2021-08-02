package com.example.sherenkovd.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "questions")
@Data
public class Question implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    @Column(name = "phrasing")
    private String phrasing;

    public Question() {
    }

    public Question(Lesson lesson, String phrasing) {
        this.lesson = lesson;
        this.phrasing = phrasing;
    }
}
