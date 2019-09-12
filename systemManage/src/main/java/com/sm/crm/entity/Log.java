package com.sm.crm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sm.crm.utils.DateConver;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.Data;

import java.util.Date;
@Data
public class Log {
    private Long logId;//日志ID

    private String userName;//用户名

    private String visitModel;//访问模块

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonSerialize(using = DateConver.class)
    private Date visitTime;//访问时间

    private String behaviour;//行为

    public Log(){}

    public Log(String userName, String visitModel, Date visitTime, String behaviour) {
        this.userName = userName;
        this.visitModel = visitModel;
        this.visitTime = visitTime;
        this.behaviour = behaviour;
    }
}