package com.caoshi.myblogs.controller;

import com.caoshi.myblogs.domain.User;
import com.caoshi.myblogs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 *  用户控制器
 * Created by CaoShi on 2019-12-09 17:25:53
 */
@Controller
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;

  /**
   * 打开修改密码弹出层
   * @return
   */
  @RequestMapping("/openUpdPwd")
  public String openUpdPwd() {
    return "/user/updPwd";
  }

  /**
   * 修改密码提交操作
   * @param password
   * @param session
   * @return
   */
  @RequestMapping("/updPwd")
  public String updPwd(String password, HttpSession session) {
    User user = (User) session.getAttribute("user");
    userService.updatePwd(password, user.getId());

    return "redirect:/login/toLogin";
  }

}
