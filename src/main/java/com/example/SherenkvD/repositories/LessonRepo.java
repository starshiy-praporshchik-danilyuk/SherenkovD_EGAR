package com.example.SherenkvD.repositories;

import com.example.SherenkvD.models.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepo extends JpaRepository <Lesson, Long> {
}
