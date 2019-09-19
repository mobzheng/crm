package com.sm.crm.entity;

import lombok.Data;

import java.util.List;

@Data
public class Right {
    private Long rid;//权限id

    private String rName;//权限名称

    private String rDes;//权限描述

    private Integer rState;//权限状态

    private String rStateStr;//权限状态描述

    private List<Menu> menus;//权限详情

    private List<Role> roles;//权限所属的角色
    public String getrStateStr() {
        return rState == 0 ? "无效" : "有效";
    }

}