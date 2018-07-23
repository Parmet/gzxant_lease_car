package com.gzxant.enums;

/**
 * @author: Fatal
 * @date: 2018/7/22 0022 21:22
 */
public enum SexEnum {
    BOY("1","男"),
    GIRL("2","女"),
    ;

    private String code;

    private String message;

    SexEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
