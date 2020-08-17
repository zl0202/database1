package com.qf.dao;


import com.qf.pojo.Permission;
import com.qf.pojo.Role;
import com.qf.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface IUserDao {

    User getUser(@Param("usernmae") String usernmae,@Param("password") String password);
    List<Role> getRoles(String usernmae);
    List<Permission> getPermission(String usernmae);
}
