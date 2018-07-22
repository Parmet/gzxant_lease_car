package com.gzxant.entity.transgress;

import java.util.Date;

public class Transgress {
	
	private Integer id;                    		//id
	private String plate_num;           	    //车牌号
	private String type;             		    //车牌类型
	private String brand;             	        //品牌
	private Integer deduction;             	 	//扣分
	private Integer fine;             	  	  	//罚款
	private String asset_company;        	    //资产公司
	private String operate_company;        	    //经营公司
	private String customer;        	 	    //客户
	private Date tg_time;        	 	        //违章时间
	private String place;        	 	        //违章地点
	private String reason;        	 	        //违章原因
	private String department;        	 	    //采集机关
	private Boolean commisson;        	 	    //是否可以代办:   1:是，0:否
	private Integer code;        	 	   	    //违章代码
	private Integer tg_num;        	 	   	    //违章项文书编号
	private Boolean status;        	 	   	    //状态:   1:已处理，0:未处理
	private Date query_time;        	        //数据查询时间
	private Date update_time;        	        //更新为已处理时间
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPlate_num() {
		return plate_num;
	}
	public void setPlate_num(String plate_num) {
		this.plate_num = plate_num;
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
	public String getAsset_company() {
		return asset_company;
	}
	public void setAsset_company(String asset_company) {
		this.asset_company = asset_company;
	}
	public String getOperate_company() {
		return operate_company;
	}
	public void setOperate_company(String operate_company) {
		this.operate_company = operate_company;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public Date getTg_time() {
		return tg_time;
	}
	public void setTg_time(Date tg_time) {
		this.tg_time = tg_time;
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
	public Integer getTg_num() {
		return tg_num;
	}
	public void setTg_num(Integer tg_num) {
		this.tg_num = tg_num;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Date getQuery_time() {
		return query_time;
	}
	public void setQuery_time(Date query_time) {
		this.query_time = query_time;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	
	
}
