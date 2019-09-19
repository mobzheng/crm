package com.sm.crm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sm.crm.utils.DateJsonSerializer;
import lombok.Builder;
import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class User {
    private Long uid;

    private String userName;

    private String password;

    @JsonSerialize(using = DateJsonSerializer.class)
    private Date creatDate;

    private String realName;

    private String gender;

    private String phone;

    private String email;

    private Long depaId;

    private String depaName;

    private Role role;//用户拥有的角色

}