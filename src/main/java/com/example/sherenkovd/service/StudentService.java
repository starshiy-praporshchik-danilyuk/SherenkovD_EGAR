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

    public AnswerDto saveAnswer(String login, AnswerDto answerDto){
        var student = userService.getUser(login);
        var question = questionService.getQuestion(answerDto.getQuestion());
        return answerService.saveAnswer(answerDto, student, question);
    }

    public List<QuestionDto> getQuestions(long lessonId){
        var lesson = lessonService.getLesson(lessonId);
        return questionService.getQuestions(lesson);
    }

    public LessonDto getLesson(long lessonId){
        return lessonService.getLessonDto(lessonId);
    }

    public UserDto getStudent(String login){
        return userService.getUserDto(login);
    }
}
