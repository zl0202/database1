package com.qf.shiro;

import com.qf.pojo.Permission;
import com.qf.pojo.Role;
import com.qf.pojo.User;
import com.qf.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component("myRealm")
public class MyRealm extends AuthorizingRealm {

    @Resource
    private IUserService us;

    //授权方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        SimpleAuthorizationInfo info =null;
        String user = getAvailablePrincipal(principalCollection).toString();

        List<Role> roles = us.getRoles(user);

        if(roles != null){
            info = new SimpleAuthorizationInfo();

            for (Role r : roles) {
                info.addRole(r.getRname());
            }
        }

        List<Permission> permission = us.getPermission(user);

        if(permission != null){
            for (Permission p : permission) {
                info.addStringPermission(p.getPname());
            }
        }


        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        AuthenticationInfo info = null;

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        String username = token.getUsername();
        char[] passwordCh = token.getPassword();
        String password = new String(passwordCh);

        User u = us.login(username, password);

        if(u != null){
            info = new SimpleAuthenticationInfo(username,password,getName());
        }


        return info;
    }
}
