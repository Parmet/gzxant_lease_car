package com.gzxant.entity.car.yearly.inspection;

import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.DataEntity;

/**
 * <p>
 * 年检
 * </p>
 *
 * @author Fatal
 * @since 2018-07-30
 */
@TableName("car_yearly_inspection")
public class CarYearlyInspection extends DataEntity<CarYearlyInspection> {

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
	 * 车辆型号
	 */
	@TableField(value ="car_type")
	private String carType;
	/**
	 * 车架号
	 */
	@TableField(value ="frame_number")
	private String frameNumber;
    /**
     * 办理日期
     */
	@TableField("date_handling")
	private String dateHandling;
    /**
     * 年检有效期至
     */
	@TableField("effective_date")
	private String effectiveDate;
    /**
     * 年检办理人
     */
	private String transactor;
    /**
     * 年检单位
     */
	private String unit;
    /**
     * 年检费用
     */
	private BigDecimal cost;
    /**
     * 年检结果 合格：Y不合格：N
     */
	private String result;
    /**
     * 年检记录
     */
	private String record;

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

	public String getDateHandling() {
		return dateHandling;
	}

	public void setDateHandling(String dateHandling) {
		this.dateHandling = dateHandling;
	}

	public String getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getTransactor() {
		return transactor;
	}

	public void setTransactor(String transactor) {
		this.transactor = transactor;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getRecord() {
		return record;
	}

	public void setRecord(String record) {
		this.record = record;
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
		return "CarYearlyInspection{" +
			"carNumber=" + carNumber +
			", belongstoId=" + belongstoId +
			", dateHandling=" + dateHandling +
			", effectiveDate=" + effectiveDate +
			", transactor=" + transactor +
			", unit=" + unit +
			", cost=" + cost +
			", result=" + result +
			", record=" + record +
			"}";
	}
}
