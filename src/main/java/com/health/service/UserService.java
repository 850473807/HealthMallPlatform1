package com.health.service;

import com.health.model.User;

import java.util.List;

public interface UserService {
    Long addUser(User user);
    List<User> queryUser(User user);
}
