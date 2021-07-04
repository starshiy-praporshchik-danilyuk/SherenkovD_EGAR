package com.example.sherenkovd.service;

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
import org.springframework.web.bind.annotation.PathVariable;

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

    public List<LessonDto> getLecturesForTeacher(){
        List<Lesson> lessons = lessonRepo.findAll();
        List<LessonDto> lessonsDto = new ArrayList<>();
        for (Lesson lesson : lessons) {
            lessonsDto.add(new LessonDto(lesson.getId(), lesson.getTheme(), lesson.getLesDate(), lesson.getFile()));
        }
        return lessonsDto;
    }

    public LessonDto getLesson(long id){
        var lesson = lessonRepo.getById(id);
        return new LessonDto(id, lesson.getTheme(), lesson.getLesDate(), lesson.getFile());
    }

    public Lesson addLecture(LessonDto lessonDto){
        return lessonRepo.save(new Lesson(lessonDto.getTheme(), lessonDto.getLesDate(), lessonDto.getFile(), false));
    }

    public List<QuestionDto> getQuestions(long id){
        List<Question> questions = questionRepo.findQuestionsByLessonEquals(lessonRepo.getById(id));
        List<QuestionDto> questionsDto = new ArrayList<>();
        for (Question question : questions) {
            questionsDto.add(new QuestionDto(question.getId(), question.getLesson().getId(), question.getPhrasing()));
        }
        return questionsDto;
    }

    public Question addQuestion(QuestionDto questionDto){
        var question = new Question(lessonRepo.getById(questionDto.getId()), questionDto.getPhrasing());
        return questionRepo.save(question);
    }

    public List<UserDto> getStudents(){
        List<User> users = userRepo.findUsersByRoleEquals(Role.STUDENT);
        List<UserDto> usersDto = new ArrayList<>();
        for (User user : users) {
            usersDto.add(new UserDto(user.getLogin(), user.getName(), user.getSurname()));
        }
        return usersDto;
    }

    public List<AnswerDto> getAnswers(long idUser, long idLesson){
        List<Question> questions = questionRepo.findQuestionsByLessonEquals(lessonRepo.getById(idLesson));
        List<Answer> answers = answerRepo.findAnswersByUserEqualsAndQuestionIsIn(userRepo.getById(idUser), questions);
        List<AnswerDto> answersDto = new ArrayList<>();
        for (Answer answer : answers){
            answersDto.add(new AnswerDto(answer.getQuestion().getId(), answer.getPhrasing()));
        }
        return answersDto;
    }
}
