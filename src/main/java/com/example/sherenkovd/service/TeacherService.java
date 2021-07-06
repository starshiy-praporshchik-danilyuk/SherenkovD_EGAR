package com.example.sherenkovd.service;

import com.example.sherenkovd.converters.AnswerConverter;
import com.example.sherenkovd.converters.LessonConverter;
import com.example.sherenkovd.converters.QuestionConverter;
import com.example.sherenkovd.converters.UserConverter;
import com.example.sherenkovd.dto.AnswerDto;
import com.example.sherenkovd.dto.LessonDto;
import com.example.sherenkovd.dto.QuestionDto;
import com.example.sherenkovd.dto.UserDto;
import com.example.sherenkovd.models.*;
import com.example.sherenkovd.repositories.AnswerRepo;
import com.example.sherenkovd.repositories.LessonRepo;
import com.example.sherenkovd.repositories.QuestionRepo;
import com.example.sherenkovd.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private LessonRepo lessonRepo;

    @Autowired
    private QuestionRepo questionRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AnswerRepo answerRepo;

    @Autowired
    private LessonConverter lessonConverter;

    @Autowired
    private QuestionConverter questionConverter;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private AnswerConverter answerConverter;

    public List<LessonDto> getLecturesForTeacher(){
        List<Lesson> lessons = lessonRepo.findAll();
        List<LessonDto> lessonsDto = new ArrayList<>();
        for (Lesson lesson : lessons)
            lessonsDto.add(lessonConverter.fromLessonToLessonDto(lesson));
        return lessonsDto;
    }

    public LessonDto getLesson(long id){
        var lesson = lessonRepo.getById(id);
        return lessonConverter.fromLessonToLessonDto(lesson);
    }

    public LessonDto addLecture(LessonDto lessonDto){
        var lesson = lessonRepo.save(lessonConverter.fromLessonDtoToLesson(lessonDto));
        return lessonConverter.fromLessonToLessonDto(lesson);
    }

    public List<QuestionDto> getQuestions(long id){
        List<Question> questions = questionRepo.findQuestionsByLessonEquals(lessonRepo.getById(id));
        List<QuestionDto> questionsDto = new ArrayList<>();
        for (Question question : questions)
            questionsDto.add(questionConverter.fromQuestionToQuestionDto(question));
        return questionsDto;
    }

    public QuestionDto addQuestion(QuestionDto questionDto){
        var question = questionRepo.save(questionConverter.fromQuestionDtoToQuestion(questionDto));
        return questionConverter.fromQuestionToQuestionDto(question);
    }

    public List<UserDto> getStudents(){
        List<User> users = userRepo.findUsersByRoleEquals(Role.STUDENT);
        List<UserDto> usersDto = new ArrayList<>();
        for (User user : users)
            usersDto.add(userConverter.fromUserToUserDto(user));
        return usersDto;
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
