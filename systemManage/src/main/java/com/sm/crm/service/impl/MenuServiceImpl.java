package com.sm.crm.service.impl;

import com.sm.crm.entity.Menu;
import com.sm.crm.entity.User;
import com.sm.crm.mapper.MenuMapper;
import com.sm.crm.service.MenuService;
import com.sm.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    /**
     * 根据用户来查询菜单信息
     *
     * @param user
     * @return
     */
    @Override
    public List<Menu> findMenuByUid(User user) {
        List<Menu> menus = menuMapper.findMenu(user);
        return menus;
    }

    @Override
    public List<Menu> findMenusByrid(Integer rid) {
        return menuMapper.findMenusByrid(rid);
    }
}
