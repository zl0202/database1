package com.qf.pojo;

import lombok.Data;

import java.util.Set;

@Data
public class Role {

    private int rid;
    private String rname;
    private String rdesc;
    private Set<Permission> permissions;
}
