package com.qf.pojo;

import lombok.Data;

import java.util.Set;

@Data
public class User {

    private int uid;
    private String usernmae;
    private String password;
    private String tel;
    private String addr;
    private Set<Role> roles;
}
