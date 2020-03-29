package com.health.mapper;

import com.health.model.User;

import java.util.List;

public interface UserMapper {
    Long addUser(User user);

    List<User> queryUser(User user);
}
