package com.sm.crm.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class User {
    private Long uid;

    private String userName;

    private String password;

    private Date creatDate;

    private String realName;

    private String gender;

    private String phone;

    private String email;

    private Long depaId;

    private List<Role> roles;//用户拥有的角色


}