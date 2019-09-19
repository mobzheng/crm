package com.sm.crm.entity;

import lombok.Data;

import java.util.List;

@Data
public class Menu {
    private Long menuId;

    private String menuName;

    private String menuUrl;

    private Long pid;

    private List<Menu> children;//子菜单

    private List<Right> rights;//菜单所属的权限

}