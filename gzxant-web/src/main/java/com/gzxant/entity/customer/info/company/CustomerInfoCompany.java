package com.gzxant.entity.customer.info.company;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.DataEntity;

/**
 * <p>
 * 
 * </p>
 *
 * @author tecty
 * @since 2018-07-05
 * @author Fatal
 * @date 2018-07-23
 */
@TableName("customer_info_company")
public class CustomerInfoCompany extends DataEntity<CustomerInfoCompany> {

    private static final long serialVersionUID = 1L;

    /**
     * 公司名称
     */
	private String name;
	/**
	 * 企业编号
	 */
	@TableField(value = "enterprise_number")
	private String enterpriseNumber;
    /**
     * 简称
     */
	private String abbreviation;
    /**
     * 公司性质
     */
	private String property;
    /**
     * 公司类别
     */
	private String category;
    /**
     * 公司地址
     */
	private String address;
    /**
     * 注册资金
     */
	@TableField("registered_capital")
	private String registeredCapital;
    /**
     * 注册日期
     */
	@TableField("registered_date")
	private Date registeredDate;
	/**
	 * 客户状态
	 */
	private String status;

	/**
     * 法人代表
     */
	@TableField("legal_representative")
	private String legalRepresentative;
    /**
     * 邮箱地址
     */
	private String email;
    /**
     * 营业执照号
     */
	@TableField("license_number")
	private String licenseNumber;

	/**
	 * 缩略图
	 */
	@TableField(value = "s_attachment_url")
	private String sAttachmentUrl;


	/**
     * 附件
     */
    @TableField(value = "attachment_url")
	private String attachmentUrl;

	/** 所属组织 */
	private String belongsto;

	public String getsAttachmentUrl() {
		return sAttachmentUrl;
	}

	public void setsAttachmentUrl(String sAttachmentUrl) {
		this.sAttachmentUrl = sAttachmentUrl;
	}

	public Long getUpdateId() {
		return updateId;
	}

	public void setUpdateId(Long updateId) {
		this.updateId = updateId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRegisteredCapital() {
		return registeredCapital;
	}

	public void setRegisteredCapital(String registeredCapital) {
		this.registeredCapital = registeredCapital;
	}

	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}

	public String getLegalRepresentative() {
		return legalRepresentative;
	}

	public void setLegalRepresentative(String legalRepresentative) {
		this.legalRepresentative = legalRepresentative;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public String getAttachmentUrl() {
		return this.attachmentUrl;
	}

	public void setAttachmentUrl(String attachmentUrl) {
		this.attachmentUrl = attachmentUrl;
	}

	public String getBelongsto() {
		return belongsto;
	}

	public void setBelongsto(String belongsto) {
		this.belongsto = belongsto;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	public String getEnterpriseNumber() {
		return enterpriseNumber;
	}

	public void setEnterpriseNumber(String enterpriseNumber) {
		this.enterpriseNumber = enterpriseNumber;
	}
}
