package com.gzxant.dao;

import java.math.BigDecimal;
import java.util.Map;

import com.gzxant.base.dao.CrudDao;
import com.gzxant.entity.ContractInfo;

public interface CountTotalDepositDao extends CrudDao<ContractInfo> {
	
	
	/**
	 * 计算租车总押金
	 * @return
	 */
	BigDecimal getCarRentalTotalDeposit(Map<String,Object> paramsMap);
	
	/**
	 * 计算违章总押金
	 * @return
	 */
	BigDecimal getViolationTotalDeposit(Map<String,Object> paramsMap);
	
}
