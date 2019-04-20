package com.tour.app.controller;

import com.tour.app.model.entity.ResponseInfo;
import com.tour.app.model.entity.Users;
import com.tour.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    @ResponseBody
    public Object login(Users users, HttpSession session){

        ResponseInfo login = userService.login(users,session);

        return login;
    }

    @PostMapping("/reg")
    @ResponseBody
    public Object reg(Users users){

        ResponseInfo reg = userService.reg(users);

        return reg;
    }


    @GetMapping("/loginView")
    public String loginView(){

        return "admin/login";
    }

    @GetMapping("/regView")
    public String regView(){

        return "admin/register";
    }
}
