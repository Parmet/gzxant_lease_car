package com.gzxant.base.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;

public abstract class CarEntity <T extends Model> extends DataEntity<T> {

	private static final long serialVersionUID = 1L;
	  
	/**
	 * 车系名称
	 */
	@TableField(value ="car_train_name")
	protected String carTrainName;
	 
	/**
	 * 车型名称   
	 */
	@TableField(value ="car_size_name")
	protected String carSizeName;

	public String getCarTrainName() {
		return carTrainName;
	}

	public void setCarTrainName(String carTrainName) {
		this.carTrainName = carTrainName;
	}

	public String getCarSizeName() {
		return carSizeName;
	}

	public void setCarSizeName(String carSizeName) {
		this.carSizeName = carSizeName;
	}
	
	
}
