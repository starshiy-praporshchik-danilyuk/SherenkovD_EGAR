package com.example.sherenkovd.service;

import com.example.sherenkovd.dto.AnswerDto;
import com.example.sherenkovd.dto.LessonDto;
import com.example.sherenkovd.dto.QuestionDto;
import com.example.sherenkovd.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private LessonService lessonService;

    @Autowired
    private AnswerService answerService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private UserService userService;

    public List<LessonDto> getLessonsForStudent(){
        return lessonService.getFinishedLessons();
    }

    public AnswerDto saveAnswer(AnswerDto answerDto){
        return answerService.saveAnswer(answerDto);
    }

    public List<QuestionDto> getQuestions(long id){
        return questionService.getQuestions(id);
    }

    public LessonDto getLesson(long id){
        return lessonService.getLesson(id);
    }

    public UserDto getStudent(String login){
        return userService.getStudent(login);
    }
}
