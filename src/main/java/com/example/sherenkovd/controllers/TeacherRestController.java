package com.example.sherenkovd.controllers;

import com.example.sherenkovd.dto.AnswerDto;
import com.example.sherenkovd.dto.LessonDto;
import com.example.sherenkovd.dto.QuestionDto;
import com.example.sherenkovd.dto.UserDto;
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
    public LessonDto getLesson(@PathVariable("id_lesson") long lessonId) {
        return teacherService.getLesson(lessonId);
    }

    @PostMapping("/{login}/lessons")
    public LessonDto addLesson(@PathVariable("login") String login, @RequestBody LessonDto lessonDto) {
        return teacherService.addLesson(login, lessonDto);
    }

    @GetMapping("/{login}/lessons")
    public List<LessonDto> getLessonsForTeacher(@PathVariable("login") String login) {
        return teacherService.getLessonsForTeacher(login);
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
