package com.forumapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
public class Post {

    private int idPost;
    private String text;
    private LocalDate date;
    private int idThemeIdxPost;
    private int idAccountIdxPost;

    public Post(){

    }

}
