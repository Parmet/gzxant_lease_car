package com.gzxant.entity.car.repair;

import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.DataEntity;

/**
 * <p>
 * 车辆维修
 * </p>
 *
 * @author Fatal
 * @since 2018-07-30
 */
@TableName("car_repair")
public class CarRepair extends DataEntity<CarRepair> {

    private static final long serialVersionUID = 1L;

    /**
     * 车牌号
     */
	@TableField("car_number")
	private String carNumber;
    /**
     * 车辆型号
     */
	@TableField("car_type")
	private String carType;
    /**
     * 车架号
     */
	@TableField("frame_number")
	private String frameNumber;
    /**
     * 车辆所属 引用
     */
	@TableField("belongsto_id")
	private Long belongstoId;
    /**
     * 维修日期
     */
	private String date;
    /**
     * 维修类型 字典 正常维修 事故维修
     */
	private String type;
    /**
     * 维修结果 字典 未完成 已完成
     */
	private String result;
	/**
	 * 维修单号
	 */
	@TableField("repair_shop")
	private String repairShop;
	/**
	 * 维修门店
	 */
	@TableField("repair_no")
	private String repairNo;
    /**
     * 维修时里程（km）
     */
	private Integer mileage;
    /**
     * 总费用（元）
     */
	@TableField("total_cost")
	private BigDecimal totalCost;
    /**
     * 维修配件费（元）
     */
	@TableField("accessories_fee")
	private BigDecimal accessoriesFee;
    /**
     * 维修工时费（元）
     */
	@TableField("time_fee")
	private BigDecimal timeFee;
    /**
     * 维修人
     */
	private String repairman;
    /**
     * 维修项目
     */
	@TableField("repair_project")
	private String repairProject;
    /**
     * 维修结束时间
     */
	@TableField("end_time")
	private String endTime;
    /**
     * 维修跟进人
     */
	@TableField("followup_person")
	private String followupPerson;
    /**
     * 修改者id
     */
	@TableField("update_id")
	private Long updateId;

	public String getRepairShop() {
		return repairShop;
	}

	public void setRepairShop(String repairShop) {
		this.repairShop = repairShop;
	}

	public String getRepairNo() {
		return repairNo;
	}

	public void setRepairNo(String repairNo) {
		this.repairNo = repairNo;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getFrameNumber() {
		return frameNumber;
	}

	public void setFrameNumber(String frameNumber) {
		this.frameNumber = frameNumber;
	}

	public Long getBelongstoId() {
		return belongstoId;
	}

	public void setBelongstoId(Long belongstoId) {
		this.belongstoId = belongstoId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Integer getMileage() {
		return mileage;
	}

	public void setMileage(Integer mileage) {
		this.mileage = mileage;
	}

	public BigDecimal getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}

	public BigDecimal getAccessoriesFee() {
		return accessoriesFee;
	}

	public void setAccessoriesFee(BigDecimal accessoriesFee) {
		this.accessoriesFee = accessoriesFee;
	}

	public BigDecimal getTimeFee() {
		return timeFee;
	}

	public void setTimeFee(BigDecimal timeFee) {
		this.timeFee = timeFee;
	}

	public String getRepairman() {
		return repairman;
	}

	public void setRepairman(String repairman) {
		this.repairman = repairman;
	}

	public String getRepairProject() {
		return repairProject;
	}

	public void setRepairProject(String repairProject) {
		this.repairProject = repairProject;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getFollowupPerson() {
		return followupPerson;
	}

	public void setFollowupPerson(String followupPerson) {
		this.followupPerson = followupPerson;
	}

	public Long getUpdateId() {
		return updateId;
	}

	public void setUpdateId(Long updateId) {
		this.updateId = updateId;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "CarRepair{" +
			"carNumber=" + carNumber +
			", carType=" + carType +
			", frameNumber=" + frameNumber +
			", belongstoId=" + belongstoId +
			", date=" + date +
			", type=" + type +
			", result=" + result +
			", mileage=" + mileage +
			", totalCost=" + totalCost +
			", accessoriesFee=" + accessoriesFee +
			", timeFee=" + timeFee +
			", repairman=" + repairman +
			", repairProject=" + repairProject +
			", endTime=" + endTime +
			", followupPerson=" + followupPerson +
			", updateId=" + updateId +
			"}";
	}
}
