package com.example.sherenkovd.service;

import com.example.sherenkovd.converters.AnswerConverter;
import com.example.sherenkovd.dto.AnswerDto;
import com.example.sherenkovd.models.Answer;
import com.example.sherenkovd.models.Question;
import com.example.sherenkovd.repositories.AnswerRepo;
import com.example.sherenkovd.repositories.LessonRepo;
import com.example.sherenkovd.repositories.QuestionRepo;
import com.example.sherenkovd.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepo answerRepo;

    @Autowired
    private AnswerConverter answerConverter;

    @Autowired
    private QuestionRepo questionRepo;

    @Autowired
    private LessonRepo lessonRepo;

    @Autowired
    private UserRepo userRepo;

    public AnswerDto saveAnswer(AnswerDto answerDto){
        Question question = questionRepo.getById(answerDto.getQuestion());
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String loginUser = ((UserDetails)principal).getUsername();
        var user = userRepo.findByLogin(loginUser);
        var answer = answerRepo.save(new Answer(question, user, answerDto.getAnsDate(), answerDto.getPhrasing()));
        return answerConverter.fromAnswerToAnswerDto(answer);
    }

    public List<AnswerDto> getAnswers(long idUser, long idLesson){
        List<Question> questions = questionRepo.findQuestionsByLessonEquals(lessonRepo.getById(idLesson));
        List<Answer> answers = answerRepo.findAnswersByUserEqualsAndQuestionIsIn(userRepo.getById(idUser), questions);
        List<AnswerDto> answersDto = new ArrayList<>();
        for (Answer answer : answers){
            answersDto.add(answerConverter.fromAnswerToAnswerDto(answer));
        }
        return answersDto;
    }
}
