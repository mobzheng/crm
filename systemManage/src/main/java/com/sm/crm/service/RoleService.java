package com.sm.crm.service;

import com.github.pagehelper.PageInfo;
import com.sm.crm.entity.Role;

public interface RoleService {
    PageInfo<Role> findAllRole(Integer currentPage, Integer pageSize);

    int updateRoleRight(Integer roleId, String[] rights);

    void deleteRoleRightByRoleId(Integer roleId);

    void deleteRoleByRoleId(Integer roleId);

    Role findRoleById(Integer roleId);

    int addRole(Role role);

    int updateRole(Role role);
}
