package com.caoshi.myblogs.service;

import com.caoshi.myblogs.domain.User;

public interface UserService {

    /**
     * 用户登录
     * @param user
     * @return
     */
    User userLogin(User user);

}
