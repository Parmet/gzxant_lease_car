package com.gzxant.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.CarEntity;

@TableName("car_set")
public class CarSet extends CarEntity<CarSet>{
	
	/**
	 * 里程阈值
	 */
	@TableField(value ="mileage_threshold")
	private Integer mileageThreshold;
	
	/**
	 * 电量/油量阈值
	 */
	@TableField(value ="eo_threshold")
	private Integer eoThreshold;
	
	/**
	 * 车型图片
	 */
	private String photo;

	
	@Override
	protected Serializable pkVal() {
		return null;
	}

	public Integer getMileageThreshold() {
		return mileageThreshold;
	}

	public void setMileageThreshold(Integer mileageThreshold) {
		this.mileageThreshold = mileageThreshold;
	}

	public Integer getEoThreshold() {
		return eoThreshold;
	}

	public void setEoThreshold(Integer eoThreshold) {
		this.eoThreshold = eoThreshold;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
}
