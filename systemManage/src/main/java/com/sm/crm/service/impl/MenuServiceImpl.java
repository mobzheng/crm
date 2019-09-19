package com.sm.crm.service.impl;

import com.sm.crm.entity.Menu;
import com.sm.crm.entity.User;
import com.sm.crm.mapper.MenuMapper;
import com.sm.crm.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map<Long, Menu> map = new HashMap<>();
        menus.forEach(item -> {
            map.put(item.getMenuId(), item);
        });
        List<Menu> list = new ArrayList<Menu>() {{
            map.entrySet().forEach(item -> {
                add(item.getValue());
            });
        }};
        return list;
    }

    @Override
    public List<Menu> findMenusByrid(Integer rid) {
        return menuMapper.findMenusByrid(rid);
    }
}
