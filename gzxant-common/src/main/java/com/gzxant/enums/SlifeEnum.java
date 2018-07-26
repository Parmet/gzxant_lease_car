package com.gzxant.enums;

/**
 * @author: Fatal
 * @date: 2018/7/26 0026 19:17
 */
public enum SlifeEnum {
    REQUEST_PARAMETER_ERROR(100,"请求参数有误"),
    ;

    private Integer code;

    private String message;

    SlifeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
