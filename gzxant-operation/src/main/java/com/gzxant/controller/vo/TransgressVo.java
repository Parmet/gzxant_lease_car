package com.gzxant.controller.vo;

import java.util.Date;

public class TransgressVo {
	
	private Integer id;                    	   //id
	private String plateNum;           	       //车牌号
	private String assetCompany;        	   //资产公司
	private String operateCompany;        	   //经营公司
	private String customer;        	 	   //客户
	private Date tgTimeStart;                  //违章时间开始
	private Date tgTimeEnd;                    //违章时间结束
	private Boolean status;        	 	   	   //状态:   1:已处理，0:未处理
	private Date updateTimeStart;              //处理时间开始
	private Date updateTimeEnd;                //处理时间结束
	
	
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
	public Date getTgTimeStart() {
		return tgTimeStart;
	}
	public void setTgTimeStart(Date tgTimeStart) {
		this.tgTimeStart = tgTimeStart;
	}
	public Date getTgTimeEnd() {
		return tgTimeEnd;
	}
	public void setTgTimeEnd(Date tgTimeEnd) {
		this.tgTimeEnd = tgTimeEnd;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Date getUpdateTimeStart() {
		return updateTimeStart;
	}
	public void setUpdateTimeStart(Date updateTimeStart) {
		this.updateTimeStart = updateTimeStart;
	}
	public Date getUpdateTimeEnd() {
		return updateTimeEnd;
	}
	public void setUpdateTimeEnd(Date updateTimeEnd) {
		this.updateTimeEnd = updateTimeEnd;
	}
	
	
}
