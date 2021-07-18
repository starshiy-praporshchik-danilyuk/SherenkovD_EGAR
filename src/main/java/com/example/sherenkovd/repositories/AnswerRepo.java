package com.example.sherenkovd.repositories;

import com.example.sherenkovd.models.Answer;
import com.example.sherenkovd.models.Question;
import com.example.sherenkovd.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnswerRepo extends JpaRepository <Answer, Long> {

    @Query(value = "select * from Answers where user = ?1 and question in(select id from Question where lesson = ?2)",
            nativeQuery = true)
    List<Answer> getAnswersForStudent(String login, long lessonId);
}

