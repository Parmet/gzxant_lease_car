package com.gzxant.exception;

import com.gzxant.enums.LeaseCarEnum;

/**
 * 全局异常
 * @author: Fatal
 * @date: 2018/7/22 0022 11:16
 */
public class LeaseCatException extends RuntimeException {

    private Integer code;

    public LeaseCatException(LeaseCarEnum leaseCarEnum) {
        super(leaseCarEnum.getMessage());
        this.code = leaseCarEnum.getCode();
    }

    public LeaseCatException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public LeaseCatException(String message) {
        super(message);
        this.code = 500;
    }

    public Integer getCode() {
        return code;
    }
}
