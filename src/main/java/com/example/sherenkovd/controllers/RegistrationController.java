package com.example.sherenkovd.controllers;

import com.example.sherenkovd.dto.UserRegistrationDto;
import com.example.sherenkovd.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@Controller
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@RequestBody UserRegistrationDto userRegistrationDto, Map<String, Object> model) {
        return registrationService.addUser(userRegistrationDto, model);
    }
}
