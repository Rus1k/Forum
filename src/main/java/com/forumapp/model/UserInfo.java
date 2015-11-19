package com.forumapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor

public class UserInfo {

    private int idUserInfo;
    private int idAccount;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private String email;
    private String city;

    public UserInfo() {

    }
}
