package com.caoshi.myblogs.controller;

import com.caoshi.myblogs.constant.ResultObj;
import com.caoshi.myblogs.domain.User;
import com.caoshi.myblogs.service.UserService;
import com.caoshi.myblogs.util.CheckCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录控制器
 * @author CaoShi
 * @time 2019/12/3 18:15
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 跳转到登录页面
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin() {
        return "/system/login";
    }

    /**
     * @param username 用户输入的用户名
     * @param password 用户输入的密码
     * @param vcode 用户输入的验证码
     * @param request HttpServletRequest
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public ResultObj login(String username, String password, String vcode, HttpServletRequest request) {
        // System.out.println("LoginController.login" + username + "--" + password + "--" + vcode);
        User loginUser = new User(username, password);
        User user = userService.userLogin(loginUser);
        String vcodeStr = request.getSession().getAttribute("CHECKCODE_SESSION").toString();
        if (null != user && vcode.equalsIgnoreCase(vcodeStr)) {
            request.getSession().setAttribute("user", user);
            return ResultObj.LOGIN_SUCCESS;
        } else {
            return ResultObj.LOGIN_ERROR;
        }
    }

    /**
     * 获取验证码
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     */
    @RequestMapping("/code")
    public void getCode(HttpServletRequest req, HttpServletResponse resp) {
        CheckCodeUtil checkCodeUtil = new CheckCodeUtil();
        try {
            checkCodeUtil.writeCheckCode(req, resp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 跳转到博客系统首页
     * @return
     */
    @RequestMapping("toMain")
    public String toMain() {
        return "/blogs/main";
    }

    /**
     * 退出登录
     * @param session
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "/system/login";
    }

}
