package com.example.sherenkovd.dto;

import com.example.sherenkovd.models.Role;
import lombok.Data;

@Data
public class UserRegistrationDto {

    private String login;
    private String name;
    private String surname;
    private String password;
    private Role role;

    public UserRegistrationDto(String login, String name, String surname, String password) {
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.password = password;
    }
}
