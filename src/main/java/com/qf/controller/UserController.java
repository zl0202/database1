package com.qf.controller;

import com.qf.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;

@Controller
public class UserController {

    @GetMapping("/{path}")
    public String getPath(@PathVariable String path){
    return path;
    }
    @GetMapping("/")
    public String preLog(){
        return "login";
    }

    @PostMapping("/login")
    public String login(String username,String password){

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(username,password);

        try{
            subject.login(token);
            return "main";
        }catch (AuthenticationException e){
            e.printStackTrace();
            return "login";
        }
    }

}
