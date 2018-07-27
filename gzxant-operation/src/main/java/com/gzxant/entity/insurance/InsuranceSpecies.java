package com.gzxant.entity.insurance;

import java.math.BigDecimal;
import java.util.Date;

public class InsuranceSpecies {
	private String code;
	private String insuranceItem;
	private String rate;
	private BigDecimal insuredAmount;
	private BigDecimal insurancePremium;
	private Date createTime;
	private Date updateTime;
	private String operator;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getInsuranceItem() {
		return insuranceItem;
	}
	public void setInsuranceItem(String insuranceItem) {
		this.insuranceItem = insuranceItem;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public BigDecimal getInsuredAmount() {
		return insuredAmount;
	}
	public void setInsuredAmount(BigDecimal insuredAmount) {
		this.insuredAmount = insuredAmount;
	}
	public BigDecimal getInsurancePremium() {
		return insurancePremium;
	}
	public void setInsurancePremium(BigDecimal insurancePremium) {
		this.insurancePremium = insurancePremium;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
}
