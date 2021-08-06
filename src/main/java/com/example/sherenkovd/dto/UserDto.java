package com.example.sherenkovd.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {

    private String login;
    private String name;
    private String surname;

    public UserDto(String login, String name, String surname) {
        this.login = login;
        this.name = name;
        this.surname = surname;
    }
    public UserDto() {
    }
}
