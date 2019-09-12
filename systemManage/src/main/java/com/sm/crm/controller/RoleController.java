package com.sm.crm.controller;

import com.github.pagehelper.PageInfo;
import com.sm.crm.entity.Role;
import com.sm.crm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 权限controller层
 */
@RestController
@CrossOrigin
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 查询所有的角色
     *
     * @return
     */
    @GetMapping("findAll")
    public ResponseEntity<PageInfo<Role>> findAllRoles(Integer currentPage, Integer pageSize) {
        PageInfo<Role> allRole = roleService.findAllRole(currentPage, pageSize);
        return ResponseEntity.ok(allRole);
    }

    /**
     * 修改角色权限映射
     *
     * @param roleId
     * @param rights
     * @return
     */
    @PutMapping("updateRoleRight")
    public ResponseEntity<String> updateRoleRight(Integer roleId, String[] rights) {
        roleService.deleteRoleRightByRoleId(roleId);
        roleService.updateRoleRight(roleId, rights);
        return ResponseEntity.ok("success");
    }


    /**
     * 根据id查找角色
     *
     * @param roleId
     * @return
     */
    @GetMapping("findRoleById")
    public ResponseEntity<Role> findRoleById(Integer roleId) {
        Role roleById = roleService.findRoleById(roleId);
        return ResponseEntity.ok(roleById);
    }

    /**
     * 添加角色
     *
     * @param role
     * @return
     */
    @PostMapping("addRole")
    public ResponseEntity<String> addRole(@RequestBody Role role) {
        roleService.addRole(role);
        return ResponseEntity.ok("success");
    }

    /**
     * 删除角色
     *
     * @param roleId
     * @return
     */
    @DeleteMapping("deleteRole")
    public ResponseEntity<String> deleteRole(Integer roleId) {
        roleService.deleteRoleByRoleId(roleId);
        return ResponseEntity.ok("success");
    }


    /**
     * 修改角色信息
     *
     * @param role
     * @return
     */
    @PutMapping("updateRole")
    public ResponseEntity<String> updateRole(@RequestBody Role role) {
        roleService.updateRole(role);
        return ResponseEntity.ok("success");
    }


}
