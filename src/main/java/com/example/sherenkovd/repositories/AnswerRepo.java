package com.example.sherenkovd.repositories;

import com.example.sherenkovd.models.Answer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnswerRepo extends JpaRepository <Answer, Long> {

    @Query(value = "select * from answers where user_id = ?1 and question_id in(select id from questions where lesson_id = ?2)",
            nativeQuery = true)
    List<Answer> getAnswersForStudent(String login, long lessonId);
}

