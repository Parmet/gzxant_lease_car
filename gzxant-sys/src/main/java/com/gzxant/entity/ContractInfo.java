package com.gzxant.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.DataEntity;

@TableName("contractInfo")
public class ContractInfo extends DataEntity<ContractInfo>{

	private static final long serialVersionUID = 1L;

	/**
	 * 公司名
	 */
	@TableField(value ="company_name")
	public String companyName;
	
	/**
	 * 合同编号
	 */
	@TableField(value ="contract_no")
	public String contractNo;
	
	/**
	 * 经办人
	 */
	public String agent;
	
	/**
	 * 合同类型
	 */
	@TableField(value ="contract_type")
	public String contractType;
	
	/**
	 * 商机编号
	 */
	@TableField(value ="business_number")
	public String businessNumber;
	
	/**
	 * 合同状态
	 */
	@TableField(value ="contract_status")
	public String contractStatus;
	
	/**
	 * 客户类型(乙方)
	 */
	@TableField(value ="customer_type_B")
	public String customerTypeB;
	
	/**
	 * 退还押金账号(乙方)
	 */
	@TableField(value ="refunds_account_B")
	public String refundsAccountB;
	
	/**
	 * 客户名称(乙方)
	 */
	@TableField(value ="customer_name_B")
	public String customerNameB;
	
	/**
	 * 退还押金户名(乙方)
	 */
	@TableField(value ="refunds_name_B")
	public String refundsNameB;
	
	/**
	 * 退还押金开户行(乙方)
	 */
	@TableField(value ="refunds_bank_B")
	public String refundsBankB;
	
	/**
	 * 客户联系方式(乙方)
	 */
	@TableField(value ="customer_phone_B")
	public String customerPhoneB;
	
	/**
	 * 客户类型(丙方)
	 */
	@TableField(value ="customer_type_C")
	public String customerTypeC;
	
	/**
	 * 退还押金账号(丙方)
	 */
	@TableField(value ="refunds_account_C")
	public String refundsAccountC;
	
	/**
	 * 客户名称(丙方)
	 */
	@TableField(value ="customer_name_C")
	public String customerNameC;
	
	/**
	 * 退还押金户名(丙方)
	 */
	@TableField(value ="refunds_name_C")
	public String refundsNameC;
	
	/**
	 * 退还押金开户行(丙方)
	 */
	@TableField(value ="refunds_bank_C")
	public String refundsBankC;
	
	/**
	 * 租车押金
	 */
	@TableField(value ="car_rental_deposit")
	public BigDecimal carRentalDeposit;
	
	/**
	 * 收款方账号
	 */
	@TableField(value ="receivable_account")
	public String receivableAccount;
	
	/**
	 * 违章押金
	 */
	@TableField(value ="violation_deposit")
	public BigDecimal violationDeposit;
	
	/**
	 * 收款方户名
	 */
	@TableField(value ="receivable_name")
	public String receivableName;
	
	/**
	 * 合同金额
	 */
	@TableField(value ="contract_amount")
	public BigDecimal contractAmount;
	
	/**
	 * 收款方开户行
	 */
	@TableField(value ="contract_bank")
	public String contractBank;
	
	/**
	 * 租赁开始时间
	 */
	@TableField(value ="lease_beginDate")
	public String leaseBeginDate;
	
	/**
	 * 租赁结束时间
	 */
	@TableField(value ="lease_endDate")
	public String leaseEndDate;
	
	/**
	 * 付款方式
	 */
	@TableField(value ="payment_method")
	public String paymentMethod;
	
	/**
	 * 合同附件
	 */
	public String enclosure;
	
	/**
	 * 车牌号
	 */
	@TableField(value ="car_number")
	public String carNumber;
	
	@Override
	protected Serializable pkVal() {
		return null;
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

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	
}
