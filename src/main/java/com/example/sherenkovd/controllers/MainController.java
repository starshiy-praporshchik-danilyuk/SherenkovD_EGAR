package com.example.sherenkovd.controllers;

import com.example.sherenkovd.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

    @Autowired
    private MainService mainService;

    @GetMapping("/")
    public String start() {
        return "redirect:/success";
    }

    @GetMapping("/success")
    public String success() {
        /*return mainService.success();*/
        return "lessons_teacher";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/lesson")
    public String viewLecture(){
        return "questions_teacher";
    }

    @GetMapping("/view_student")
    public String viewStudent(){
        return "students_teacher";
    }

    @GetMapping("/answers")
    public String viewAnswers(){
        return "answers_teacher";
    }

    @GetMapping("/test")
    public String viewTest(){
        return "test_student";
    }

}
