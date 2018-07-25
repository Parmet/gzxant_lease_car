package com.gzxant.enums;

/**
 * @author: Fatal
 * @date: 2018/7/22 0022 11:14
 */
public enum LeaseCarEnum {

    CUSTOMER_OR_UPDATE_ADD_FAIL(10,"客户管理--客户添加或更新失败"),
    CUSTOMER_ADD_PAGE_ECHO_FAIL(11,"客户添加页面回显失败"),
    PLEASE_SELECT_THE_DATA(12, "请选择需要批量删除的数据"),
    COMPANY_OR_UPDATE_ADD_FAIL(13,"客户管理--公司添加或更新失败"),
    CONTACT_SHOW_FAIL_WITH_ID_IS_NULL(14, "客户管理--联系人页面显示失败    id为空"),
    CONTACT_SHOW_FAIL_WITH_CONVERT_FAIL(15, "客户管理--联系人页面显示失败    数据转换失败"),
    CONTACT_OR_UPDATE_ADD_FAIL(16, "客户管理--联系人添加或更新失败"),
    ;

    private Integer code;

    private String message;

    LeaseCarEnum(Integer code, String message) {
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
