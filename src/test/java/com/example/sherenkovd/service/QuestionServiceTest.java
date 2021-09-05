package com.example.sherenkovd.service;

import com.example.sherenkovd.dto.QuestionDto;
import com.example.sherenkovd.models.Lesson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class QuestionServiceTest {

    @Autowired
    private LessonService lessonService;

    @Autowired
    private QuestionService questionService;


    @Test
    @Transactional
    void addQuestion() {
        QuestionDto questionDto = new QuestionDto(1, 1, "question_test");
        Lesson lesson = lessonService.getLesson(1);
        QuestionDto questionDtoReturn = questionService.addQuestion(questionDto, lesson);
        assertNotNull(questionDtoReturn);
        assertEquals(lesson.getId(), questionDtoReturn.getLesson());
        assertEquals("question_test", questionDtoReturn.getPhrasing());
    }

    @Test
    void getQuestions(){
        Lesson lesson = lessonService.getLesson(1);
        List<QuestionDto> questionsDtoReturn = questionService.getQuestions(lesson);
        assertNotEquals(new ArrayList<>(), questionsDtoReturn);
        for (QuestionDto questionDto : questionsDtoReturn)
            assertEquals(1, questionDto.getLesson());
    }
}
