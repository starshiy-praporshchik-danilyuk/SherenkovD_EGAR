package com.example.sherenkovd.service;

import com.example.sherenkovd.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    private RoleService roleService;

    public List<LessonDtoSend> getLessonsForTeacher(){
        var teacher = userService.getThisUser();
        return lessonService.getLessonsForTeacher(teacher);
    }

    public LessonDtoSend getLesson(long id){
        var lesson = lessonService.getLesson(id);
        if (lesson.getTeacher().equals(userService.getThisUser()))
            return lessonService.getLessonDto(id);
        return new LessonDtoSend();
    }

    public LessonDtoSend addLesson(LessonDtoRecv lessonDtoRecv){
        var teacher = userService.getThisUser();
        return lessonService.addLesson(teacher, lessonDtoRecv);
    }

    public List<QuestionDto> getQuestions(long lessonId){
        var lesson = lessonService.getLesson(lessonId);
        if (lesson.getTeacher().equals(userService.getThisUser()))
            return questionService.getQuestions(lesson);
        return new ArrayList<>();
    }

    public QuestionDto addQuestion(QuestionDto questionDto){
        var lesson = lessonService.getLesson(questionDto.getLesson());
        return questionService.addQuestion(questionDto, lesson);
    }

    public List<UserDto> getStudents(){
        var role = roleService.getRole("STUDENTS");
        return userService.getUsersDtoByRole(role);
    }

    public List<AnswerDto> getAnswers(String login, long idLesson){
        return answerService.getAnswers(login, idLesson);
    }
}
