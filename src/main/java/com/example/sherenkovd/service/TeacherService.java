package com.example.sherenkovd.service;

import com.example.sherenkovd.dto.*;
import com.example.sherenkovd.models.Role;
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
        try{
            var lesson = lessonService.getLesson(id);
            if (lesson.getTeacher().equals(userService.getThisUser()))
                return lessonService.getLessonDto(id);
            return new LessonDtoSend();
        } catch (Exception e){
            return new LessonDtoSend();
        }
    }

    public LessonDtoSend addLesson(LessonDtoRecv lessonDtoRecv){
        try{
            var teacher = userService.getThisUser();
            return lessonService.addLesson(teacher, lessonDtoRecv);
        } catch(Exception e){
            return new LessonDtoSend();
        }
    }

    public List<QuestionDto> getQuestions(long lessonId){
        try{
            var lesson = lessonService.getLesson(lessonId);
            if (lesson.getTeacher().equals(userService.getThisUser()))
                return questionService.getQuestions(lesson);
            return new ArrayList<>();
        } catch(Exception e){
            return new ArrayList<>();
        }
    }

    public QuestionDto addQuestion(QuestionDto questionDto){
        try{
            var lesson = lessonService.getLesson(questionDto.getLesson());
            return questionService.addQuestion(questionDto, lesson);
        } catch(Exception e){
            return new QuestionDto();
        }
    }

    public List<UserDto> getStudents(){
        var role = roleService.getRole("STUDENT");
        return userService.getUsersDtoByRole(role);
    }

    public List<AnswerDto> getAnswers(String login, long idLesson){
        return answerService.getAnswers(login, idLesson);
    }
}
