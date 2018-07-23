package com.gzxant.entity.customer.info.certificate;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.gzxant.base.entity.DataEntity;

/**
 * <p>
 * Certificate table
 * </p>
 *
 * @author tecty
 * @since 2018-07-05
 */
@TableName("customer_info_certificate")
public class CustomerInfoCertificate extends DataEntity<CustomerInfoCertificate> {

    private static final long serialVersionUID = 1L;

    /**
     * Type of this certificate
     */
	private String type;
    /**
     * Id of provided certificate
     */
	private String number;
    /**
     * The issue day of the attachment.
     */
	@TableField("issue_date")
	private Date issueDate;
    /**
     * Until when this certificate will still be valid
     */
	@TableField("validity_period")
	private Date validityPeriod;

	@TableField(value = "s_attachment_url", fill = FieldFill.INSERT_UPDATE)
	private String sAttachmentUrl;

    /**
     * The upload attachment's url
     */
	@TableField(value = "attachment_url", fill = FieldFill.INSERT_UPDATE)
	private String attachmentUrl;

	/** 客户 */
	@TableField(value = "customer_id", fill = FieldFill.INSERT_UPDATE)
	private String customerId;


	public Long getUpdateId() {
		return updateId;
	}

	public void setUpdateId(Long updateId) {
		this.updateId = updateId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getValidityPeriod() {
		return validityPeriod;
	}


	public void setValidityPeriod(Date validityPeriod) {
		this.validityPeriod = validityPeriod;
	}


	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	public String getAttachmentUrl() {
		return attachmentUrl;
	}

	public void setAttachmentUrl(String attachmentUrl) {
		this.attachmentUrl = attachmentUrl;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getsAttachmentUrl() {
		return sAttachmentUrl;
	}

	public void setsAttachmentUrl(String sAttachmentUrl) {
		this.sAttachmentUrl = sAttachmentUrl;
	}

	@Override
	public String toString() {
		return "CustomerInfoCertificate{" +
				"type='" + type + '\'' +
				", number='" + number + '\'' +
				", issueDate=" + issueDate +
				", validityPeriod=" + validityPeriod +
				", attachmentUrl='" + attachmentUrl + '\'' +
				", customerId='" + customerId + '\'' +
				'}';
	}
}
