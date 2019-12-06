package com.caoshi.myblogs.domain;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class User {

    private Integer id;

    private String userName;

    private String password;

    private Date regTime;

    private String qq;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

}
