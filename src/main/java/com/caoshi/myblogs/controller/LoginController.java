package com.caoshi.myblogs.controller;

import com.caoshi.myblogs.domain.User;
import com.caoshi.myblogs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("login")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("toLogin")
    public String toLogin() {
        return "/system/login";
    }

    @RequestMapping("login")
    public String login(User user) {
        User loginUser = userService.userLogin(user);
        if (null != loginUser) {
            return "redirect:blogs/blogsList.html";
        } else {
            return "redirect:index.html";
        }

    }


}
