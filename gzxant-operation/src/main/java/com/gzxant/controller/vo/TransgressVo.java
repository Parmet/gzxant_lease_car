package com.gzxant.controller.vo;

import java.util.Date;

public class TransgressVo {
	
	private int id;                    		   //id
	private String plateNum;           	       //车牌号
	private int assetCompany;        	  	   //资产公司
	private int operateCompany;        	       //经营公司
	private String customer;        	 	   //客户
	private Date tgTimeStatus;                 //违章时间开始
	private Date tgTimeEnd;                    //违章时间结束
	private Boolean status;        	 	   	   //状态:   1:已处理，0:未处理
	private Date updateTimeStatus;             //处理时间开始
	private Date updateTimeEnd;                //处理时间结束
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlateNum() {
		return plateNum;
	}
	public void setPlateNum(String plateNum) {
		this.plateNum = plateNum;
	}
	public int getAssetCompany() {
		return assetCompany;
	}
	public void setAssetCompany(int assetCompany) {
		this.assetCompany = assetCompany;
	}
	public int getOperateCompany() {
		return operateCompany;
	}
	public void setOperateCompany(int operateCompany) {
		this.operateCompany = operateCompany;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public Date getTgTimeStatus() {
		return tgTimeStatus;
	}
	public void setTgTimeStatus(Date tgTimeStatus) {
		this.tgTimeStatus = tgTimeStatus;
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
	public Date getUpdateTimeStatus() {
		return updateTimeStatus;
	}
	public void setUpdateTimeStatus(Date updateTimeStatus) {
		this.updateTimeStatus = updateTimeStatus;
	}
	public Date getUpdateTimeEnd() {
		return updateTimeEnd;
	}
	public void setUpdateTimeEnd(Date updateTimeEnd) {
		this.updateTimeEnd = updateTimeEnd;
	}
	

}
