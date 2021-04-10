package com.example.apacheshiro.service;

import com.example.apacheshiro.model.User;

/**
 * @Author zeroback13
 * @Date 2021/4/5 1:31
 * @Version 1.0
 */
public interface UserService {

    User findByUsername(String username);
}
