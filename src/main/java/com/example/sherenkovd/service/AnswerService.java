package com.example.sherenkovd.service;

import com.example.sherenkovd.converters.AnswerConverter;
import com.example.sherenkovd.dto.AnswerDto;
import com.example.sherenkovd.models.Answer;
import com.example.sherenkovd.models.Question;
import com.example.sherenkovd.models.User;
import com.example.sherenkovd.repositories.AnswerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepo answerRepo;

    @Autowired
    private AnswerConverter answerConverter;

    public AnswerDto saveAnswer(AnswerDto answerDto, User user, Question question){
        var answer = answerRepo.save(new Answer(question, user, 
        		answerDto.getAnsDate(),
        		answerDto.getPhrasing()));
        return answerConverter.fromAnswerToAnswerDto(answer);
    }

    public List<AnswerDto> getAnswers(String login, long lessonId){
        List<Answer> answers = answerRepo.getAnswersForStudent(login, lessonId);
        List<AnswerDto> answersDto = new ArrayList<>();
        for (Answer answer : answers){
            answersDto.add(answerConverter.fromAnswerToAnswerDto(answer));
        }
        return answersDto;
    }
}
