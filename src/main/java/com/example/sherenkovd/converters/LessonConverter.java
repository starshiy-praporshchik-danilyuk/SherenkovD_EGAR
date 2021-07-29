package com.example.sherenkovd.converters;

import com.example.sherenkovd.dto.LessonDtoSend;
import com.example.sherenkovd.models.Lesson;

import java.time.ZoneId;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class LessonConverter {

    public LessonDtoSend fromLessonToLessonDto(Lesson lesson){
        return new LessonDtoSend(lesson.getId(),
                lesson.getTheme(),
                Date.from(lesson.getLesDate().atStartOfDay(ZoneId.systemDefault()).toInstant()),
                lesson.getFile());
    }
}
