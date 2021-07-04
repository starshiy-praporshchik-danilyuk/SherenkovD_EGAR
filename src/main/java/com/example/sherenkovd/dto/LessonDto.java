package com.example.sherenkovd.dto;

import lombok.Data;

import java.util.Date;

@Data
public class LessonDto {

    private long id;
    private String theme;
    private Date lesDate;
    private String file;

    public LessonDto(String theme, Date lesDate, String file) {
        this.theme = theme;
        this.lesDate = lesDate;
        this.file = file;
    }

    public LessonDto(long id, String theme, Date lesDate, String file) {
        this.id = id;
        this.theme = theme;
        this.lesDate = lesDate;
        this.file = file;
    }
}
