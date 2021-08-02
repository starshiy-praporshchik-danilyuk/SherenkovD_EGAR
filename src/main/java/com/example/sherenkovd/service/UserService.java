package com.example.sherenkovd.service;

import com.example.sherenkovd.converters.UserConverter;
import com.example.sherenkovd.dto.UserDto;
import com.example.sherenkovd.models.Role;
import com.example.sherenkovd.models.User;
import com.example.sherenkovd.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserConverter userConverter;

    public List<UserDto> getUsersDtoByRole(Role role){
        List<User> users = userRepo.findUsersByRoleEquals(role);
        List<UserDto> usersDto = new ArrayList<>();
        for (User user : users)
            usersDto.add(userConverter.fromUserToUserDto(user));
        return usersDto;
    }

    public UserDto getUserDto(String login){
        var user = userRepo.findByLogin(login);
        return userConverter.fromUserToUserDto(user);
    }

    public User getUser(String login){
        return userRepo.findByLogin(login);
    }

    public User getThisUser(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String loginUser = ((UserDetails)principal).getUsername();
        return userRepo.findByLogin(loginUser);
    }
}
