package com.gzxant.enums;

/**
 * @author: Fatal
 * @date: 2018/7/22 0022 11:14
 */
public enum LeaseCarEnum {

    CUSTOMER_ADD_FAIL(10,"客户添加失败"),
    CUSTOMER_ADD_PAGE_ECHO_FAIL(11,"客户添加页面回显失败"),
    PLEASE_SELECT_THE_DATA(12, "请选择需要批量删除的数据"),
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
