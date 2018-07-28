package com.gzxant.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * CostInfoVO
 * @author: Fatal
 * @date: 2018/7/27 0027 14:12
 */
public class CostInfoVO {

    private Long id;

    private String type;

    /** 编号 */
    private String trailerId;

    /** 费用 */
    private BigDecimal cost;

    /** 日期 */
    private String date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTrailerId() {
        return trailerId;
    }

    public void setTrailerId(String trailerId) {
        this.trailerId = trailerId;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
