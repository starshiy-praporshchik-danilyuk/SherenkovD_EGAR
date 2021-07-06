package com.example.sherenkovd.service;

import com.example.sherenkovd.converters.AnswerConverter;
import com.example.sherenkovd.converters.LessonConverter;
import com.example.sherenkovd.converters.QuestionConverter;
import com.example.sherenkovd.dto.AnswerDto;
import com.example.sherenkovd.dto.LessonDto;
import com.example.sherenkovd.dto.QuestionDto;
import com.example.sherenkovd.models.Answer;
import com.example.sherenkovd.models.Lesson;
import com.example.sherenkovd.models.Question;
import com.example.sherenkovd.repositories.AnswerRepo;
import com.example.sherenkovd.repositories.LessonRepo;
import com.example.sherenkovd.repositories.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
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
    private AnswerConverter answerConverter;

    @Autowired
    private LessonConverter lessonConverter;

    @Autowired
    private QuestionConverter questionConverter;

    public List<LessonDto> getLecturesForStudent(){
        List<Lesson> lessons = lessonRepo.findLessonsByFinishEquals(true);
        List<LessonDto> lessonsDto = new ArrayList<>();
        for (Lesson lesson : lessons)
            lessonsDto.add(lessonConverter.fromLessonToLessonDto(lesson));
        return lessonsDto;
    }

    public AnswerDto saveAnswer(AnswerDto answerDto){
        Answer answer = answerRepo.save(answerConverter.fromAnswerDtoToAnswer(answerDto));
        return answerConverter.fromAnswerToAnswerDto(answer);
    }

    public List<QuestionDto> getQuestions(long id){
        var lesson = lessonRepo.getById(id);
        List<Question> questions = questionRepo.findQuestionsByLessonEquals(lesson);
        List<QuestionDto> questionsDto = new ArrayList<>();
        for (Question question : questions)
            questionsDto.add(questionConverter.fromQuestionToQuestionDto(question));
        return questionsDto;
    }

    public LessonDto getLesson(long id){
        var lesson = lessonRepo.getById(id);
        return lessonConverter.fromLessonToLessonDto(lesson);
    }
}
