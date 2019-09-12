package com.sm.crm.entity;

import lombok.Data;

@Data
public class Role {
    private Long roleId;//角色id

    private String roleName;//角色名称

    private String roleDes;//角色描述

    private Integer roleState;//角色状态
    private String roleStateName;//角色状态

    private Integer depaId;//所属部门
    private String depaName;//所属部门

    public String getRoleStateName() {
        return roleState==0?"无效":"有效";
    }
}