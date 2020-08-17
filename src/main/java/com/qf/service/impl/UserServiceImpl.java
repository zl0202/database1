package com.qf.service.impl;



import com.qf.dao.IUserDao;
import com.qf.pojo.Permission;
import com.qf.pojo.Role;
import com.qf.pojo.User;
import com.qf.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao ud ;

    @Override
    public User login(String usernmae, String password) {

        return ud.getUser(usernmae,password);
    }

    @Override
    public List<Role> getRoles(String usernmae) {
        return ud.getRoles(usernmae);
    }

    @Override
    public List<Permission> getPermission(String usernmae) {
        return ud.getPermission(usernmae);
    }
}
