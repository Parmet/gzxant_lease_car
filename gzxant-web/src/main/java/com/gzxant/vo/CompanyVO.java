package com.gzxant.vo;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * CompanyVO
 * @author: Fatal
 * @date: 2018/7/23 0023 21:53
 */
public class CompanyVO extends EntityVO {

    private Long id;

    /** 公司名称 */
    @NotNull
    private String name;

    /** 企业编号 */
    private String enterpriseNumber;

    /** 简称 */
    @NotNull
    private String abbreviation;

    /** 公司性质 */
    @NotNull
    private String property;

    /** 公司类别 */
    @NotNull
    private String category;

    /** 公司地址 */
    @NotNull
    private String address;

    /** 注册资金 */
    @NotNull
    private String registeredCapital;

    /** 备注 */
    private String remark;

    /** 注册日期 */
    @NotNull
    private String registeredDate;

    /** 法人代表 */
    @NotNull
    @Length(min = 0, max = 10, message = "法人代表长度必须介于 1 和 10 之间")
    private String legalRepresentative;

    /** 客户状态 */
    @NotNull
    private String status;

    /** 邮箱地址 */
    @NotNull
    private String email;

    /** 营业执照号 */
    @NotNull
    @Length(min = 0, max = 18, message = "营业执照号长度必须介于 1 和 18 之间")
    private String licenseNumber;

    /** 缩略图 */
    private String sAttachmentUrl;

    /** 附件 */
    private String attachmentUrl;

    /** 所属组织 */
    @NotNull
    private String belongsto;

    public String getsAttachmentUrl() {
        return sAttachmentUrl;
    }

    public void setsAttachmentUrl(String sAttachmentUrl) {
        this.sAttachmentUrl = sAttachmentUrl;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnterpriseNumber() {
        return enterpriseNumber;
    }

    public void setEnterpriseNumber(String enterpriseNumber) {
        this.enterpriseNumber = enterpriseNumber;
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

    public String getAddressS() {
        if (address.length() > 10) {
            return address.substring(0, 10) + "...";
        }
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

    public String getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(String registeredDate) {
        this.registeredDate = registeredDate;
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        return attachmentUrl;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
