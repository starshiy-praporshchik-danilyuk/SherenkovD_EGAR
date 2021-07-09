package com.example.sherenkovd.converters;

import com.example.sherenkovd.dto.AnswerDto;
import com.example.sherenkovd.models.Answer;
import org.springframework.stereotype.Component;

@Component
public class AnswerConverter {

    public AnswerDto fromAnswerToAnswerDto(Answer answer){
        return new AnswerDto(answer.getQuestion().getId(),
                answer.getPhrasing());
    }
}