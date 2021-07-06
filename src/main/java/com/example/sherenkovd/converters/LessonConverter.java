package com.example.sherenkovd.converters;

import com.example.sherenkovd.dto.LessonDto;
import com.example.sherenkovd.models.Lesson;
import org.springframework.stereotype.Component;

@Component
public class LessonConverter {

    public Lesson fromLessonDtoToLesson(LessonDto lessonDto){
        return new Lesson(lessonDto.getTheme(),
                lessonDto.getLesDate(),
                lessonDto.getFile(),
                false);
    }

    public LessonDto fromLessonToLessonDto(Lesson lesson){
        return new LessonDto(lesson.getId(),
                lesson.getTheme(),
                lesson.getLesDate(),
                lesson.getFile());
    }
}
