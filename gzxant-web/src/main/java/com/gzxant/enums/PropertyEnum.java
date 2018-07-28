package com.gzxant.enums;

import com.gzxant.util.StringUtils;

/**
 * 公司性质枚举
 * @author: Fatal
 * @date: 2018/7/24 0024 21:00
 */
public enum PropertyEnum {

    PRIVATELY_OPERATED("PrivatelyOperated", "民营"),
    PRIVATE_ENTERPRISE("PrivateEnterprise", "私企"),
    ;

    private String code;

    private String message;

    PropertyEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static String getMessageByCode(String code) {
        if (!StringUtils.isEmpty(code)) {
            PropertyEnum[] propertyEnums = values();
            for (PropertyEnum propertyEnum : propertyEnums) {
                if (propertyEnum.getCode().equals(code)) {
                    return propertyEnum.getMessage();
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
