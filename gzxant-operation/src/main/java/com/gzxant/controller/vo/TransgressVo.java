package com.gzxant.controller.vo;

import net.sf.jsqlparser.expression.DateTimeLiteralExpression.DateTime;

public class TransgressVo {
	
	private int id;                    		   //id
	private int user_id;					   //用户id
	private String plate_num;           	   //车牌号
	private int asset_company;        	  	   //资产公司
	private int operate_company;        	   //经营公司
	private String customer;        	 	   //客户
	private DateTime tg_time_status;           //违章时间开始
	private DateTime tg_time_end;              //违章时间结束
	private Boolean status;        	 	   	   //状态:   1:已处理，0:未处理
	private DateTime update_time_status;       //处理时间开始
	private DateTime update_time_end;          //处理时间结束
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getPlate_num() {
		return plate_num;
	}
	public void setPlate_num(String plate_num) {
		this.plate_num = plate_num;
	}
	public int getAsset_company() {
		return asset_company;
	}
	public void setAsset_company(int asset_company) {
		this.asset_company = asset_company;
	}
	public int getOperate_company() {
		return operate_company;
	}
	public void setOperate_company(int operate_company) {
		this.operate_company = operate_company;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public DateTime getTg_time_status() {
		return tg_time_status;
	}
	public void setTg_time_status(DateTime tg_time_status) {
		this.tg_time_status = tg_time_status;
	}
	public DateTime getTg_time_end() {
		return tg_time_end;
	}
	public void setTg_time_end(DateTime tg_time_end) {
		this.tg_time_end = tg_time_end;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public DateTime getUpdate_time_status() {
		return update_time_status;
	}
	public void setUpdate_time_status(DateTime update_time_status) {
		this.update_time_status = update_time_status;
	}
	public DateTime getUpdate_time_end() {
		return update_time_end;
	}
	public void setUpdate_time_end(DateTime update_time_end) {
		this.update_time_end = update_time_end;
	}
	
	

}
