package com.gzxant.entity.customer.info.company.contact;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.BaseEntity;
import com.gzxant.base.entity.DataEntity;
import org.hibernate.validator.constraints.Length;

/**
 * <p>
 * 
 * </p>
 *
 * @author tecty
 * @since 2018-07-05
 * @author Fatal
 * @date 2018-07-24
 */
@TableName("customer_info_company_contact")
public class CustomerInfoCompanyContact extends DataEntity<CustomerInfoCompanyContact> {

    private static final long serialVersionUID = 1L;

    /** 联系人 */
	private String name;

    /** 电话 */
	private String tel;

    /** 身份证号码 */
	@TableField("id_num")
	private String idNum;

    /** 职务 */
	private String position;

	/** 所属客户公司 */
	@TableField(value = "company_id")
	private Long companyId;

    /** 邮箱 */
	private String email;

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

    @Override
    protected Serializable pkVal() {
        return null;
    }
}
