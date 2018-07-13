package com.gzxant.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.DataEntity;

@TableName("car_area")
public class CarArea extends DataEntity<CarArea>{

	private static final long serialVersionUID = 1L;

	/**
	 * 所属城市
	 */
	@TableField(value ="belong_city")
	private String belongCity;
	
	/**
	 * 联系人
	 */
	@TableField(value ="contact_person")
	private String contactPerson;
	
	/**
	 * 联系电话
	 */
	@TableField(value ="contact_number")
	private String contactNumber;
	
	/**
	 * 车场名称
	 */
	@TableField(value ="car_area_name")
	private String carAreaName;
	
	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	public String getBelongCity() {
		return belongCity;
	}

	public void setBelongCity(String belongCity) {
		this.belongCity = belongCity;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getCarAreaName() {
		return carAreaName;
	}

	public void setCarAreaName(String carAreaName) {
		this.carAreaName = carAreaName;
	}
	
}
