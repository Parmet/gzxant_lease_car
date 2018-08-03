package com.gzxant.dto;

import java.util.Date;

/**
 * Company数据传输对象
 * @author: Fatal
 * @date: 2018/7/23 0023 23:45
 */
public class CompanyDTO extends EntityDTO {

    private Long id;

    /** 公司名称 */
    private String name;

    /** 企业编号 */
    private String enterpriseNumber;

    /** 简称 */
    private String abbreviation;

    /** 公司性质 */
    private String property;

    /** 公司类别 */
    private String category;

    /** 公司地址 */
    private String address;

    /** 注册资金 */
    private String registeredCapital;

    /** 注册日期 */
    private Date registeredDate;

    /** 法人代表 */
    private String legalRepresentative;

    /** 备注 */
    private String remark;

    /** 客户状态 */
    private String status;

    /** 邮箱地址 */
    private String email;

    /** 营业执照号 */
    private String licenseNumber;

    /** 缩略图 */
    private String sAttachmentUrl;

    /** 附件 */
    private String attachmentUrl;

    /** 所属组织 */
    private String belongsto;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getId() {
        return id;
    }

    public String getsAttachmentUrl() {
        return sAttachmentUrl;
    }

    public void setsAttachmentUrl(String sAttachmentUrl) {
        this.sAttachmentUrl = sAttachmentUrl;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
}
