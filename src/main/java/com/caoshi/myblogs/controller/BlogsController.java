package com.caoshi.myblogs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  博客控制器。。。
 *
 * @author CaoShi
 * @time 2019/12/3 18:14
 */
@RequestMapping("blogs")
@Controller
public class BlogsController {

    /**
     * 跳转到博客系统首页
     * @return
     */
    @RequestMapping("toBlogsList")
    public String toBlogsList() {
        return "blogs/blogsList";
    }

}
