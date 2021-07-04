package com.example.sherenkovd.service;

import com.example.sherenkovd.dto.AnswerDto;
import com.example.sherenkovd.dto.LessonDto;
import com.example.sherenkovd.dto.QuestionDto;
import com.example.sherenkovd.models.Answer;
import com.example.sherenkovd.models.Lesson;
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
public class StudentService {

    @Autowired
    private LessonRepo lessonRepo;

    @Autowired
    private AnswerRepo answerRepo;

    @Autowired
    private QuestionRepo questionRepo;

    @Autowired
    private UserRepo userRepo;

    public List<LessonDto> getLecturesForStudent(){
        List<Lesson> lessons = lessonRepo.findLessonsByFinishEquals(true);
        List<LessonDto> lessonsDto = new ArrayList<>();
        for (Lesson lesson : lessons) {
            lessonsDto.add(new LessonDto(lesson.getTheme(), lesson.getLesDate(), lesson.getFile()));
        }
        return lessonsDto;
    }

    public Answer saveAnswer(AnswerDto answerDto){
        Question question = questionRepo.getById(answerDto.getQuestion());
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String loginUser = ((UserDetails)principal).getUsername();
        var user = userRepo.findByLogin(loginUser);
        var answer = new Answer(question, user, answerDto.getAnsDate(), answerDto.getPhrasing());
        return answerRepo.save(answer);
    }

    public List<QuestionDto> getQuestions(long id){
        var lesson = lessonRepo.getById(id);
        List<Question> questions = questionRepo.findQuestionsByLessonEquals(lesson);
        List<QuestionDto> questionsDto = new ArrayList<>();
        for (Question question : questions) {
            questionsDto.add(new QuestionDto(question.getId(), question.getPhrasing()));
        }
        return questionsDto;
    }

    public LessonDto getLesson(long id){
        var lesson = lessonRepo.getById(id);
        return new LessonDto(lesson.getTheme(), lesson.getLesDate(), lesson.getFile());
    }
}
