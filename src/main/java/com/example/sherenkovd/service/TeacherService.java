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

    public List<LessonDto> getLessonsForTeacher(String login){
        var teacher = userService.getUser(login);
        return lessonService.getLessonsForTeacher(teacher);
    }

    public LessonDto getLesson(long id){
        return lessonService.getLessonDto(id);
    }

    public LessonDto addLesson(String login, LessonDto lessonDto){
        var teacher = userService.getUser(login);
        return lessonService.addLesson(teacher, lessonDto);
    }

    public List<QuestionDto> getQuestions(long lessonId){
        var lesson = lessonService.getLesson(lessonId);
        return questionService.getQuestions(lesson);
    }

    public QuestionDto addQuestion(QuestionDto questionDto){
        var lesson = lessonService.getLesson(questionDto.getLesson());
        return questionService.addQuestion(questionDto, lesson);
    }

    public List<UserDto> getStudents(){
        return userService.getStudents();
    }

    public List<AnswerDto> getAnswers(String login, long idLesson){
        return answerService.getAnswers(login, idLesson);
    }
}
