package com.example.sherenkovd.converters;

import com.example.sherenkovd.dto.UserDto;
import com.example.sherenkovd.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserDto fromUserToUserDto(User user) {
        return new UserDto(user.getLogin(),
                user.getName(),
                user.getSurname());
    }

}