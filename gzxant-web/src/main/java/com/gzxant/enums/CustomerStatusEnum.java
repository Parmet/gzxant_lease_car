package com.gzxant.enums;

import com.gzxant.util.StringUtils;

/**
 * 客户状态枚举
 * @author: Fatal
 * @date: 2018/7/24 0024 22:02
 */
public enum CustomerStatusEnum {

    VD("VD","可用"),
    BK("BK", "禁止")
    ;

    private String code;
    private String message;

    CustomerStatusEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static String getMessageByCode(String code) {
        if (!StringUtils.isEmpty(code)) {
            CustomerStatusEnum[] statusEnums = values();
            for (CustomerStatusEnum statusEnum : statusEnums) {
                if (statusEnum.getCode().equals(code)) {
                    return statusEnum.getMessage();
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
