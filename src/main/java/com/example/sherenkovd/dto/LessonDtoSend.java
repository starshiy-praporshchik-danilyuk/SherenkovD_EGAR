package com.example.sherenkovd.dto;

import lombok.Data;

import java.util.Date;

@Data
public class LessonDtoSend {

    private long id;
    private String theme;
    private Date lesDate;
    private String file;

    public LessonDtoSend(long id, String theme, Date lesDate, String file) {
        this.id = id;
        this.theme = theme;
        this.lesDate = lesDate;
        this.file = file;
    }

    public LessonDtoSend() {
    }
}
