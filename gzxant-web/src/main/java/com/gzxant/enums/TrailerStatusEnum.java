package com.gzxant.enums;

import com.gzxant.util.StringUtils;

/**
 * @author: Fatal
 * @date: 2018/7/27 0027 8:44
 */
public enum TrailerStatusEnum {
    UNTREATED("UNTREATED","未处理"),
    COMPLETE("COMPLETE","已处理"),
    PAID("PAID","已缴费")
    ;

    private String code;

    private String message;

    TrailerStatusEnum (String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static String getMessageByCode(String code) {
        if (!StringUtils.isEmpty(code)) {
            TrailerStatusEnum[] values = values();
            for (TrailerStatusEnum statusEnum : values) {
                if (statusEnum.getCode().equals(code)) {
                    return statusEnum.getMessage();
                }
            }
        }
        return null;
    }

}
