package com.example.sherenkovd.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class QuestionDto {

    private long lesson;
    private String phrasing;

    public QuestionDto(long lesson, String phrasing) {
        this.lesson = lesson;
        this.phrasing = phrasing;
    }
    public QuestionDto() {
    }
}
