package com.gzxant.entity.car.accident;

import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.DataEntity;

/**
 * <p>
 * 事故
 * </p>
 *
 * @author ycxiao
 * @since 2018-07-29
 */
@TableName("car_accident")
public class CarAccident extends DataEntity<CarAccident> {

    private static final long serialVersionUID = 1L;

    /**
     * 车牌号
     */
	@TableField("car_number")
	private String carNumber;
    /**
     * 车辆所属 引用
     */
	@TableField("belongsto_id")
	private Long belongstoId;
    /**
     * 事故日期
     */
	private String date;
	/**
	 * 车辆型号
	 */
	@TableField("car_type")
	private String carType;
    /**
     * 驾驶员
     */
	private String driver;
    /**
     * 事故地址
     */
	private String place;
    /**
     * 事故详情
     */
	private String detail;
    /**
     * 使用性质 引用
     */
	@TableField("use_property_id")
	private String usePropertyId;
    /**
     * 事故性质 字典 单方事故、双方事故、多方事故
     */
	private String nature;
    /**
     * 责任划分 字典 全责、无责、次责、不详、同等、主责
     */
	private String responsibility;
    /**
     * 轻伤（人）
     */
	@TableField("minor_wound")
	private Integer minorWound;
    /**
     * 重伤（人）
     */
	@TableField("serious_injury")
	private Integer seriousInjury;
    /**
     * 死亡（人）
     */
	private Integer death;
    /**
     * 我方经济损失
     */
	@TableField("our_losses")
	private BigDecimal ourLosses;
    /**
     * 我方医疗费用
     */
	@TableField("our_expenses")
	private BigDecimal ourExpenses;
    /**
     * 三者经济损失
     */
	@TableField("three_losses")
	private BigDecimal threeLosses;
    /**
     * 三者医疗费用
     */
	@TableField("three_expenses")
	private BigDecimal threeExpenses;
    /**
     * 已赔付金额
     */
	@TableField("amount_paid")
	private BigDecimal amountPaid;
    /**
     * 事故等级 字典 轻微事故、一般事故、重大事故、特大事故
     */
	private String grade;
    /**
     * 处理状态 字典 未处理 处理中 已处理
     */
	@TableField("processing_state")
	private String processingState;
    /**
     * 事故处理进度 Y：已结案 N：待定损
     */
	@TableField("handling_progress")
	private String handlingProgress;
    /**
     * 修改者id
     */
	@TableField("update_id")
	private Long updateId;

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
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

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getUsePropertyId() {
		return usePropertyId;
	}

	public void setUsePropertyId(String usePropertyId) {
		this.usePropertyId = usePropertyId;
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public String getResponsibility() {
		return responsibility;
	}

	public void setResponsibility(String responsibility) {
		this.responsibility = responsibility;
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

	public BigDecimal getOurLosses() {
		return ourLosses;
	}

	public void setOurLosses(BigDecimal ourLosses) {
		this.ourLosses = ourLosses;
	}

	public BigDecimal getOurExpenses() {
		return ourExpenses;
	}

	public void setOurExpenses(BigDecimal ourExpenses) {
		this.ourExpenses = ourExpenses;
	}

	public BigDecimal getThreeLosses() {
		return threeLosses;
	}

	public void setThreeLosses(BigDecimal threeLosses) {
		this.threeLosses = threeLosses;
	}

	public BigDecimal getThreeExpenses() {
		return threeExpenses;
	}

	public void setThreeExpenses(BigDecimal threeExpenses) {
		this.threeExpenses = threeExpenses;
	}

	public BigDecimal getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(BigDecimal amountPaid) {
		this.amountPaid = amountPaid;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getProcessingState() {
		return processingState;
	}

	public void setProcessingState(String processingState) {
		this.processingState = processingState;
	}

	public String getHandlingProgress() {
		return handlingProgress;
	}

	public void setHandlingProgress(String handlingProgress) {
		this.handlingProgress = handlingProgress;
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
		return "CarAccident{" +
			"carNumber=" + carNumber +
			", belongstoId=" + belongstoId +
			", date=" + date +
			", driver=" + driver +
			", place=" + place +
			", detail=" + detail +
			", carType=" + carType +
			", usePropertyId=" + usePropertyId +
			", nature=" + nature +
			", responsibility=" + responsibility +
			", minorWound=" + minorWound +
			", seriousInjury=" + seriousInjury +
			", death=" + death +
			", ourLosses=" + ourLosses +
			", ourExpenses=" + ourExpenses +
			", threeLosses=" + threeLosses +
			", threeExpenses=" + threeExpenses +
			", amountPaid=" + amountPaid +
			", grade=" + grade +
			", processingState=" + processingState +
			", handlingProgress=" + handlingProgress +
			", updateId=" + updateId +
			"}";
	}
}
