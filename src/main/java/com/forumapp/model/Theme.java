package com.forumapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor

public class Theme {

    private LocalDate date;
    private String name;
    private int idTheme;
    private int idAccountIdxTheme;

}
