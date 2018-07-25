package com.gzxant.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.DataEntity;

@TableName("car_area")
public class CarArea extends DataEntity<CarArea>{

	private static final long serialVersionUID = 1L;

	/**
	 * 所属组织
	 */
	@TableField(value ="belong_organization")
	private String belongOrganization;
	
	/**
	 * 车区名称
	 */
	@TableField(value ="car_area_name")
	private String carAreaName;
	
	/**
	 * 地址
	 */
	private String address;
	
	
	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	public String getCarAreaName() {
		return carAreaName;
	}

	public void setCarAreaName(String carAreaName) {
		this.carAreaName = carAreaName;
	}

	public String getBelongOrganization() {
		return belongOrganization;
	}

	public void setBelongOrganization(String belongOrganization) {
		this.belongOrganization = belongOrganization;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
