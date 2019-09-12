package com.sm.crm.service;

import com.github.pagehelper.PageInfo;
import com.sm.crm.entity.User;

import java.util.List;

public interface UserService {
    User findUser(User user);

    PageInfo<User> findAllUser(Integer currentPage, Integer pageSize);

    int updateUser(User user);

    int addUser(User user);

    int deleteUser(Integer uid);

    List<User> findUsers(User user);
}
