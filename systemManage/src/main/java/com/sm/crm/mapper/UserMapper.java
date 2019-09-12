package com.sm.crm.mapper;

import com.sm.crm.entity.User;

import java.util.List;

public interface UserMapper {

    User findUser(User user);

    List<User> findUserList(User user);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(Integer uid);
}
