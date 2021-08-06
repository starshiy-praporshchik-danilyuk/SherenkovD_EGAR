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
        try {
            return teacherService.getLesson(lessonId);
        } catch (Exception e) {
            return new LessonDtoSend();
        }
    }

    @PostMapping("/lessons")
    public LessonDtoSend addLesson(@RequestBody LessonDtoRecv lessonDtoRecv) {
        try {
            return teacherService.addLesson(lessonDtoRecv);
        } catch (Exception e){
            return new LessonDtoSend();
        }
    }

    @GetMapping("/lessons")
    public List<LessonDtoSend> getLessonsForTeacher() {
        return teacherService.getLessonsForTeacher();
    }

    @PostMapping("/questions")
    public QuestionDto addQuestion(@RequestBody QuestionDto questionDto){
        try{
            return teacherService.addQuestion(questionDto);
        } catch (Exception e){
            return new QuestionDto();
        }
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
