package com.caoshi.myblogs.mapper;

import com.caoshi.myblogs.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {


    User findUser(User user);



}
