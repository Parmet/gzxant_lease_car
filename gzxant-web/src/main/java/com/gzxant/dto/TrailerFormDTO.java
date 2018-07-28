package com.gzxant.dto;


import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author: Fatal
 * @date: 2018/7/27 0027 11:38
 */
public class TrailerFormDTO extends TrailerDTO {

    /** 拖车费用 */
    @NotNull(message = "拖车费用 不能为空")
    private BigDecimal cost;

    private String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }


}
