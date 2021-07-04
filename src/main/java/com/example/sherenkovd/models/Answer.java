package com.example.sherenkovd.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Answers")
@Data
public class Answer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "question")
    private Question question;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user")
    private User user;

    @Column(name = "ans_date")
    private Date ansDate;

    @Column(length = 255)
    private String phrasing;

    public Answer() {
    }

    public Answer(Question question, User user, Date ansDate, String phrasing) {
        this.question = question;
        this.user = user;
        this.ansDate = ansDate;
        this.phrasing = phrasing;
    }
}
