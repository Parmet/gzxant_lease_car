package com.gzxant.enums;

import com.gzxant.util.StringUtils;

/**
 * @author: Fatal
 * @date: 2018/7/27 0027 8:39
 */
public enum TrailerTypeEnum {

    OVERDUE_PAY("OVERDUE_PAY","逾期缴费"),
    ACCIDENT("ACCIDENT","事故"),
    FAULT("FAULT","故障"),
    ;

    private String code;

    private String message;

    TrailerTypeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static String getMessageByCode(String code) {
        TrailerTypeEnum[] values = values();
        if (!StringUtils.isEmpty(code)) {
            for (TrailerTypeEnum typeEnum : values) {
                if (typeEnum.getCode().equals(code)) {
                    return typeEnum.getMessage();
                }
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
