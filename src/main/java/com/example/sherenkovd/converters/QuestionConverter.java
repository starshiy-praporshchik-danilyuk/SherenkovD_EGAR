package com.example.sherenkovd.converters;

import com.example.sherenkovd.dto.QuestionDto;
import com.example.sherenkovd.models.Question;
import com.example.sherenkovd.repositories.LessonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuestionConverter {

    @Autowired
    private LessonRepo lessonRepo;

    public Question fromQuestionDtoToQuestion(QuestionDto questionDto){
        return new Question(lessonRepo.getById(questionDto.getLesson()),
                questionDto.getPhrasing());
    }

    public QuestionDto fromQuestionToQuestionDto(Question question){
        return new QuestionDto(question.getLesson().getId(),
                question.getPhrasing());
    }
}
