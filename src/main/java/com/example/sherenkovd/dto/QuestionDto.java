package com.example.sherenkovd.dto;

import lombok.Data;

@Data
public class QuestionDto {

    private long lesson;
    private String phrasing;

    public QuestionDto(long lesson, String phrasing) {
        this.lesson = lesson;
        this.phrasing = phrasing;
    }
}
