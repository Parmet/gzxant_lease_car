package com.gzxant.vo;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author: Fatal
 * @date: 2018/7/21 0021 13:44
 */
public class CustomerVO {

    private String id;

    /** 姓名 */
    @NotNull(message = "姓名不能为空")
    private String name;

    /** 性别 */
    @NotNull(message = "姓别不能为空")
    private String gender;

    /** 联系方式 */
    @Length(min = 0, max = 200, message = "手机长度必须介于 1 和 20 之间")
    private String tel;

    /** 客户状态 */
    @NotNull(message = "客户状态不能为空")
    private String status;

    /** 地址 */
    @NotNull(message = "地址不能为空")
    private String address;

    /** 准驾车型 */
    @NotNull(message = "准驾车型不能为空")
    private String driveCapability;

    /** 邮箱 */
    @Email(message = "邮箱格式不正确")
    @Length(min = 0, max = 200, message = "邮箱长度必须介于 1 和 100 之间")
    private String email;

    /** 紧急联系人 */
    @NotNull(message = "紧急联系人不能为空")
    private String emergencyContact;

    /** 紧急联系人电话 */
    @NotNull(message = "紧急联系人电话不能为空")
    private String emergencyContactTel;

    /** 可供选择，如父子、亲戚等 可自定义 */
    @NotNull(message = "与客户关系不能为空")
    private String emergencyContactRelationship;

    /** 备注 */
    private String remark;

    /** 身份证图片 */
    @NotNull(message = "身份证图片不能为空")
    private String identityImageUrl;

    /** 身份证缩略图 */
    @NotNull(message = "身份证缩略图不能为空")
    private String sIdentityImageUrl;

    /** 身份证号码 */
    @NotNull(message = "身份证号码不能为空")
    private String identityNumber;

    /** 身份证发证日期 */
    @NotNull(message = "身份证发证日期不能为空")
    private String iIssueDate;

    /** 身份证有效期至 */
    @NotNull(message = "身份证有效期至不能为空")
    private String iValidityPeriod;

    /** 驾驶证图片 */
    @NotNull(message = "驾驶证图片不能为空")
    private String driveImageUrl;

    /** 驾驶证缩略图 */
    @NotNull(message = "驾驶证号码不能为空")
    private String sDriveImageUrl;

    /** 驾驶证号码 */
    @NotNull(message = "驾驶证号码不能为空")
    private String driveNumber;

    /** 驾驶证发证日期 */
    @NotNull(message = "驾驶证发证日期不能为空")
    private String dIssueDate;

    /** 驾驶证有效期至 */
    @NotNull(message = "驾驶证有效期至不能为空")
    private String dValidityPeriod;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getIdentityImageUrl() {
        return identityImageUrl;
    }

    public void setIdentityImageUrl(String identityImageUrl) {
        this.identityImageUrl = identityImageUrl;
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

    public String getsIdentityImageUrl() {
        return sIdentityImageUrl;
    }

    public void setsIdentityImageUrl(String sIdentityImageUrl) {
        this.sIdentityImageUrl = sIdentityImageUrl;
    }

    public String getDriveImageUrl() {
        return driveImageUrl;
    }

    public void setDriveImageUrl(String driveImageUrl) {
        this.driveImageUrl = driveImageUrl;
    }

    public String getsDriveImageUrl() {
        return sDriveImageUrl;
    }

    public void setsDriveImageUrl(String sDriveImageUrl) {
        this.sDriveImageUrl = sDriveImageUrl;
    }

    public String getiIssueDate() {
        return iIssueDate;
    }

    public void setiIssueDate(String iIssueDate) {
        this.iIssueDate = iIssueDate;
    }

    public String getiValidityPeriod() {
        return iValidityPeriod;
    }

    public void setiValidityPeriod(String iValidityPeriod) {
        this.iValidityPeriod = iValidityPeriod;
    }

    public String getdIssueDate() {
        return dIssueDate;
    }

    public void setdIssueDate(String dIssueDate) {
        this.dIssueDate = dIssueDate;
    }

    public String getdValidityPeriod() {
        return dValidityPeriod;
    }

    public void setdValidityPeriod(String dValidityPeriod) {
        this.dValidityPeriod = dValidityPeriod;
    }
}
