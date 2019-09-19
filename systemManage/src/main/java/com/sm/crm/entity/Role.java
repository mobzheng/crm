package com.sm.crm.entity;

import lombok.Data;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@Data
public class Role {
    private Long roleId;//角色id

    private String roleName;//角色名称

    private String roleDes;//角色描述

    private Integer roleState;//角色状态
    private String roleStateName;//角色状态

    private Integer depaId;//所属部门
    private String depaName;//所属部门

    private List<User> users;//该角色下的用户

    private List<Right> rights;//角色拥有的权限
    public String getRoleStateName() {
        return roleState==0?"无效":"有效";
    }
}