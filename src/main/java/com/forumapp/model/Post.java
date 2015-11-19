package com.forumapp.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder

public class Post {

    private int idPost;
    private String text;
    private LocalDate date;
    private int idThemeIdxPost;
    private int idAccountIdxPost;

}
