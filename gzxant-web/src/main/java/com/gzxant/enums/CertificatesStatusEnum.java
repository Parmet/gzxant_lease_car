package com.gzxant.enums;

/**
 * @author: Fatal
 * @date: 2018/7/22 0022 10:47
 */
public enum CertificatesStatusEnum {

    IDENTITY(0,"身份证"),
    DRIVE(1,"驾驶证");

    private Integer code;
    private String message;

    CertificatesStatusEnum(Integer code, String message) {
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
