package com.gzxant.entity;

import java.io.Serializable;
import java.sql.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.CarEntity;

@TableName("car")
public class Car extends CarEntity<Car>{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 服务城市
	 */
	@TableField(value ="service_city")
	private String serviceCity;
	
	/**
	 * 车牌号码 
	 */
	@TableField(value ="car_number")
	private String carNumber;
	
	/**
	 * 车场
	 */
	@TableField(value ="car_park")
	private String carPark;
	
	/**
	 * 网店
	 */
	@TableField(value ="online_store")
	private String onlineStore;
	
	/**
	 * 车辆颜色
	 */
	@TableField(value ="car_color")
	private String carColor;
	
	/**
	 * 车辆全名
	 */
	@TableField(value ="car_name")
	private String carName;
	
	/**
	 * 所属城市
	 */
	@TableField(value ="belong_city")
	private String belongCity;
	
	/**
	 * 续航里程
	 */
	private String mileage;
	
	/**
	 * 发动机号
	 */
	@TableField(value ="motor_number")
	private String motorNumber;
	
	/**
	 * 保险到期时间
	 */
	@TableField(value ="insurance_date")
	private Date insuranceDate;
	
	/**
	 * 年检时间
	 */
	@TableField(value ="annual_survey_date")
	private Date annualSurveyDate;
	
	/**
	 * 车架号
	 */
	private String vin;
	
	/**
	 * 车龄
	 */
	@TableField(value ="car_age")
	private Integer carAge;
	
	/**
	 * SN
	 */
	private Long sn;
	
	/**
	 * Code
	 */
	private String code;
	
	/**
	 * 机车类型
	 */
	@TableField(value ="ecar_type")
	private String ecarType;
	
	/**
	 * 车辆来源
	 */
	@TableField(value ="car_source")
	private String carSource;
	
	/**
	 * 蓝牙模式
	 */
	@TableField(value ="bluetooth_mode")
	private boolean bluetoothMode;
	
	/**
	 * 寻车模式
	 */
	@TableField(value ="find_car_type")
	private boolean findCarType;
	
	/**
	 * 百公里油耗
	 */
	@TableField(value ="oil_wear")
	private Integer oilWear;
	
	public String getServiceCity() {
		return serviceCity;
	}


	public void setServiceCity(String serviceCity) {
		this.serviceCity = serviceCity;
	}

	
	public String getCarNumber() {
		return carNumber;
	}


	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}


	public String getCarPark() {
		return carPark;
	}


	public void setCarPark(String carPark) {
		this.carPark = carPark;
	}


	public String getOnlineStore() {
		return onlineStore;
	}


	public void setOnlineStore(String onlineStore) {
		this.onlineStore = onlineStore;
	}


	public String getCarColor() {
		return carColor;
	}


	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}


	public String getCarName() {
		return carName;
	}


	public void setCarName(String carName) {
		this.carName = carName;
	}


	public String getBelongCity() {
		return belongCity;
	}


	public void setBelongCity(String belongCity) {
		this.belongCity = belongCity;
	}


	public String getMileage() {
		return mileage;
	}


	public void setMileage(String mileage) {
		this.mileage = mileage;
	}


	public String getMotorNumber() {
		return motorNumber;
	}


	public void setMotorNumber(String motorNumber) {
		this.motorNumber = motorNumber;
	}


	public Date getInsuranceDate() {
		return insuranceDate;
	}


	public void setInsuranceDate(Date insuranceDate) {
		this.insuranceDate = insuranceDate;
	}


	public Date getAnnualSurveyDate() {
		return annualSurveyDate;
	}


	public void setAnnualSurveyDate(Date annualSurveyDate) {
		this.annualSurveyDate = annualSurveyDate;
	}


	public String getVin() {
		return vin;
	}


	public void setVin(String vin) {
		this.vin = vin;
	}


	public Integer getCarAge() {
		return carAge;
	}


	public void setCarAge(Integer carAge) {
		this.carAge = carAge;
	}


	public Long getSn() {
		return sn;
	}


	public void setSn(Long sn) {
		this.sn = sn;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getEcarType() {
		return ecarType;
	}


	public void setEcarType(String ecarType) {
		this.ecarType = ecarType;
	}


	public String getCarSource() {
		return carSource;
	}


	public void setCarSource(String carSource) {
		this.carSource = carSource;
	}


	public boolean isBluetoothMode() {
		return bluetoothMode;
	}


	public void setBluetoothMode(boolean bluetoothMode) {
		this.bluetoothMode = bluetoothMode;
	}


	public boolean isFindCarType() {
		return findCarType;
	}


	public void setFindCarType(boolean findCarType) {
		this.findCarType = findCarType;
	}


	public Integer getOilWear() {
		return oilWear;
	}


	public void setOilWear(Integer oilWear) {
		this.oilWear = oilWear;
	}

	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
