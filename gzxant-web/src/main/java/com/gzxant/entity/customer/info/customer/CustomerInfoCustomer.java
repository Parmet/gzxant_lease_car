package com.gzxant.entity.customer.info.customer;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gzxant.constant.Global;
import org.hibernate.validator.constraints.Length;

/**
 * <p>
 * CustomerDTO's information
 * </p>
 *
 * @author tecty
 * @since 2018-07-05
 * @author Fatal
 * @date 218-07-21
 */
@TableName("customer_info_customer")
//public class CustomerInfoCustomer extends DataEntity<CustomerInfoCustomer> {
public class CustomerInfoCustomer extends Model<CustomerInfoCustomer> {

    private static final long serialVersionUID = 1L;

    public CustomerInfoCustomer() {
    	super();
		this.delFlag = Global.DEL_FLAG_NORMAL;
	}

    @TableId(value = "ID", type = IdType.UUID)
    private String id;

	/** 创建者 */
	@TableField(value = "create_id", fill = FieldFill.INSERT)
	protected Long createId;

	/** 创建日期 */
	@TableField(value = "create_date", fill = FieldFill.INSERT)
	protected Date createDate;

	/** 更新者 */
	@TableField(value = "update_id", fill = FieldFill.INSERT_UPDATE)
	protected Long updateId;

	/** 更新日期 */
	@TableField(value = "update_date", fill = FieldFill.INSERT_UPDATE)
	protected Date updateDate;

	/** 删除标记（Y：正常；N：删除；A：审核；） */
	@TableField(value = "del_flag")
	protected String delFlag;

	/** 备注 */
	protected String remark;

	/** Name of the customer */
	private String name;

    /** Gender of the customer */
	private String gender;

    /** Telephone of the customer. */
	private String tel;

    /** Whether this customer is blocked. */
	private String status;

    /** Address of the customer. */
	private String address;

    /** What's premitted to drive for this customer. */
	@TableField("drive_capability")
	private String driveCapability;

    /** Email address of the customer. */
	private String email;

    /** Name of emergency contact. */
	@TableField("emergency_contact")
	private String emergencyContact;

    /** contact of the emergency contact. */
	@TableField("emergency_contact_tel")
	private String emergencyContactTel;

	/** Relationship between customer and the emergency contact. */
	@TableField("emergency_contact_relationship")
	private String emergencyContactRelationship;

	/** 身份证号码 */
	@TableField(value = "identity_card")
	private String identityNumber;

	/** 驾驶证号码 */
	@TableField(value = "drive_card")
	private String driveNumber;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDriveCapability() {
		return driveCapability;
	}

	public void setDriveCapability(String driveCapability) {
		this.driveCapability = driveCapability;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmergencyContact() {
		return emergencyContact;
	}

	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}

	public String getEmergencyContactTel() {
		return emergencyContactTel;
	}

	public void setEmergencyContactTel(String emergencyContactTel) {
		this.emergencyContactTel = emergencyContactTel;
	}

	public String getEmergencyContactRelationship() {
		return emergencyContactRelationship;
	}

	public void setEmergencyContactRelationship(String emergencyContactRelationship) {
		this.emergencyContactRelationship = emergencyContactRelationship;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	public String getIdentityNumber() {
		return identityNumber;
	}

	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}

	public String getDriveNumber() {
		return driveNumber;
	}

	public void setDriveNumber(String driveNumber) {
		this.driveNumber = driveNumber;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getCreateId() {
		return createId;
	}

	public void setCreateId(Long createId) {
		this.createId = createId;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getUpdateId() {
		return updateId;
	}

	public void setUpdateId(Long updateId) {
		this.updateId = updateId;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@JsonIgnore
	@Length(min = 1, max = 1)
	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	@Length(min = 0, max = 500, message = "备注信息长度必须介于 1 和 500 之间")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "CustomerInfoCustomer{" +
			", name=" + name +
			", gender=" + gender +
			", tel=" + tel +
			", status=" + status +
			", address=" + address +
			", driveCapability=" + driveCapability +
			", email=" + email +
			", emergencyContact=" + emergencyContact +
			", emergencyContactTel=" + emergencyContactTel +
			", emergencyContactRelationship=" + emergencyContactRelationship +
			"}";
	}
}
