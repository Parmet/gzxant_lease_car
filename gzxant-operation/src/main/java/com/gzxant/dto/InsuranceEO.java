package com.gzxant.dto;

import java.util.Date;

public class InsuranceEO {
	private String assets_belong;
	private String carType;
	private String carNo;
	private String insuranceNo;
	private Date workDate;
	private Date expiryDate;
	private Integer distanceExpiryDay;
	private Integer status; //0-失效     1-正常
	private Integer pageNo = 1;
	private Integer pageSize = 20;
	private Integer start = (pageNo - 1) * pageSize;
	
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public String getAssets_belong() {
		return assets_belong;
	}
	public void setAssets_belong(String assets_belong) {
		this.assets_belong = assets_belong;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	public String getInsuranceNo() {
		return insuranceNo;
	}
	public void setInsuranceNo(String insuranceNo) {
		this.insuranceNo = insuranceNo;
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
	public Integer getDistanceExpiryDay() {
		return distanceExpiryDay;
	}
	public void setDistanceExpiryDay(Integer distanceExpiryDay) {
		this.distanceExpiryDay = distanceExpiryDay;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}
