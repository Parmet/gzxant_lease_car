package com.gzxant.entity.car.insurance;

import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.DataEntity;

/**
 * <p>
 * 车辆保险
 * </p>
 *
 * @author ycxiao
 * @since 2018-07-30
 */
@TableName("car_insurance")
public class CarInsurance extends DataEntity<CarInsurance> {

    private static final long serialVersionUID = 1L;

    /**
     * 车牌号
     */
	@TableField("car_number")
	private String carNumber;
	/**
	 * 车牌号
	 */
	@TableField("car_type")
	private String carType;
    /**
     * 所属组织 引用
     */
	@TableField("belongsto_id")
	private Long belongstoId;
    /**
     * 购买组织引用
     */
	@TableField("organization_id")
	private Long organizationId;
    /**
     * 保单编号
     */
	@TableField("insurance_no")
	private String insuranceNo;
    /**
     * 保单类型 字典
     */
	@TableField("no_type")
	private String noType;
    /**
     * 车辆年限（保险多久）
     */
	@TableField("fixed_years")
	private Integer fixedYears;
    /**
     * 保险公司 引用
     */
	@TableField("company_id")
	private String companyId;
    /**
     * 起效日期
     */
	@TableField("start_date")
	private String startDate;
    /**
     * 失效日期
     */
	@TableField("expiration_date")
	private String expirationDate;
    /**
     * 保险状态 字典 正常 过期
     */
	private String status;
    /**
     * 总保费
     */
	@TableField("cost_total")
	private BigDecimal costTotal;
    /**
     * 经办人
     */
	private String agent;
    /**
     * 保险专员
     */
	private String specialist;
    /**
     * 理赔电话
     */
	@TableField("claim_telephone")
	private String claimTelephone;


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

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public String getInsuranceNo() {
		return insuranceNo;
	}

	public void setInsuranceNo(String insuranceNo) {
		this.insuranceNo = insuranceNo;
	}

	public String getNoType() {
		return noType;
	}

	public void setNoType(String noType) {
		this.noType = noType;
	}

	public Integer getFixedYears() {
		return fixedYears;
	}

	public void setFixedYears(Integer fixedYears) {
		this.fixedYears = fixedYears;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getCostTotal() {
		return costTotal;
	}

	public void setCostTotal(BigDecimal costTotal) {
		this.costTotal = costTotal;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public String getSpecialist() {
		return specialist;
	}

	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}

	public String getClaimTelephone() {
		return claimTelephone;
	}

	public void setClaimTelephone(String claimTelephone) {
		this.claimTelephone = claimTelephone;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "CarInsurance{" +
			"carNumber=" + carNumber +
			", belongstoId=" + belongstoId +
			", organizationId=" + organizationId +
			", insuranceNo=" + insuranceNo +
			", noType=" + noType +
			", fixedYears=" + fixedYears +
			", companyId=" + companyId +
			", startDate=" + startDate +
			", expirationDate=" + expirationDate +
			", status=" + status +
			", costTotal=" + costTotal +
			", agent=" + agent +
			", specialist=" + specialist +
			", claimTelephone=" + claimTelephone +
			", updateId=" + updateId +
			"}";
	}
}
