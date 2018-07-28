package com.gzxant.controller.vo;

import java.util.Date;

public class AccidentVo {
	
	private String userUnit;			//所属组织|使用单位
	private String modelNum;			//车型号
	private String plateNum;			//车牌号
	private int grade;					//事故等级
	private int status;					//处理状态
	private Date accidentTimeStart;		//事故日期开始
	private Date accidentTimeEnd;		//事故日期结束
	
	
	public String getUserUnit() {
		return userUnit;
	}
	public void setUserUnit(String userUnit) {
		this.userUnit = userUnit;
	}
	public String getModelNum() {
		return modelNum;
	}
	public void setModelNum(String modelNum) {
		this.modelNum = modelNum;
	}
	public String getPlateNum() {
		return plateNum;
	}
	public void setPlateNum(String plateNum) {
		this.plateNum = plateNum;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getAccidentTimeStart() {
		return accidentTimeStart;
	}
	public void setAccidentTimeStart(Date accidentTimeStart) {
		this.accidentTimeStart = accidentTimeStart;
	}
	public Date getAccidentTimeEnd() {
		return accidentTimeEnd;
	}
	public void setAccidentTimeEnd(Date accidentTimeEnd) {
		this.accidentTimeEnd = accidentTimeEnd;
	}
	
}
