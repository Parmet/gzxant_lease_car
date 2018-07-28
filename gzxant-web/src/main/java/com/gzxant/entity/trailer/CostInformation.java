package com.gzxant.entity.trailer;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.DataEntity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: Fatal
 * @date: 2018/7/26 0026 16:26
 */
@TableName("cost_information")
public class CostInformation extends DataEntity<CostInformation> {

    /** 类型 字典 缴费逾期 事故 故障 */
    private String type;

    /** 编号 */
    @TableField("trailer_id")
    private String trailerId;

    /** 费用 */
    private BigDecimal cost;

    /** 日期 */
    private Date date;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }
}
