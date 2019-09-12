package com.sm.crm.entity;

import lombok.Data;

/**
 * 异常类型
 */

public enum ExceptionEnum {
    REQUEST_FAIL("请求失败",201),
    REFUSE("请求被拒绝",200);

    private String message;
    private int code;

    ExceptionEnum(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
