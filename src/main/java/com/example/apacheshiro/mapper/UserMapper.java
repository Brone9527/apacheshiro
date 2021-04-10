package com.example.apacheshiro.mapper;

import com.example.apacheshiro.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * @Author zeroback13
 * @Date 2021/4/5 1:28
 * @Version 1.0
 */
public interface UserMapper {

    User findByUsername(@Param("username")String username );
}
