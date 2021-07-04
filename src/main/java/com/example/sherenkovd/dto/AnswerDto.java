package com.example.sherenkovd.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AnswerDto {

    private long question;
    private Date ansDate;
    private String phrasing;

    public AnswerDto(long question, String phrasing){
        this.question = question;
        this.phrasing = phrasing;
        this.ansDate = new Date();
    }
}
