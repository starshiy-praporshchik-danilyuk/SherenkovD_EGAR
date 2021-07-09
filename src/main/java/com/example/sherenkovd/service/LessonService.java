package com.example.sherenkovd.service;

import com.example.sherenkovd.converters.LessonConverter;
import com.example.sherenkovd.dto.LessonDto;
import com.example.sherenkovd.models.Lesson;
import com.example.sherenkovd.repositories.LessonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LessonService {

    @Autowired
    private LessonRepo lessonRepo;

    @Autowired
    private LessonConverter lessonConverter;

    public List<LessonDto> getLessons(){
        List<Lesson> lessons = lessonRepo.findAll();
        List<LessonDto> lessonsDto = new ArrayList<>();
        for (Lesson lesson : lessons)
            lessonsDto.add(lessonConverter.fromLessonToLessonDto(lesson));
        return lessonsDto;
    }

    public List<LessonDto> getFinishedLessons(){
        List<Lesson> lessons = lessonRepo.findLessonsByFinishEquals(true);
        List<LessonDto> lessonsDto = new ArrayList<>();
        for (Lesson lesson : lessons)
            lessonsDto.add(lessonConverter.fromLessonToLessonDto(lesson));
        return lessonsDto;
    }

    public LessonDto getLesson(long id){
        var lesson = lessonRepo.getById(id);
        return lessonConverter.fromLessonToLessonDto(lesson);
    }

    public LessonDto addLesson(LessonDto lessonDto){
        var lesson = lessonRepo.save(lessonConverter.fromLessonDtoToLesson(lessonDto));
        return lessonConverter.fromLessonToLessonDto(lesson);
    }

}
