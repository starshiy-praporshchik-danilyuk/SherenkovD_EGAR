package com.example.sherenkovd.service;

import com.example.sherenkovd.models.Role;
import com.example.sherenkovd.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class MainService {

    @Autowired
    private UserRepo userRepo;

    public String success() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String loginUser = ((UserDetails)principal).getUsername();
        if(userRepo.findByLogin(loginUser).getRole().equals(Collections.singleton(Role.STUDENT)))
            /*return "redirect:/student/lectures";*/
            return "index";
        if(userRepo.findByLogin(loginUser).getRole().equals(Collections.singleton(Role.TEACHER)))
            /*return "redirect:/teacher/lectures";*/
            return "main_teacher";
        /*return "success";*/
        return "index";
    }
}
