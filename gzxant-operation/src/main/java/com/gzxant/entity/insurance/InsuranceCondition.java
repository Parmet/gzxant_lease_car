package com.gzxant.entity.insurance;

import java.util.Date;

/**
 * @author: Fatal
 * @date: 2018/7/29 0029 17:59
 */
public class InsuranceCondition {

    /** 公司id */
    private Long id;

    /** 开始日期 */
    private Date beginDate;

    /** 结束日期 */
    private Date endDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public InsuranceCondition(Long id, Date beginDate, Date endDate) {
        this.id = id;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }
}
