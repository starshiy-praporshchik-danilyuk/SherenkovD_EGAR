package com.example.sherenkovd.repositories;

import com.example.sherenkovd.models.Lesson;
import com.example.sherenkovd.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LessonRepo extends JpaRepository <Lesson, Long> {
    List<Lesson> findLessonsByFinishEquals(short finish);
    List<Lesson> findLessonsByTeacherEquals(User user);
}
