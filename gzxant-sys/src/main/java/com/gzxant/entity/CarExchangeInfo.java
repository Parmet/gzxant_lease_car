package com.gzxant.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.DataEntity;

@TableName("car_exchange_info")
public class CarExchangeInfo extends DataEntity<CarExchangeInfo>{

	private static final long serialVersionUID = 1L;

	/**
	 * 合同编号
	 */
	@TableField(value ="contract_no")
	public String contractNo;
	
	/**
	 * 车牌号
	 */
	@TableField(value ="car_number")
	public String carNumber;
	
	/**
	 * 申请车牌号
	 */
	@TableField(value ="apply_car_number")
	public String applyCarNumber;
	
	/**
	 * 申请日期
	 */
	@TableField(value ="apply_date")
	public String applyDate;
	
	/**
	 * 申请人
	 */
	public String applicant;
	
	/**
	 * 申请人身份证号
	 */
	@TableField(value ="applicant_IDNum")
	public String applicantIDNum;
	
	/**
	 * 申请单位
	 */
	@TableField(value ="application_unit")
	public String applicationUnit;
	
	/**
	 * 申请原因
	 */
	@TableField(value ="apply_reason")
	public String applyReason;
	
	
	
	public String getContractNo() {
		return contractNo;
	}



	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}



	public String getCarNumber() {
		return carNumber;
	}



	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}



	public String getApplyCarNumber() {
		return applyCarNumber;
	}



	public void setApplyCarNumber(String applyCarNumber) {
		this.applyCarNumber = applyCarNumber;
	}



	public String getApplyDate() {
		return applyDate;
	}



	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}



	public String getApplicant() {
		return applicant;
	}



	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}



	public String getApplicantIDNum() {
		return applicantIDNum;
	}



	public void setApplicantIDNum(String applicantIDNum) {
		this.applicantIDNum = applicantIDNum;
	}



	public String getApplicationUnit() {
		return applicationUnit;
	}



	public void setApplicationUnit(String applicationUnit) {
		this.applicationUnit = applicationUnit;
	}



	public String getApplyReason() {
		return applyReason;
	}



	public void setApplyReason(String applyReason) {
		this.applyReason = applyReason;
	}



	@Override
	protected Serializable pkVal() {
		return null;
	}

}
