package com.example.sherenkovd.converters;

import com.example.sherenkovd.dto.QuestionDto;
import com.example.sherenkovd.models.Question;
import org.springframework.stereotype.Component;

@Component
public class QuestionConverter {

    public QuestionDto fromQuestionToQuestionDto(Question question){
        return new QuestionDto(question.getId(), question.getLesson().getId(),
                question.getPhrasing());
    }
}
