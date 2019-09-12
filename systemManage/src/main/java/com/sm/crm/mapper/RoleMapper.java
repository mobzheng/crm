package com.sm.crm.mapper;

import com.sm.crm.entity.Role;
import com.sm.crm.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {

    List<Role> findRoleByUser(User user);

    List<Role> findAllRole();

    int updateRoleRight(@Param("roleId") Integer roleId, @Param("rights") String[] rights);

    void deleteRoleRightById(@Param("roleId") Integer roleId);

    void deleteRoleByRoleId(Integer roleId);

    Role findRoleById(Integer roleId);

    int addRole(Role role);

    int updateRole(Role role);
}
