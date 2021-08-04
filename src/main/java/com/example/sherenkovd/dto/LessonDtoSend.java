package com.example.sherenkovd.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class LessonDtoSend {

    private long id;
    private String theme;
    private LocalDate lesDate;
    private String file;

    public LessonDtoSend(long id, String theme, LocalDate lesDate, String file) {
        this.id = id;
        this.theme = theme;
        this.lesDate = lesDate;
        this.file = file;
    }
}
