package com.gzxant.enums;

/**
 * 证件枚举
 * @author: Fatal
 * @date: 2018/7/22 0022 10:47
 */
public enum CertificatesStatusEnum {

    IDENTITY("0","身份证"),
    DRIVE("1","驾驶证");

    private String code;
    private String message;

    CertificatesStatusEnum(String code, String message) {
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
