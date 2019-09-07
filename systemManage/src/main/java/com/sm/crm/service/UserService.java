package com.sm.crm.service;

import com.sm.crm.entity.User;

import java.util.List;

public interface UserService {
    User findUser(User user);

    List<User> findAllUser();
}
