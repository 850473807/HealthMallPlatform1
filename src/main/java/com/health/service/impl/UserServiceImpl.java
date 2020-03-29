package com.health.service.impl;

import com.health.mapper.UserMapper;
import com.health.model.User;
import com.health.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Long addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public List<User> queryUser(User user) {
        return userMapper.queryUser(user);
    }


}
