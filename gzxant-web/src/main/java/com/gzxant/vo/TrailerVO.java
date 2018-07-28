package com.gzxant.vo;


/**
 * TrailerVO
 * @author: Fatal
 * @date: 2018/7/26 0026 16:45
 */
public class TrailerVO {

    /** 车牌号 */
    private String carNumber;

    /** 类型 */
    private String type;

    /** 车辆所属公司名 */
    private String affiliatedOrganization;

    /** 执行人 */
    private String executor;

    /** 地址 */
    private String place;

    /** 执行时间 */
    private String date;

    /** 状态 字典 未处理 已拖车 已缴费 */
    private String status;

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAffiliatedOrganization() {
        return affiliatedOrganization;
    }

    public void setAffiliatedOrganization(String affiliatedOrganization) {
        this.affiliatedOrganization = affiliatedOrganization;
    }

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
