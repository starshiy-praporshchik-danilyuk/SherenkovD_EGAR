package com.example.sherenkovd.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LessonDtoRecv {

    private String theme;
    private String link;

    public LessonDtoRecv(String theme, String link) {
        this.theme = theme;
        this.link = link;
    }
}
