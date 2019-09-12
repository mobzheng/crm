package com.sm.crm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sm.crm.entity.Role;
import com.sm.crm.mapper.RoleMapper;
import com.sm.crm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    /**
     * 查找所有角色
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<Role> findAllRole(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<Role> allRole = roleMapper.findAllRole();
        PageInfo<Role> rolePageInfo = new PageInfo<>(allRole);
        return rolePageInfo;
    }

    /**
     * 更新角色权限表
     * @param roleId
     * @param rights
     * @return
     */
    @Override
    public int updateRoleRight(Integer roleId, String[] rights) {
        return roleMapper.updateRoleRight(roleId,rights);
    }


    /**
     * 删除角色和权限的映射关系
     * @param roleId
     */
    @Override
    public void deleteRoleRightByRoleId(Integer roleId) {
        roleMapper.deleteRoleRightById(roleId);
    }

    /**
     * 删除角色
     * @param roleId
     */
    @Override
    public void deleteRoleByRoleId(Integer roleId) {
        roleMapper.deleteRoleByRoleId(roleId);
    }

    /**
     * 通过id查询角色
     * @param roleId
     * @return
     */
    @Override
    public Role findRoleById(Integer roleId) {
        return roleMapper.findRoleById(roleId);
    }

    /**
     * 添加角色信息
     * @param role
     * @return
     */
    @Override
    public int addRole(Role role) {
        return roleMapper.addRole(role);
    }

    @Override
    public int updateRole(Role role) {
        return roleMapper.updateRole(role);
    }
}
