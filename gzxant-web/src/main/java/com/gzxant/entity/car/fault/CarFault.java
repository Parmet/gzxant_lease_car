package com.gzxant.entity.car.fault;

import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.DataEntity;

/**
 * <p>
 * 故障
 * </p>
 *
 * @author ycxiao
 * @since 2018-07-30
 */
@TableName("car_fault")
public class CarFault extends DataEntity<CarFault> {

    private static final long serialVersionUID = 1L;

    /**
     * 车辆类型
     */
	@TableField("car_type")
	private String carType;
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
     * 故障时间
     */
	private Date time;
    /**
     * 故障地点
     */
	private String place;
    /**
     * 故障责任人
     */
	@TableField("person_liable")
	private String personLiable;
    /**
     * 故障详情
     */
	private String etails;
    /**
     * 故障时里程（km）
     */
	@TableField("mileage_time_failure")
	private BigDecimal mileageTimeFailure;
    /**
     * 登记人
     */
	private String registrant;
    /**
     * 登记时间
     */
	@TableField("register_date")
	private Date registerDate;
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

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getPersonLiable() {
		return personLiable;
	}

	public void setPersonLiable(String personLiable) {
		this.personLiable = personLiable;
	}

	public String getEtails() {
		return etails;
	}

	public void setEtails(String etails) {
		this.etails = etails;
	}

	public BigDecimal getMileageTimeFailure() {
		return mileageTimeFailure;
	}

	public void setMileageTimeFailure(BigDecimal mileageTimeFailure) {
		this.mileageTimeFailure = mileageTimeFailure;
	}

	public String getRegistrant() {
		return registrant;
	}

	public void setRegistrant(String registrant) {
		this.registrant = registrant;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
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
		return "CarFault{" +
			"carType=" + carType +
			", carNumber=" + carNumber +
			", belongstoId=" + belongstoId +
			", time=" + time +
			", place=" + place +
			", personLiable=" + personLiable +
			", etails=" + etails +
			", mileageTimeFailure=" + mileageTimeFailure +
			", registrant=" + registrant +
			", registerDate=" + registerDate +
			", updateId=" + updateId +
			"}";
	}
}
