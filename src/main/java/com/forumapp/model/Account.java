package com.forumapp.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Account {

    private int idAccount;
    private String login;
    private String password;

}