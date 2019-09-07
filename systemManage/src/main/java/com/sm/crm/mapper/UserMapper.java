package com.sm.crm.mapper;

import com.sm.crm.entity.User;

import java.util.List;

public interface UserMapper {

    User findUser(User user);

    List<User> findUserList(User user);

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(User user);
}
