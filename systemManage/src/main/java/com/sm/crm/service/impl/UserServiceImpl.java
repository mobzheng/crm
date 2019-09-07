package com.sm.crm.service.impl;

import com.sm.crm.entity.User;
import com.sm.crm.mapper.UserMapper;
import com.sm.crm.service.UserService;
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
    public User findUser(User user) {

        return userMapper.findUser(user);
    }

    @Override
    public List<User> findAllUser() {
        return userMapper.findUserList(null);
    }
}
