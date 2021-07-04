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
        return mainService.success();
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
