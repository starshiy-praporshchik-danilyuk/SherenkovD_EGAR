package com.example.sherenkovd.converters;

import com.example.sherenkovd.dto.UserRegistrationDto;
import com.example.sherenkovd.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserRegistrationConverter {

    public User fromUserRegistrationDtoToUser(UserRegistrationDto userRegistrationDto){
        return new User(userRegistrationDto.getLogin(),
                userRegistrationDto.getName(),
                userRegistrationDto.getSurname(),
                userRegistrationDto.getPassword(),
                userRegistrationDto.getRole());
    }
}
