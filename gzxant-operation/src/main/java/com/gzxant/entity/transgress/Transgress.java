package com.gzxant.entity.transgress;

import java.util.Date;

public class Transgress {
	
	private Integer id;                    		//id
	private String plateNum;           	    	//车牌号
	private String type;             		    //车牌类型
	private String brand;             	        //品牌
	private Integer deduction;             	 	//扣分
	private Integer fine;             	  	  	//罚款
	private String assetCompany;        	    //资产公司
	private String operateCompany;        	    //经营公司
	private String customer;        	 	    //客户
	private Date tgTime;        	 	        //违章时间
	private String place;        	 	        //违章地点
	private String reason;        	 	        //违章原因
	private String department;        	 	    //采集机关
	private Boolean commisson;        	 	    //是否可以代办:   1:是，0:否
	private Integer code;        	 	   	    //违章代码
	private Integer tgNum;        	 	   	    //违章项文书编号
	private Boolean status;        	 	   	    //状态:   1:已处理，0:未处理
	private Date queryTime;        	        	//数据查询时间
	private Date updateTime;        	        //更新为已处理时间
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPlateNum() {
		return plateNum;
	}
	public void setPlateNum(String plateNum) {
		this.plateNum = plateNum;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Integer getDeduction() {
		return deduction;
	}
	public void setDeduction(Integer deduction) {
		this.deduction = deduction;
	}
	public Integer getFine() {
		return fine;
	}
	public void setFine(Integer fine) {
		this.fine = fine;
	}
	public String getAssetCompany() {
		return assetCompany;
	}
	public void setAssetCompany(String assetCompany) {
		this.assetCompany = assetCompany;
	}
	public String getOperateCompany() {
		return operateCompany;
	}
	public void setOperateCompany(String operateCompany) {
		this.operateCompany = operateCompany;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public Date getTgTime() {
		return tgTime;
	}
	public void setTgTime(Date tgTime) {
		this.tgTime = tgTime;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Boolean getCommisson() {
		return commisson;
	}
	public void setCommisson(Boolean commisson) {
		this.commisson = commisson;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public Integer getTgNum() {
		return tgNum;
	}
	public void setTgNum(Integer tgNum) {
		this.tgNum = tgNum;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Date getQueryTime() {
		return queryTime;
	}
	public void setQueryTime(Date queryTime) {
		this.queryTime = queryTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	
	
}
