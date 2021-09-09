package com.example.sherenkovd.service;

import com.example.sherenkovd.dto.LessonDtoRecv;
import com.example.sherenkovd.dto.LessonDtoSend;
import com.example.sherenkovd.models.Lesson;
import com.example.sherenkovd.models.User;
import com.example.sherenkovd.repositories.LessonRepo;
import com.example.sherenkovd.repositories.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LessonServiceTest {

    @Autowired
    private LessonService lessonService;

    @Autowired
    private LessonRepo lessonRepo;

    @Autowired
    private UserRepo userRepo;

    @Test
    @Transactional
    void getLessonsForTeacher() {
        User teacher = userRepo.findByLogin("user");
        List<LessonDtoSend> lessonsResponse = lessonService.getLessonsForTeacher(teacher);
        assertNotEquals(new ArrayList<>(), lessonsResponse);
        for (LessonDtoSend lessonDtoSend : lessonsResponse) {
            Lesson lesson = lessonRepo.getById(lessonDtoSend.getId());
            assertEquals(teacher, lesson.getTeacher());
            assertEquals(lesson.getLesDate(), lessonDtoSend.getLesDate());
            assertEquals(lesson.getTheme() , lessonDtoSend.getTheme());
            assertEquals(lesson.getFile(), lessonDtoSend.getFile());
        }
    }

    @Test
    @Transactional
    void getFinishedLessons() {
        List<LessonDtoSend> lessonsResponse = lessonService.getFinishedLessons();
        assertNotEquals(new ArrayList<>(), lessonsResponse);
        for (LessonDtoSend lessonDtoSend : lessonsResponse) {
            Lesson lesson = lessonRepo.getById(lessonDtoSend.getId());
            assertEquals(lesson.getLesDate(), lessonDtoSend.getLesDate());
            assertEquals(lesson.getTheme() , lessonDtoSend.getTheme());
            assertEquals(lesson.getFile(), lessonDtoSend.getFile());
            assertEquals((short)1, lesson.getFinish());
        }
    }

    @Test
    @Transactional
    void getLessonDto() {
        LessonDtoSend lessonDto = lessonService.getLessonDto(1);
        assertNotNull(lessonDto);
        Lesson lesson = lessonRepo.getById((long)1);
        assertEquals(lesson.getTheme(), lessonDto.getTheme());
        assertEquals(lesson.getLesDate(), lessonDto.getLesDate());
        assertEquals(lesson.getFile(), lessonDto.getFile());
    }

    @Test
    @Transactional
    void addLesson() {
        User teacher = userRepo.findByLogin("user");
        LessonDtoRecv lessonDtoRecv = new LessonDtoRecv("theme", "link");
        LessonDtoSend lessonDtoSend = lessonService.addLesson(teacher, lessonDtoRecv);
        assertEquals(lessonDtoRecv.getTheme(), lessonDtoSend.getTheme());
        assertEquals(lessonDtoRecv.getLink(), lessonDtoSend.getFile());
    }
}