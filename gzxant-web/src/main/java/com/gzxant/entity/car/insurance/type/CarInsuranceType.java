package com.gzxant.entity.car.insurance.type;

import java.io.Serializable;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.DataEntity;

/**
 * <p>
 * 保险种类
 * </p>
 *
 * @author ycxiao
 * @since 2018-07-30
 */
@TableName("car_insurance_type")
public class CarInsuranceType extends DataEntity<CarInsuranceType> {

    private static final long serialVersionUID = 1L;

    /**
     * 保险细项
     */
	private String term;
    /**
     * 费率（%）
     */
	private BigDecimal rate;
    /**
     * 被保金额
     */
	@TableField("be_insurance_cost")
	private BigDecimal beInsuranceCost;
    /**
     * 保费
     */
	@TableField("insurance_cost")
	private BigDecimal insuranceCost;
    /**
     * 保险所属 引用
     */
	@TableField("car_insurance_id")
	private Long carInsuranceId;

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public BigDecimal getBeInsuranceCost() {
		return beInsuranceCost;
	}

	public void setBeInsuranceCost(BigDecimal beInsuranceCost) {
		this.beInsuranceCost = beInsuranceCost;
	}

	public BigDecimal getInsuranceCost() {
		return insuranceCost;
	}

	public void setInsuranceCost(BigDecimal insuranceCost) {
		this.insuranceCost = insuranceCost;
	}

	public Long getCarInsuranceId() {
		return carInsuranceId;
	}

	public void setCarInsuranceId(Long carInsuranceId) {
		this.carInsuranceId = carInsuranceId;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "CarInsuranceType{" +
			"term=" + term +
			", rate=" + rate +
			", beInsuranceCost=" + beInsuranceCost +
			", insuranceCost=" + insuranceCost +
			", carInsuranceId=" + carInsuranceId +
			"}";
	}
}
