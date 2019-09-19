package com.sm.crm.service.impl;

import com.sm.crm.entity.Right;
import com.sm.crm.mapper.RightMapper;
import com.sm.crm.service.RightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class RightServiceImpl implements RightService {
    @Autowired
    private RightMapper rightMapper;

    /**
     * 查询所有的权限
     * @return
     */
    @Override
    public List<Right> findAllRight() {
        return rightMapper.findAllRights();
    }

    /**
     * 修改权限-菜单映射
     * @param rid
     * @param menuId
     * @return
     */
    @Override
    public int updateRightMenu(Integer rid, Integer[] menuId) {

        return rightMapper.updateRightMenu(rid,menuId);
    }


    /**
     * 删除权限-菜单映射
     * @param rid
     */
    @Override
    public void deleteRightMenuByrid(Integer rid) {
        rightMapper.deleteRightMenuByrid(rid);
    }
}
