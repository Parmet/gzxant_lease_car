package com.gzxant.entity.car.maintain;

import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.DataEntity;

/**
 * <p>
 * 车辆保养
 * </p>
 *
 * @author ycxiao
 * @since 2018-07-29
 */
@TableName("car_maintain")
public class CarMaintain extends DataEntity<CarMaintain> {

    private static final long serialVersionUID = 1L;

    /**
     * 车牌号
     */
	@TableField("car_lnumber")
	private String carLnumber;
    /**
     * 车辆型号
     */
	@TableField("car_type")
	private String carType;
    /**
     * 车辆所属 引用
     */
	@TableField("belongsto_id")
	private Long belongstoId;
    /**
     * 保养级别 字典 常规,一级,二级,三级
     */
	@TableField("maintain_level")
	private String maintainLevel;
    /**
     * 保养门店
     */
	@TableField("maintain_store")
	private String maintainStore;
    /**
     * 保养费用
     */
	@TableField("maintain_cost")
	private BigDecimal maintainCost;
    /**
     * 保养日期
     */
	@TableField("maintain_date")
	private String maintainDate;
    /**
     * 保养里程
     */
	@TableField("maintain_mileage")
	private Integer maintainMileage;
    /**
     * 经办人
     */
	private String agent;
    /**
     * 保养单号
     */
	@TableField("maintain_no")
	private String maintainNo;

	public String getCarLnumber() {
		return carLnumber;
	}

	public void setCarLnumber(String carLnumber) {
		this.carLnumber = carLnumber;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public Long getBelongstoId() {
		return belongstoId;
	}

	public void setBelongstoId(Long belongstoId) {
		this.belongstoId = belongstoId;
	}

	public String getMaintainLevel() {
		return maintainLevel;
	}

	public void setMaintainLevel(String maintainLevel) {
		this.maintainLevel = maintainLevel;
	}

	public String getMaintainStore() {
		return maintainStore;
	}

	public void setMaintainStore(String maintainStore) {
		this.maintainStore = maintainStore;
	}

	public BigDecimal getMaintainCost() {
		return maintainCost;
	}

	public void setMaintainCost(BigDecimal maintainCost) {
		this.maintainCost = maintainCost;
	}

	public String getMaintainDate() {
		return maintainDate;
	}

	public void setMaintainDate(String maintainDate) {
		this.maintainDate = maintainDate;
	}

	public Integer getMaintainMileage() {
		return maintainMileage;
	}

	public void setMaintainMileage(Integer maintainMileage) {
		this.maintainMileage = maintainMileage;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public String getMaintainNo() {
		return maintainNo;
	}

	public void setMaintainNo(String maintainNo) {
		this.maintainNo = maintainNo;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "CarMaintain{" +
			"carLnumber=" + carLnumber +
			", carType=" + carType +
			", belongstoId=" + belongstoId +
			", maintainLevel=" + maintainLevel +
			", maintainStore=" + maintainStore +
			", maintainCost=" + maintainCost +
			", maintainDate=" + maintainDate +
			", maintainMileage=" + maintainMileage +
			", agent=" + agent +
			", maintainNo=" + maintainNo +
			"}";
	}
}
