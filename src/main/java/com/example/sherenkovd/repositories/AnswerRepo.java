package com.example.sherenkovd.repositories;

import com.example.sherenkovd.models.Answer;
import com.example.sherenkovd.models.Question;
import com.example.sherenkovd.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepo extends JpaRepository <Answer, Long> {

    List<Answer> findAnswersByUserEqualsAndQuestionIsIn(User user, List<Question> questions);
}
