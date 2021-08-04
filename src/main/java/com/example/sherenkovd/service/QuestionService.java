package com.example.sherenkovd.service;

import com.example.sherenkovd.converters.QuestionConverter;
import com.example.sherenkovd.dto.QuestionDto;
import com.example.sherenkovd.models.Lesson;
import com.example.sherenkovd.models.Question;
import com.example.sherenkovd.repositories.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepo questionRepo;

    @Autowired
    private QuestionConverter questionConverter;

    public List<QuestionDto> getQuestions(Lesson lesson){
        List<Question> questions = questionRepo.findQuestionsByLessonEquals(lesson);
        List<QuestionDto> questionsDto = new ArrayList<>();
        for (Question question : questions)
            questionsDto.add(questionConverter.fromQuestionToQuestionDto(question));
        return questionsDto;
    }

    public QuestionDto addQuestion(QuestionDto questionDto, Lesson lesson){
        var question = questionRepo.save(new Question(lesson, questionDto.getPhrasing()));
        return questionConverter.fromQuestionToQuestionDto(question);
    }

    public Question getQuestion(long id){
        return questionRepo.getById(id);
    }
}