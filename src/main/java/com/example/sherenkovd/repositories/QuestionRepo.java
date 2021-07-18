package com.example.sherenkovd.repositories;

import com.example.sherenkovd.models.Lesson;
import com.example.sherenkovd.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepo extends JpaRepository <Question, Long> {

    List<Question> findQuestionsByLessonEquals(Lesson lesson);

}
