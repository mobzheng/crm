package com.sm.crm.service;

import com.github.pagehelper.PageInfo;
import com.sm.crm.entity.Log;
import com.sm.crm.entity.Right;

import java.util.List;

public interface RightService {

    List<Right> findAllRight();

    int updateRightMenu(Integer rid, Integer[] menuId);

    void deleteRightMenuByrid(Integer rid);
}
