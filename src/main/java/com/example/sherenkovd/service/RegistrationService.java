package com.example.sherenkovd.service;

import com.example.sherenkovd.converters.UserRegistrationConverter;
import com.example.sherenkovd.dto.UserRegistrationDto;
import com.example.sherenkovd.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RegistrationService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserRegistrationConverter userRegistrationConverter;

    @Autowired
    private RoleService roleService;

    public String addUser(UserRegistrationDto userRegistrationDto, Map<String, Object> model) {
        var userFromDb = userRepo.findByLogin(userRegistrationDto.getLogin());
        if (userFromDb != null) {
            model.put("message", "Пользователь c таким логином уже существует");
            return "registration";
        }
        userRegistrationDto.setRole(roleService.getRole("STUDENT"));
        userRepo.save(userRegistrationConverter.fromUserRegistrationDtoToUser(userRegistrationDto));

        return "redirect:/login";
    }
}
