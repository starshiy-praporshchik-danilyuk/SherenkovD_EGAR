package com.example.sherenkovd.repositories;

import com.example.sherenkovd.models.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LessonRepo extends JpaRepository <Lesson, Long> {
    List<Lesson> findLessonsByFinishEquals(boolean finish);
}
