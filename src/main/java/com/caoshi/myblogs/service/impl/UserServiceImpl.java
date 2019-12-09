package com.caoshi.myblogs.service.impl;

import com.caoshi.myblogs.domain.User;
import com.caoshi.myblogs.mapper.UserMapper;
import com.caoshi.myblogs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User userLogin(User user) {
        return userMapper.findUser(user);
    }

    @Override
    public void updatePwd(String password, Integer userId) {
        userMapper.updatePassword(password, userId);
    }
}
