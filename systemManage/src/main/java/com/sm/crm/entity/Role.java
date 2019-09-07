package com.sm.crm.entity;

import lombok.Data;

@Data
public class Role {
    private Long roleId;

    private String roleName;

    private String roleDes;

    private Integer roleState;

    private Integer depaId;


}