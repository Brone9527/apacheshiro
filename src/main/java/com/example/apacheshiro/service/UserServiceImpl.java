package com.example.apacheshiro.service;

import com.example.apacheshiro.mapper.UserMapper;
import com.example.apacheshiro.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author zeroback13
 * @Date 2021/4/5 1:32
 * @Version 1.0
 */

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }
}
