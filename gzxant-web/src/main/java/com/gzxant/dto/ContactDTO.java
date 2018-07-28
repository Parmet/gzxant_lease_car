package com.gzxant.dto;

/**
 * @author: Fatal
 * @date: 2018/7/25 0025 1:39
 */
public class ContactDTO extends EntityDTO {

    private Long id;

    /** 联系人 */
    private String name;

    /** 电话 */
    private String tel;

    /** 身份证号码 */
    private String idNum;

    /** 职务 */
    private String position;

    /** 所属客户公司 */
    private Long companyId;

    /** 邮箱 */
    private String email;

    /** 备注 */
    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
