package com.gzxant.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.DataEntity;

/**
 * 合同车辆信息对象
 * @author hxdn
 *
 */
@TableName("contract_car_info")
public class ContractCarInfo extends DataEntity<ContractCarInfo>{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 车辆型号
	 */
	@TableField(value ="vehicle_type")
	private String vehicleType;
	
	/**
	 * 数量
	 */
	private String number;
	
	/**
	 * 单价
	 */
	private BigDecimal price;
	
	/**
	 * 合计
	 */
	@TableField(value ="total_price")
	private BigDecimal totalPrice;
	
	/**
	 * 备注1
	 */
	@TableField(value ="remark1")
	private String remark1;
	
	/**
	 * 合同表ID
	 */
	@TableField(value ="contract_id")
	private Long contractId;

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getRemark1() {
		return remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public Long getcontractId() {
		return contractId;
	}

	public void setcontractId(Long contractId) {
		this.contractId = contractId;
	}

	@Override
	protected Serializable pkVal() {
		return null;
	}
	
}
