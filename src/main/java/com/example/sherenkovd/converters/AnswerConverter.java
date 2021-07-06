package com.example.sherenkovd.converters;

import com.example.sherenkovd.dto.AnswerDto;
import com.example.sherenkovd.models.Answer;
import com.example.sherenkovd.repositories.QuestionRepo;
import com.example.sherenkovd.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class AnswerConverter {

    @Autowired
    private QuestionRepo questionRepo;
    @Autowired
    private UserRepo userRepo;

    public Answer fromAnswerDtoToAnswer(AnswerDto answerDto){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String loginUser = ((UserDetails)principal).getUsername();
        return new Answer(questionRepo.getById(answerDto.getQuestion()),
                userRepo.findByLogin(loginUser),
                answerDto.getAnsDate(),
                answerDto.getPhrasing());
    }

    public AnswerDto fromAnswerToAnswerDto(Answer answer){
        return new AnswerDto(answer.getQuestion().getId(),
                answer.getPhrasing());
    }
}