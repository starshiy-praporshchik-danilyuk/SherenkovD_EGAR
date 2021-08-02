package com.example.sherenkovd.service;

import com.example.sherenkovd.converters.LessonConverter;
import com.example.sherenkovd.dto.LessonDtoSend;
import com.example.sherenkovd.dto.LessonDtoRecv;
import com.example.sherenkovd.models.Lesson;
import com.example.sherenkovd.models.User;
import com.example.sherenkovd.repositories.LessonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class LessonService {

    @Autowired
    private LessonRepo lessonRepo;

    @Autowired
    private LessonConverter lessonConverter;

    public List<LessonDtoSend> getLessonsForTeacher(User teacher){
        List<Lesson> lessons = lessonRepo.findLessonsByTeacherEquals(teacher);
        List<LessonDtoSend> lessonsDto = new ArrayList<>();
        for (Lesson lesson : lessons)
            lessonsDto.add(lessonConverter.fromLessonToLessonDto(lesson));
        return lessonsDto;
    }

    public List<LessonDtoSend> getFinishedLessons(){
        List<Lesson> lessons = lessonRepo.findLessonsByFinishEquals((short)1);
        List<LessonDtoSend> lessonsDto = new ArrayList<>();
        for (Lesson lesson : lessons)
            lessonsDto.add(lessonConverter.fromLessonToLessonDto(lesson));
        return lessonsDto;
    }

    public LessonDtoSend getLessonDto(long lessonId){
        var lesson = lessonRepo.getById(lessonId);
        return lessonConverter.fromLessonToLessonDto(lesson);
    }

    public Lesson getLesson(long id){
        return lessonRepo.getById(id);
    }

    public LessonDtoSend addLesson(User teacher, LessonDtoRecv lessonDtoRecv){
        var lesson = lessonRepo.save(new Lesson(teacher, lessonDtoRecv.getTheme(), LocalDate.now(),
                lessonDtoRecv.getLink(), (short)0));
        return lessonConverter.fromLessonToLessonDto(lesson);
    }

}
