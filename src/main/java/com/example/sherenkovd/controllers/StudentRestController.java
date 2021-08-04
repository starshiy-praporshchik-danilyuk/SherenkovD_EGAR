package com.example.sherenkovd.controllers;

import com.example.sherenkovd.dto.AnswerDto;
import com.example.sherenkovd.dto.LessonDtoSend;
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

    @GetMapping("/lessons/{id_lesson}")
    public LessonDtoSend getLesson(@PathVariable("id_lesson") long lessonId){
        try{
            return studentService.getLesson(lessonId);
        } catch (Exception e){
            return new LessonDtoSend();
        }
    }

    @GetMapping("/questions/{id_lesson}")
    public List<QuestionDto> getQuestions(@PathVariable("id_lesson") long lessonId){
        return studentService.getQuestions(lessonId);
    }

    @PostMapping("/answers")
    public AnswerDto saveAnswer(@RequestBody AnswerDto answerDto){
        try{
            return studentService.saveAnswer(answerDto);
        } catch (Exception e){
            return new AnswerDto();
        }
    }

    @GetMapping("/lessons")
    public List<LessonDtoSend> getLecturesForStudent(){
        return studentService.getLessonsForStudent();
    }

    @GetMapping("/students/{login}")
    public UserDto getStudent(@PathVariable("login") String login){
        try{
            return studentService.getStudent(login);
        } catch (Exception e){
            return new UserDto();
        }
    }
}
