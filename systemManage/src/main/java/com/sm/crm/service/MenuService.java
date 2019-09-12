package com.sm.crm.service;

import com.sm.crm.entity.Menu;
import com.sm.crm.entity.User;

import java.util.List;

public interface MenuService {

    List<Menu> findMenuByUid(User user);

    List<Menu> findMenusByrid(Integer rid);
}
