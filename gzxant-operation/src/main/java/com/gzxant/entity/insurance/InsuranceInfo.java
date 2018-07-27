package com.gzxant.entity.insurance;

import java.math.BigDecimal;
import java.util.Date;

public class InsuranceInfo {
	private String code;
	private String carNo;
	private String buyOrganization;
	private String insuranceNo;
	private String insuranceType;
	private String insuranceCompany;
	private String carAgeLimit;
	private String insuranceCommissioner;
	private BigDecimal insuranceTotalAmount;
	private Date workDate;
	private Date expiryDate;
	private String claimsTel;
	private String agentName;
	private Date createTime;
	private Date updateTime;
	private String operator;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	public String getBuyOrganization() {
		return buyOrganization;
	}
	public void setBuyOrganization(String buyOrganization) {
		this.buyOrganization = buyOrganization;
	}
	public String getInsuranceNo() {
		return insuranceNo;
	}
	public void setInsuranceNo(String insuranceNo) {
		this.insuranceNo = insuranceNo;
	}
	public String getInsuranceType() {
		return insuranceType;
	}
	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}
	public String getInsuranceCompany() {
		return insuranceCompany;
	}
	public void setInsuranceCompany(String insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
	}
	public String getCarAgeLimit() {
		return carAgeLimit;
	}
	public void setCarAgeLimit(String carAgeLimit) {
		this.carAgeLimit = carAgeLimit;
	}
	public String getInsuranceCommissioner() {
		return insuranceCommissioner;
	}
	public void setInsuranceCommissioner(String insuranceCommissioner) {
		this.insuranceCommissioner = insuranceCommissioner;
	}
	public BigDecimal getInsuranceTotalAmount() {
		return insuranceTotalAmount;
	}
	public void setInsuranceTotalAmount(BigDecimal insuranceTotalAmount) {
		this.insuranceTotalAmount = insuranceTotalAmount;
	}
	public Date getWorkDate() {
		return workDate;
	}
	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getClaimsTel() {
		return claimsTel;
	}
	public void setClaimsTel(String claimsTel) {
		this.claimsTel = claimsTel;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
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
