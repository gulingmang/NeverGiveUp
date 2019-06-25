package com.xiazhe.controller;

import com.xiazhe.bean.User;
import com.xiazhe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyLoginOutController {
    @Autowired
    UserService userService;

    @RequestMapping("login")
    @ResponseBody
    public String login(String username, String password) {

        User userByNameAndPassword = userService.getUserByNameAndPassword(username, password);
        if (userByNameAndPassword == null) return "账号密码错误";
        else return userByNameAndPassword.toString();
    }


    @RequestMapping("add")
    @ResponseBody
    public String add(String username, String password) {

    int userByNameAndPassword = userService.getaddUser(username, password);
        if (userByNameAndPassword != 0) return "失败";
        else return "成功";
    }
}
