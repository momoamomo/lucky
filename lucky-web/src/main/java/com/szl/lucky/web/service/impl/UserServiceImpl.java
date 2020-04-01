package com.szl.lucky.web.service.impl;

import com.szl.lucky.dao.entity.User;
import com.szl.lucky.dao.mapper.UserMapper;
import com.szl.lucky.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sunzhilin
 * @date 2020/3/18  10:11
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public String test() {
        User user = userMapper.selectByPrimaryKey(1L);
        String name = user.getUserName();
        return name;
    }
}
