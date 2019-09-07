package com.sm.crm.entity;

import lombok.Data;

import java.util.List;

@Data
public class Menu {
    private Long menuId;

    private String menuName;

    private String menuUrl;

    private Long pid;

    private Menu menu;//父级菜单

    private List<Menu> menus;//子菜单

}