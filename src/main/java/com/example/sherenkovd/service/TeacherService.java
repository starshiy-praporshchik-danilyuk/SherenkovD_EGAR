package com.example.sherenkovd.service;

import com.example.sherenkovd.dto.AnswerDto;
import com.example.sherenkovd.dto.LessonDto;
import com.example.sherenkovd.dto.QuestionDto;
import com.example.sherenkovd.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private LessonService lessonService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private UserService userService;

    @Autowired
    private AnswerService answerService;

    public List<LessonDto> getLecturesForTeacher(){
        return lessonService.getLessons();
    }

    public LessonDto getLesson(long id){
        return lessonService.getLesson(id);
    }

    public LessonDto addLecture(LessonDto lessonDto){
        return lessonService.addLesson(lessonDto);
    }

    public List<QuestionDto> getQuestions(long id){
        return questionService.getQuestions(id);
    }

    public QuestionDto addQuestion(QuestionDto questionDto){
        return questionService.addQuestion(questionDto);
    }

    public List<UserDto> getStudents(){
        return userService.getStudents();
    }

    public List<AnswerDto> getAnswers(long idUser, long idLesson){
        return answerService.getAnswers(idUser, idLesson);
    }
}
