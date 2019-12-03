package com.caoshi.myblogs.controller;

import com.caoshi.myblogs.constant.ResultObj;
import com.caoshi.myblogs.domain.User;
import com.caoshi.myblogs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 登录控制器
 * @author CaoShi
 * @time 2019/12/3 18:15
 */
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
    @ResponseBody
    public ResultObj login(User user) {
        User loginUser = userService.userLogin(user);
        if (null != loginUser) {
            return ResultObj.LOGIN_SUCCESS;
        } else {
            return ResultObj.LOGIN_ERROR;
        }
    }


}
