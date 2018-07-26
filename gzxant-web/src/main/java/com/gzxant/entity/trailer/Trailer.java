package com.gzxant.entity.trailer;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.DataEntity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: Fatal
 * @date: 2018/7/26 0026 16:04
 */
@TableName("trailer")
public class Trailer extends DataEntity<Trailer> {

    /** 车牌号 */
    @TableField("car_number")
    private String carNumber;

    /** 类型 */
    private String type;

    /** 车辆所属 引用 */
    @TableField("belongsto_id")
    private Long belongstoId;

    /** 执行人 */
    private String executor;

    /** 地址 */
    private String place;

    /** 执行时间 */
    private Date date;

    /** 状态 字典 未处理 已拖车 已缴费 */
    private String status;

    /** 拖车费用 */
    private BigDecimal cost;

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

    public Long getBelongstoId() {
        return belongstoId;
    }

    public void setBelongstoId(Long belongstoId) {
        this.belongstoId = belongstoId;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

}
