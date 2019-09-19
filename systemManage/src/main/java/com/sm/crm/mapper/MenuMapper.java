package com.sm.crm.mapper;

import com.sm.crm.entity.Menu;
import com.sm.crm.entity.User;

import java.util.List;

public interface MenuMapper {
    List<Menu> findMenu(User user);

    List<Menu> findMenusByrid(Integer rid);

}
