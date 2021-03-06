package com.example.sherenkovd.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class QuestionDto {

    private long id;
    private long lesson;
    private String phrasing;

    public QuestionDto(long id,long lesson, String phrasing) {
        this.id = id;
        this.lesson = lesson;
        this.phrasing = phrasing;
    }
}
