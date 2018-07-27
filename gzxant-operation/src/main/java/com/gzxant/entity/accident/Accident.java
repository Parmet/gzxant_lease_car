package com.gzxant.entity.accident;

import java.util.Date;

public class Accident {
	
	private Integer id;								//id
	private String plateNum;						//车牌号
	private String brand;							//品牌
	private Date accidentTime;						//违章时间
	private String accidentPlace;					//事故地点
	private String modelNum;						//车型号
	private String vin;								//车架号
	private String details;							//事故详情
	private String userUnit;						//使用单位
	private String driver;							//驾驶员
	private Integer useNature;						//使用性质
	private Integer responsibilityDivide;			//责任划分
	private Integer minorWound;						//轻伤
	private Integer seriousInjury;					//重伤
	private Integer death;							//死亡
	private Integer myselfLoss;						//我方经济损失
	private Integer myselfTreatmentCost;			//我方医疗费用
	private Integer thirdPartyLoss;					//三者经济损失
	private Integer thirdPartyTreatmentCost;		//三者医疗费用
	private Integer reimbursementCost;				//已赔付费用
	private Integer grade;							//事故等级
	private Integer status;							//处理状态
	private Integer operNature;						//事故性质
	private String schedule;						//事故处理进度
	private String remake;							//备注
	private String attachmentPath;					//事故附件信息
	
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
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Date getAccidentTime() {
		return accidentTime;
	}
	public void setAccidentTime(Date accidentTime) {
		this.accidentTime = accidentTime;
	}
	public String getAccidentPlace() {
		return accidentPlace;
	}
	public void setAccidentPlace(String accidentPlace) {
		this.accidentPlace = accidentPlace;
	}
	public String getModelNum() {
		return modelNum;
	}
	public void setModelNum(String modelNum) {
		this.modelNum = modelNum;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getUserUnit() {
		return userUnit;
	}
	public void setUserUnit(String userUnit) {
		this.userUnit = userUnit;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public Integer getUseNature() {
		return useNature;
	}
	public void setUseNature(Integer useNature) {
		this.useNature = useNature;
	}
	public Integer getResponsibilityDivide() {
		return responsibilityDivide;
	}
	public void setResponsibilityDivide(Integer responsibilityDivide) {
		this.responsibilityDivide = responsibilityDivide;
	}
	public Integer getMinorWound() {
		return minorWound;
	}
	public void setMinorWound(Integer minorWound) {
		this.minorWound = minorWound;
	}
	public Integer getSeriousInjury() {
		return seriousInjury;
	}
	public void setSeriousInjury(Integer seriousInjury) {
		this.seriousInjury = seriousInjury;
	}
	public Integer getDeath() {
		return death;
	}
	public void setDeath(Integer death) {
		this.death = death;
	}
	public Integer getMyselfLoss() {
		return myselfLoss;
	}
	public void setMyselfLoss(Integer myselfLoss) {
		this.myselfLoss = myselfLoss;
	}
	public Integer getMyselfTreatmentCost() {
		return myselfTreatmentCost;
	}
	public void setMyselfTreatmentCost(Integer myselfTreatmentCost) {
		this.myselfTreatmentCost = myselfTreatmentCost;
	}
	public Integer getThirdPartyLoss() {
		return thirdPartyLoss;
	}
	public void setThirdPartyLoss(Integer thirdPartyLoss) {
		this.thirdPartyLoss = thirdPartyLoss;
	}
	public Integer getThirdPartyTreatmentCost() {
		return thirdPartyTreatmentCost;
	}
	public void setThirdPartyTreatmentCost(Integer thirdPartyTreatmentCost) {
		this.thirdPartyTreatmentCost = thirdPartyTreatmentCost;
	}
	public Integer getReimbursementCost() {
		return reimbursementCost;
	}
	public void setReimbursementCost(Integer reimbursementCost) {
		this.reimbursementCost = reimbursementCost;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getOperNature() {
		return operNature;
	}
	public void setOperNature(Integer operNature) {
		this.operNature = operNature;
	}
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	public String getRemake() {
		return remake;
	}
	public void setRemake(String remake) {
		this.remake = remake;
	}
	public String getAttachmentPath() {
		return attachmentPath;
	}
	public void setAttachmentPath(String attachmentPath) {
		this.attachmentPath = attachmentPath;
	}
	
	
	
}
