package com.sm.crm.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Log {
    private Long logId;

    private String userName;

    private String visitModel;

    private Date visitTime;

    private String behaviour;

}