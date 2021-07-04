package com.example.sherenkovd.controllers;

import com.example.sherenkovd.dto.AnswerDto;
import com.example.sherenkovd.dto.LessonDto;
import com.example.sherenkovd.dto.QuestionDto;
import com.example.sherenkovd.models.Answer;
import com.example.sherenkovd.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentRestController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/student/lecture/{id}")
    public LessonDto getLesson(@PathVariable("id") long id){
        return studentService.getLesson(id);
    }

    @GetMapping("/student/test/{id}")
    public List<QuestionDto> getQuestions(@PathVariable("id") long id){
        return studentService.getQuestions(id);
    }

    @PostMapping("/student/test")
    public Answer saveAnswer(@RequestBody AnswerDto answerDto){
        return studentService.saveAnswer(answerDto);
    }

    @GetMapping("/student/lectures")
    public List<LessonDto> getLecturesForStudent(){
        return studentService.getLecturesForStudent();
    }
}
