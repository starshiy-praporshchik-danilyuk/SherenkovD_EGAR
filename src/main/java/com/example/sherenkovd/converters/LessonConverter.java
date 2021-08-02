package com.example.sherenkovd.converters;

import com.example.sherenkovd.dto.LessonDtoSend;
import com.example.sherenkovd.models.Lesson;


import org.springframework.stereotype.Component;

@Component
public class LessonConverter {

    public LessonDtoSend fromLessonToLessonDto(Lesson lesson){
        return new LessonDtoSend(lesson.getId(),
                lesson.getTheme(),
                lesson.getLesDate(),
                lesson.getFile());
    }
}
