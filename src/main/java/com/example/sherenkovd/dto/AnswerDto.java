package com.example.sherenkovd.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class AnswerDto {

    private long question;
    private LocalDate ansDate;
    private String phrasing;

    public AnswerDto(long question, String phrasing){
        this.question = question;
        this.phrasing = phrasing;
        this.ansDate = LocalDate.now();
    }
}
