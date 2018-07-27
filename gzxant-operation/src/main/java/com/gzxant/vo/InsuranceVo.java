package com.gzxant.vo;

import com.gzxant.entity.insurance.InsuranceInfo;

public class InsuranceVo extends InsuranceInfo{
	private String assets_belong;	//车辆所属
	private String assets_state;	//资产状态
	private String vehicle_type;	//车型
	private String status;			//有效或无效
	
	public String getAssets_belong() {
		return assets_belong;
	}
	public void setAssets_belong(String assets_belong) {
		this.assets_belong = assets_belong;
	}
	public String getAssets_state() {
		return assets_state;
	}
	public void setAssets_state(String assets_state) {
		this.assets_state = assets_state;
	}
	public String getVehicle_type() {
		return vehicle_type;
	}
	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
