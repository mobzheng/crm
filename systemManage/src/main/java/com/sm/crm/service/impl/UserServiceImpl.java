package com.sm.crm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public PageInfo<User> findAllUser(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<User> userList = userMapper.findUserList(null);
        PageInfo<User> userPageInfo = new PageInfo<>(userList);
        return userPageInfo;
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int deleteUser(Integer uid) {
        return userMapper.deleteUser(uid);
    }

    @Override
    public List<User> findUsers(User user) {
        List<User> userList = userMapper.findUserList(user);
        return userList;
    }
}
