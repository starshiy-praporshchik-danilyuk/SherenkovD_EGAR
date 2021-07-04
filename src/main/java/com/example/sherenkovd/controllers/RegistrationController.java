package com.example.sherenkovd.controllers;

import com.example.sherenkovd.models.Role;
import com.example.sherenkovd.models.User;
import com.example.sherenkovd.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        var userFromDb = userRepo.findByLogin(user.getLogin());

        if (userFromDb != null) {
            model.put("message", "Пользователь c таким логином уже существует");
            return "registration";
        }
        user.setRole(Collections.singleton(Role.STUDENT));
        userRepo.save(user);

        return "redirect:/login";
    }
}
