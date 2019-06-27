package com.xiazhe.controller;

import com.xiazhe.bean.User;
import com.xiazhe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MyController {
    @Autowired
    UserService userService;

    @RequestMapping("hello")
    @ResponseBody
    public String hello(String value) {
        int x = Integer.parseInt(value);
        User user = userService.selectByid(x);
        return user.toString();

    }

    /*@RequestMapping(value="hello1",produces= MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")*/
    @RequestMapping("hello1")
    @ResponseBody
    public String hello1(MultipartFile filez) throws IOException {

        String originalFilename = filez.getOriginalFilename();
        System.out.println(originalFilename);
        String path = getClass().getClassLoader().getResource("../../").getPath();
        File f = new File(path, originalFilename);
        if (!f.exists()) f.createNewFile();
        System.out.println(f);
        filez.transferTo(f);
        return "success";
    }
    @RequestMapping("hello3")
    @ResponseBody
    public String hello3(String value) {
        int x = Integer.parseInt(value);
        User user = userService.selectByid(x);
        return user.toString();

    }

}
