package com.example.sherenkovd.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AnswerDto {

    private long question;
    private LocalDate ansDate;
    private String phrasing;

    public AnswerDto(long question, String phrasing){
        this.question = question;
        this.phrasing = phrasing;
        this.ansDate = LocalDate.now();
    }
    public AnswerDto(){
    }
}
