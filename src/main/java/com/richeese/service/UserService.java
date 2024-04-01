package com.richeese.service;

import com.richeese.dao.DiscussPostMapper;
import com.richeese.dao.UserMapper;
import com.richeese.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User findById(int id){
        return userMapper.selectById(id);
    }
}
