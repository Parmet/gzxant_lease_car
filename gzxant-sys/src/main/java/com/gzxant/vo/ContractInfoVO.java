package com.gzxant.vo;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotations.TableField;

/**
 * 创建合同对象和合同车辆信息对象接口的临时对象
 * @author ZCRong
 *
 */
public class ContractInfoVO {

	/**
	 * 合同附件名称
	 */
	public String enclosureName;
	
	/**
	 * 合同对象的Id
	 */
	public Long contractInfoId;
	
	/**
	 * 合同车辆对象的Id
	 */
	public Long contractCarInfoId;
	
	/**
	 * 公司名
	 */
	public String companyName;
	
	/**
	 * 合同编号
	 */
	public String contractNo;
	
	/**
	 * 经办人
	 */
	public String agent;
	
	/**
	 * 合同类型
	 */
	public String contractType;
	
	/**
	 * 商机编号
	 */
	public String businessNumber;
	
	/**
	 * 合同状态
	 */
	public String contractStatus;
	
	/**
	 * 客户类型(乙方)
	 */
	public String customerTypeB;
	
	/**
	 * 退还押金账号(乙方)
	 */
	public String refundsAccountB;
	
	/**
	 * 客户名称(乙方)
	 */
	public String customerNameB;
	
	/**
	 * 退还押金户名(乙方)
	 */
	public String refundsNameB;
	
	/**
	 * 退还押金开户行(乙方)
	 */
	public String refundsBankB;
	
	/**
	 * 客户联系方式(乙方)
	 */
	public String customerPhoneB;
	
	/**
	 * 客户类型(丙方)
	 */
	public String customerTypeC;
	
	/**
	 * 退还押金账号(丙方)
	 */
	public String refundsAccountC;
	
	/**
	 * 客户名称(丙方)
	 */
	public String customerNameC;
	
	/**
	 * 退还押金户名(丙方)
	 */
	public String refundsNameC;
	
	/**
	 * 退还押金开户行(丙方)
	 */
	public String refundsBankC;
	
	/**
	 * 租车押金
	 */
	public BigDecimal carRentalDeposit;
	
	/**
	 * 收款方账号
	 */
	public String receivableAccount;
	
	/**
	 * 违章押金
	 */
	public BigDecimal violationDeposit;
	
	/**
	 * 收款方户名
	 */
	public String receivableName;
	
	/**
	 * 合同金额
	 */
	public BigDecimal contractAmount;
	
	/**
	 * 收款方开户行
	 */
	public String contractBank;
	
	/**
	 * 租赁开始时间
	 */
	public String leaseBeginDate;
	
	/**
	 * 租赁结束时间
	 */
	public String leaseEndDate;
	
	/**
	 * 付款方式
	 */
	public String paymentMethod;
	
	/**
	 * 合同附件
	 */
	public String enclosure;
	
	/**
	 * 车牌号
	 */
	public String carNumber;
	
	/**
	 * 车辆型号
	 */
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
	private BigDecimal totalPrice;
	
	/**
	 * 备注1
	 */
	@TableField(value ="remark1")
	private String remark1;
	
	/**
	 * 合同表ID
	 */
	private String contractId;


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

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	public String getBusinessNumber() {
		return businessNumber;
	}

	public void setBusinessNumber(String businessNumber) {
		this.businessNumber = businessNumber;
	}

	public String getContractStatus() {
		return contractStatus;
	}

	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
	}

	public String getCustomerTypeB() {
		return customerTypeB;
	}

	public void setCustomerTypeB(String customerTypeB) {
		this.customerTypeB = customerTypeB;
	}

	public String getRefundsAccountB() {
		return refundsAccountB;
	}

	public void setRefundsAccountB(String refundsAccountB) {
		this.refundsAccountB = refundsAccountB;
	}

	public String getCustomerNameB() {
		return customerNameB;
	}

	public void setCustomerNameB(String customerNameB) {
		this.customerNameB = customerNameB;
	}

	public String getRefundsNameB() {
		return refundsNameB;
	}

	public void setRefundsNameB(String refundsNameB) {
		this.refundsNameB = refundsNameB;
	}

	public String getRefundsBankB() {
		return refundsBankB;
	}

	public void setRefundsBankB(String refundsBankB) {
		this.refundsBankB = refundsBankB;
	}

	public String getCustomerPhoneB() {
		return customerPhoneB;
	}

	public void setCustomerPhoneB(String customerPhoneB) {
		this.customerPhoneB = customerPhoneB;
	}

	public String getCustomerTypeC() {
		return customerTypeC;
	}

	public void setCustomerTypeC(String customerTypeC) {
		this.customerTypeC = customerTypeC;
	}

	public String getRefundsAccountC() {
		return refundsAccountC;
	}

	public void setRefundsAccountC(String refundsAccountC) {
		this.refundsAccountC = refundsAccountC;
	}

	public String getCustomerNameC() {
		return customerNameC;
	}

	public void setCustomerNameC(String customerNameC) {
		this.customerNameC = customerNameC;
	}

	public String getRefundsNameC() {
		return refundsNameC;
	}

	public void setRefundsNameC(String refundsNameC) {
		this.refundsNameC = refundsNameC;
	}

	public String getRefundsBankC() {
		return refundsBankC;
	}

	public void setRefundsBankC(String refundsBankC) {
		this.refundsBankC = refundsBankC;
	}

	public BigDecimal getCarRentalDeposit() {
		return carRentalDeposit;
	}

	public void setCarRentalDeposit(BigDecimal carRentalDeposit) {
		this.carRentalDeposit = carRentalDeposit;
	}

	public String getReceivableAccount() {
		return receivableAccount;
	}

	public void setReceivableAccount(String receivableAccount) {
		this.receivableAccount = receivableAccount;
	}

	public BigDecimal getViolationDeposit() {
		return violationDeposit;
	}

	public void setViolationDeposit(BigDecimal violationDeposit) {
		this.violationDeposit = violationDeposit;
	}

	public String getReceivableName() {
		return receivableName;
	}

	public void setReceivableName(String receivableName) {
		this.receivableName = receivableName;
	}

	public BigDecimal getContractAmount() {
		return contractAmount;
	}

	public void setContractAmount(BigDecimal contractAmount) {
		this.contractAmount = contractAmount;
	}

	public String getContractBank() {
		return contractBank;
	}

	public void setContractBank(String contractBank) {
		this.contractBank = contractBank;
	}

	public String getLeaseBeginDate() {
		return leaseBeginDate;
	}

	public void setLeaseBeginDate(String leaseBeginDate) {
		this.leaseBeginDate = leaseBeginDate;
	}

	public String getLeaseEndDate() {
		return leaseEndDate;
	}

	public void setLeaseEndDate(String leaseEndDate) {
		this.leaseEndDate = leaseEndDate;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getEnclosure() {
		return enclosure;
	}

	public void setEnclosure(String enclosure) {
		this.enclosure = enclosure;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public Long getContractInfoId() {
		return contractInfoId;
	}

	public void setContractInfoId(Long contractInfoId) {
		this.contractInfoId = contractInfoId;
	}

	public Long getContractCarInfoId() {
		return contractCarInfoId;
	}

	public void setContractCarInfoId(Long contractCarInfoId) {
		this.contractCarInfoId = contractCarInfoId;
	}

	public String getEnclosureName() {
		return enclosureName;
	}

	public void setEnclosureName(String enclosureName) {
		this.enclosureName = enclosureName;
	}
	
	
	
}
