package com.sm.crm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sm.crm.utils.DateConver;
import lombok.Data;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Data
public class User {
    private Long uid;

    private String userName;

    private String password;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonSerialize(using = DateConver.class)
    private Date creatDate;

    private String realName;

    private String gender;

    private String phone;

    private String email;

    private Long depaId;

    private String depaName;

    private List<Role> roles;//用户拥有的角色

    public String getGender() {
        return "male".equals(gender)?"女":"男";
    }
}