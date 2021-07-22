package com.example.sherenkovd.controllers;

import com.example.sherenkovd.dto.*;
import com.example.sherenkovd.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherRestController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/questions/{id_lesson}")
    public List<QuestionDto> getQuestions(@PathVariable("id_lesson") long lessonId) {
        return teacherService.getQuestions(lessonId);
    }

    @GetMapping("/lessons/{id_lesson}")
    public LessonDtoSend getLesson(@PathVariable("id_lesson") long lessonId) {
        return teacherService.getLesson(lessonId);
    }

    @PostMapping("/lessons")
    public LessonDtoSend addLesson(@RequestBody LessonDtoRecv lessonDtoRecv) {
        return teacherService.addLesson(lessonDtoRecv);
    }

    @GetMapping("/lessons")
    public List<LessonDtoSend> getLessonsForTeacher() {
        return teacherService.getLessonsForTeacher();
    }

    @PostMapping("/questions")
    public QuestionDto addQuestion(@RequestBody QuestionDto questionDto){
        return teacherService.addQuestion(questionDto);
    }

    @GetMapping("/students")
    public List<UserDto> getStudents(){
        return teacherService.getStudents();
    }

    @GetMapping("/answers/{login}/{id_lesson}")
    public List<AnswerDto> getAnswers(@PathVariable("login") String login, @PathVariable("id_lesson") long lessonId){
        return teacherService.getAnswers(login, lessonId);
    }
}
