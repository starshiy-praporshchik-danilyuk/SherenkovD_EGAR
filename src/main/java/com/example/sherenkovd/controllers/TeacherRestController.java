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
public class TeacherRestController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/teacher/questions/{id}")
    public List<QuestionDto> getQuestions(@PathVariable("id") long id) {
        return teacherService.getQuestions(id);
    }

    @GetMapping("/teacher/lecture/{id}")
    public LessonDto getLesson(@PathVariable("id") long id) {
        return teacherService.getLesson(id);
    }

    @PostMapping("/teacher/addLecture")
    public LessonDto addLecture(@RequestBody LessonDto lessonDto) {
        return teacherService.addLecture(lessonDto);
    }

    @GetMapping("/teacher/lectures")
    public List<LessonDto> getLecturesForTeacher() {
        return teacherService.getLecturesForTeacher();
    }

    @PostMapping("/teacher/addQuestion")
    public QuestionDto addQuestion(@RequestBody QuestionDto questionDto){
        return teacherService.addQuestion(questionDto);
    }

    @GetMapping("/teacher/getStudents")
    public List<UserDto> getStudents(){
        return teacherService.getStudents();
    }

    @GetMapping("/teacher/answers/{id_user}/{id_lesson}")
    public List<AnswerDto> getAnswers(@PathVariable("id_user") long idUser, @PathVariable("id_lesson") long idLesson){
        return teacherService.getAnswers(idUser, idLesson);
    }
}
