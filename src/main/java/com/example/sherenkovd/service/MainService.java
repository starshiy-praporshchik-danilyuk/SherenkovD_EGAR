package com.example.sherenkovd.service;

import com.example.sherenkovd.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class MainService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleService roleService;

    public String success() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String loginUser = ((UserDetails)principal).getUsername();
        if(userRepo.findByLogin(loginUser).getRole().equals(roleService.getRole(2)))
            return "lessons_student";
        if(userRepo.findByLogin(loginUser).getRole().equals(roleService.getRole(1)))
            return "lessons_teacher";
        return "login";
    }
}
