package com.example.SherenkvD.repositories;

import com.example.SherenkvD.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepo extends JpaRepository <Question, Long> {
}
