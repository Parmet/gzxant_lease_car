package com.gzxant.enums;

import com.gzxant.util.StringUtils;

/**
 * 公司类型枚举
 * @author: Fatal
 * @date: 2018/7/24 0024 21:42
 */
public enum CategoryEnum {

    AGENCY_COMPANY("AgencyCompany","代理公司"),
    ASSET_COMPANY("AssetCompany","资产公司"),
    SUBSIDIARY("Subsidiary", "子公司")
    ;
    private String code;

    private String message;

    CategoryEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static String getMessageByCode(String code) {
        if (!StringUtils.isEmpty(code)) {
            CategoryEnum[] categoryEnums = values();
            for (CategoryEnum categoryEnum : categoryEnums) {
                if (categoryEnum.getCode().equals(code)) {
                    return categoryEnum.getMessage();
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
