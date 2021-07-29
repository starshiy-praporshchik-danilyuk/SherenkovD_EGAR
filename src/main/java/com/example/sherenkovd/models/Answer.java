package com.example.sherenkovd.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
//TODO: названия таблиц переименовать в нижний регистр
@Table(name = "answers")
@Data
public class Answer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    //TODO: ref-columns должны называться as question_id
    @JoinColumn(name = "question")
    private Question question;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "ans_date")
    private LocalDate ansDate;

    @Column(length = 255)
    private String phrasing;

    public Answer() {
    }

    public Answer(Question question, User user, LocalDate ansDate, String phrasing) {
        this.question = question;
        this.user = user;
        this.ansDate = ansDate;
        this.phrasing = phrasing;
    }
}
