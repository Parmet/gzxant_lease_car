package com.gzxant.entity;

import java.io.Serializable;
import java.sql.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.CarEntity;

@TableName("car")
public class Car extends CarEntity<Car>{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 车牌号码 
	 */
	@TableField(value ="car_number")
	private String carNumber;
	
	/**
	 * 车辆类型
	 */
	@TableField(value ="vehicle_type")
	private String vehicleType;
	
	/**
	 * 租赁类型
	 */
	@TableField(value ="lease_type")
	private String leaseType;
	
	/**
	 * 资产状态
	 */
	@TableField(value ="assets_state")
	private String assetsState;
	
	/**
	 * 使用组织
	 */
	@TableField(value ="used_organization")
	private String usedOrganization;
	
	/**
	 * 所在车区
	 */
	@TableField(value ="where_car_area")
	private String whereCarArea;
	
	/**
	 * 购买日期
	 */
	@TableField(value ="buy_date")
	private Date buyDate;
	
	/**
	 * 资产编号
	 */
	@TableField(value ="assets_number")
	private String assetsNumber;
	
	/**
	 * 资产所属
	 */
	@TableField(value ="assets_belong")
	private String assetsBelong;
	
	/**
	 * 邮箱地址
	 */	
	private String email;
	
	/**
	 * 客户状态
	 */
	@TableField(value ="customer_state")
	private String customerState;
	
	/**
	 * 车架号
	 */
	@TableField(value ="frame_number")
	private String frameNumber;
	
	/**
	 * 发动机号
	 */
	@TableField(value ="engine_number")
	private String engine_number;
	
	/**
	 * 机电编号
	 */
	@TableField(value ="e_m_number")
	private String EMNumber;
	
	/**
	 * 颜色
	 */
	private String color;
	
	/**
	 * 出厂日期
	 */
	@TableField(value ="production_date")
	private Date productionDate;
	
	/**
	 * 年审日期
	 */
	@TableField(value ="annual_trial_date")
	private Date annualTrialDate;
	
	/**
	 * 首付
	 */
	@TableField(value ="down_payments")
	private Integer downPayments;
	
	/**
	 * 押金
	 */
	private Integer deposit;
	
	/**
	 * 期数
	 */
	@TableField(value ="periods_number")
	private Integer periodsNumber;
	
	/**
	 * 总额
	 */
	private Integer total;

	/**
	 * 登记号码
	 */
	@TableField(value ="registration_number")
	private String registrationNumber;
	
	/**
	 * 登记证登记日期
	 */
	@TableField(value ="registration_date")
	private Date registrationDeta;
	
	/**
	 * 登记证发证日期
	 */
	@TableField(value ="registration_certificate_date")
	private Date registrationCertificateDate;
	
	/**
	 * 上牌日期
	 */
	@TableField(value ="on_cards_date")
	private Date onCardsDate;
	
	/**
	 * 行驶注册日期
	 */
	@TableField(value ="d_l_r_date")
	private Date dLRDate;
	
	/**
	 * 行驶注册日期
	 */
	@TableField(value ="d_l_c_date")
	private Date dLCDate;
	
	/**
	 * 发票号
	 */
	@TableField(value ="invoice_number")
	private String invoiceNumber;
	
	/**
	 * 发票日期
	 */
	@TableField(value ="invoice_date")
	private Date invoiceDate;
	
	/**
	 * 证件类型
	 */
	@TableField(value ="document_type")
	private String documentType;
	
	/**
	 * 附件
	 */
	private String enclosure;
	
	
	
	public String getCarNumber() {
		return carNumber;
	}



	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}



	public String getVehicleType() {
		return vehicleType;
	}



	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}



	public String getLeaseType() {
		return leaseType;
	}



	public void setLeaseType(String leaseType) {
		this.leaseType = leaseType;
	}



	public String getAssetsState() {
		return assetsState;
	}



	public void setAssetsState(String assetsState) {
		this.assetsState = assetsState;
	}



	public String getUsedOrganization() {
		return usedOrganization;
	}



	public void setUsedOrganization(String usedOrganization) {
		this.usedOrganization = usedOrganization;
	}



	public String getWhereCarArea() {
		return whereCarArea;
	}



	public void setWhereCarArea(String whereCarArea) {
		this.whereCarArea = whereCarArea;
	}



	public Date getBuyDate() {
		return buyDate;
	}



	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}



	public String getAssetsNumber() {
		return assetsNumber;
	}



	public void setAssetsNumber(String assetsNumber) {
		this.assetsNumber = assetsNumber;
	}



	public String getAssetsBelong() {
		return assetsBelong;
	}



	public void setAssetsBelong(String assetsBelong) {
		this.assetsBelong = assetsBelong;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getCustomerState() {
		return customerState;
	}



	public void setCustomerState(String customerState) {
		this.customerState = customerState;
	}



	public String getFrameNumber() {
		return frameNumber;
	}



	public void setFrameNumber(String frameNumber) {
		this.frameNumber = frameNumber;
	}



	public String getEngine_number() {
		return engine_number;
	}



	public void setEngine_number(String engine_number) {
		this.engine_number = engine_number;
	}



	public String getEMNumber() {
		return EMNumber;
	}



	public void setEMNumber(String eMNumber) {
		EMNumber = eMNumber;
	}



	public String getColor() {
		return color;
	}



	public void setColor(String color) {
		this.color = color;
	}



	public Date getProductionDate() {
		return productionDate;
	}



	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}



	public Date getAnnualTrialDate() {
		return annualTrialDate;
	}



	public void setAnnualTrialDate(Date annualTrialDate) {
		this.annualTrialDate = annualTrialDate;
	}



	public Integer getDownPayments() {
		return downPayments;
	}



	public void setDownPayments(Integer downPayments) {
		this.downPayments = downPayments;
	}



	public Integer getDeposit() {
		return deposit;
	}



	public void setDeposit(Integer deposit) {
		this.deposit = deposit;
	}



	public Integer getPeriodsNumber() {
		return periodsNumber;
	}



	public void setPeriodsNumber(Integer periodsNumber) {
		this.periodsNumber = periodsNumber;
	}



	public Integer getTotal() {
		return total;
	}



	public void setTotal(Integer total) {
		this.total = total;
	}



	public String getRegistrationNumber() {
		return registrationNumber;
	}



	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}



	public Date getRegistrationDeta() {
		return registrationDeta;
	}



	public void setRegistrationDeta(Date registrationDeta) {
		this.registrationDeta = registrationDeta;
	}



	public Date getRegistrationCertificateDate() {
		return registrationCertificateDate;
	}



	public void setRegistrationCertificateDate(Date registrationCertificateDate) {
		this.registrationCertificateDate = registrationCertificateDate;
	}



	public Date getOnCardsDate() {
		return onCardsDate;
	}



	public void setOnCardsDate(Date onCardsDate) {
		this.onCardsDate = onCardsDate;
	}



	public Date getdLRDate() {
		return dLRDate;
	}



	public void setdLRDate(Date dLRDate) {
		this.dLRDate = dLRDate;
	}



	public Date getdLCDate() {
		return dLCDate;
	}



	public void setdLCDate(Date dLCDate) {
		this.dLCDate = dLCDate;
	}



	public String getInvoiceNumber() {
		return invoiceNumber;
	}



	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}



	public Date getInvoiceDate() {
		return invoiceDate;
	}



	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}



	public String getDocumentType() {
		return documentType;
	}



	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}



	public String getEnclosure() {
		return enclosure;
	}



	public void setEnclosure(String enclosure) {
		this.enclosure = enclosure;
	}



	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
