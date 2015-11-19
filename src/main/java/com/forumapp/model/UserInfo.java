package com.forumapp.model;

import lombok.Data;
import lombok.Builder;

import java.time.LocalDate;

@Data
@Builder

public class UserInfo {

    private int idUserInfo;
    private int idAccount;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private String email;
    private String city;

}
