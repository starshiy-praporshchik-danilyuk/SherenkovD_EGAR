package com.example.sherenkovd.controllers;

import com.example.sherenkovd.dto.AnswerDto;
import com.example.sherenkovd.dto.LessonDto;
import com.example.sherenkovd.dto.QuestionDto;
import com.example.sherenkovd.dto.UserDto;
import com.example.sherenkovd.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentRestController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/lessons/{id}")
    public LessonDto getLesson(@PathVariable("id") long id){
        return studentService.getLesson(id);
    }

    @GetMapping("/questions/{id}")
    public List<QuestionDto> getQuestions(@PathVariable("id") long id){
        return studentService.getQuestions(id);
    }

    @PostMapping("/answers")
    public AnswerDto saveAnswer(@RequestBody AnswerDto answerDto){
        return studentService.saveAnswer(answerDto);
    }

    @GetMapping("/lessons")
    public List<LessonDto> getLecturesForStudent(){
        return studentService.getLessonsForStudent();
    }

    @GetMapping("/{login}")
    public UserDto getStudent(@PathVariable("login") String login){
        return studentService.getStudent(login);
    }
}
