package com.forumapp.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder

public class Theme {

    private LocalDate date;
    private String name;
    private int idTheme;
    private int idAccountIdxTheme;

}
