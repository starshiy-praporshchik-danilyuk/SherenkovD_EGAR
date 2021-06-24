package com.example.SherenkvD.controllers;

import com.example.SherenkvD.models.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class RegistrationAndAuthenticationController {

    @GetMapping("/")
    public String Start() {
        return "redirect:/login";
    }

    @GetMapping("/success")
    public String success() {
        return "success";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping(value = "/login")
    public String login(@RequestBody User user, HttpServletResponse response){

        //Здесь должны быть проверка на существование пользователя
        if(!user.getName().equals("user") || !user.getSurname().equals("user") || !user.getPassword().equals("11"))
            return "redirect:/login";

        long id = 0;
        /*Получение id из БД по принятым данным
        ...
        ...*/

        Cookie cookie = new Cookie("id", Long.toString(id));
        cookie.setMaxAge(-1);
        response.addCookie(cookie);
        return "redirect:/success";
    }
}
