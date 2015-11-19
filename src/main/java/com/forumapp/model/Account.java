package com.forumapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Account {

    private int idAccount;
    private String login;
    private String password;

    public Account(){

    }

}