package com.gzxant.entity.violation.regulations;

import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.DataEntity;

/**
 * <p>
 * 违章
 * </p>
 *
 * @author Fatal
 * @since 2018-07-30
 */
@TableName("violation_regulations")
public class ViolationRegulations extends DataEntity<ViolationRegulations> {

    private static final long serialVersionUID = 1L;

    /**
     * 车牌号
     */
	@TableField("car_number")
	private String carNumber;
    /**
     * 车辆所属 引用
     */
	@TableField("belongsto_id")
	private Long belongstoId;
	/**
	 * 车辆型号
	 */
	@TableField("car_type")
	private String carType;
    /**
     * 扣分
     */
	private Integer deduction;
    /**
     * 罚款
     */
	private BigDecimal fine;
    /**
     * 资产公司
     */
	@TableField("asset_company")
	private Long assetCompany;
    /**
     * 经营公司
     */
	@TableField("business_company")
	private Long businessCompany;
    /**
     * 客户
     */
	private String customer;
    /**
     * 违章时间
     */
	@TableField("violation_date")
	private String violationDate;
    /**
     * 违章地点
     */
	@TableField("violation_place")
	private String violationPlace;
    /**
     * 违章原因
     */
	@TableField("violation_reason")
	private String violationReason;
    /**
     * 违章采集机关
     */
	@TableField("collection_office")
	private String collectionOffice;
    /**
     * 是否可以代表 Y可以 N不可以
     */
	@TableField("is_representative")
	private String isRepresentative;
    /**
     * 违章代码
     */
	@TableField("violation_code")
	private String violationCode;
    /**
     * 违章项文书编号
     */
	@TableField("book_number")
	private String bookNumber;
    /**
     * 状态 字典 未处理 已处理 处理中
     */
	private String status;
    /**
     * 数据查询时间
     */
	@TableField("data_query_date")
	private String dataQueryDate;
    /**
     * 更新为已处理时间
     */
	@TableField("finish_date")
	private String finishDate;
    /**
     * 修改者id
     */
	@TableField("update_id")
	private Long updateId;

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public Long getBelongstoId() {
		return belongstoId;
	}

	public void setBelongstoId(Long belongstoId) {
		this.belongstoId = belongstoId;
	}

	public Integer getDeduction() {
		return deduction;
	}

	public void setDeduction(Integer deduction) {
		this.deduction = deduction;
	}

	public BigDecimal getFine() {
		return fine;
	}

	public void setFine(BigDecimal fine) {
		this.fine = fine;
	}

	public Long getAssetCompany() {
		return assetCompany;
	}

	public void setAssetCompany(Long assetCompany) {
		this.assetCompany = assetCompany;
	}

	public Long getBusinessCompany() {
		return businessCompany;
	}

	public void setBusinessCompany(Long businessCompany) {
		this.businessCompany = businessCompany;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getViolationDate() {
		return violationDate;
	}

	public void setViolationDate(String violationDate) {
		this.violationDate = violationDate;
	}

	public String getViolationPlace() {
		return violationPlace;
	}

	public void setViolationPlace(String violationPlace) {
		this.violationPlace = violationPlace;
	}

	public String getViolationReason() {
		return violationReason;
	}

	public void setViolationReason(String violationReason) {
		this.violationReason = violationReason;
	}

	public String getCollectionOffice() {
		return collectionOffice;
	}

	public void setCollectionOffice(String collectionOffice) {
		this.collectionOffice = collectionOffice;
	}

	public String getIsRepresentative() {
		return isRepresentative;
	}

	public void setIsRepresentative(String isRepresentative) {
		this.isRepresentative = isRepresentative;
	}

	public String getViolationCode() {
		return violationCode;
	}

	public void setViolationCode(String violationCode) {
		this.violationCode = violationCode;
	}

	public String getBookNumber() {
		return bookNumber;
	}

	public void setBookNumber(String bookNumber) {
		this.bookNumber = bookNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDataQueryDate() {
		return dataQueryDate;
	}

	public void setDataQueryDate(String dataQueryDate) {
		this.dataQueryDate = dataQueryDate;
	}

	public String getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(String finishDate) {
		this.finishDate = finishDate;
	}

	public Long getUpdateId() {
		return updateId;
	}

	public void setUpdateId(Long updateId) {
		this.updateId = updateId;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "ViolationRegulations{" +
			"carNumber=" + carNumber +
			", belongstoId=" + belongstoId +
			", deduction=" + deduction +
			", fine=" + fine +
			", assetCompany=" + assetCompany +
			", businessCompany=" + businessCompany +
			", customer=" + customer +
			", violationDate=" + violationDate +
			", violationPlace=" + violationPlace +
			", violationReason=" + violationReason +
			", collectionOffice=" + collectionOffice +
			", isRepresentative=" + isRepresentative +
			", violationCode=" + violationCode +
			", bookNumber=" + bookNumber +
			", status=" + status +
			", dataQueryDate=" + dataQueryDate +
			", finishDate=" + finishDate +
			", updateId=" + updateId +
			"}";
	}
}
