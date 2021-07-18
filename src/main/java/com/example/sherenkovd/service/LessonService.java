package com.example.sherenkovd.service;

import com.example.sherenkovd.converters.LessonConverter;
import com.example.sherenkovd.dto.LessonDto;
import com.example.sherenkovd.models.Lesson;
import com.example.sherenkovd.models.User;
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

    public List<LessonDto> getLessonsForTeacher(User teacher){
        List<Lesson> lessons = lessonRepo.findLessonsByTeacherEquals(teacher);
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

    public LessonDto getLessonDto(long lessonId){
        var lesson = lessonRepo.getById(lessonId);
        return lessonConverter.fromLessonToLessonDto(lesson);
    }

    public Lesson getLesson(long id){
        return lessonRepo.getById(id);
    }

    public LessonDto addLesson(User teacher, LessonDto lessonDto){
        var lesson = lessonRepo.save(new Lesson(teacher, lessonDto.getTheme(), lessonDto.getLesDate(),
                                                        lessonDto.getFile(), false));
        return lessonConverter.fromLessonToLessonDto(lesson);
    }

}
