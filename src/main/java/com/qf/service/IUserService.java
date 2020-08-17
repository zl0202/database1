package com.qf.service;

import com.qf.pojo.Permission;
import com.qf.pojo.Role;
import com.qf.pojo.User;

import java.util.List;

public interface IUserService {

    User login(String usernmae, String password);
    List<Role> getRoles(String usernmae);
    List<Permission> getPermission(String usernmae);
}
