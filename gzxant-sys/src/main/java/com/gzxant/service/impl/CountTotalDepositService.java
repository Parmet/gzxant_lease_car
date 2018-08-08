package com.gzxant.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.base.service.impl.BaseService;
import com.gzxant.dao.CountTotalDepositDao;
import com.gzxant.entity.ContractInfo;
import com.gzxant.service.ICountTotalDepositService;

@Service
@Transactional(readOnly = false, rollbackFor = Exception.class)
public class CountTotalDepositService extends BaseService<CountTotalDepositDao,ContractInfo> implements ICountTotalDepositService {


	@Override
	public BigDecimal getCarRentalTotalDeposit(Long companyId, String beginDateStr, String endDateStr) {
		if(companyId == null){
			logger.info("当前用户所在公司的id为空，当前操作的用户是admin");
		}
		Map<String,Object> paramsMap = new HashMap<String,Object>();
		paramsMap.put("companyId", companyId);
		paramsMap.put("beginDateStr", beginDateStr);
		paramsMap.put("endDateStr", endDateStr);
		BigDecimal carNumCount = this.baseMapper.getCarRentalTotalDeposit(paramsMap);
		return carNumCount;
	}
	
	@Override
	public BigDecimal getViolationTotalDeposit(Long companyId, String beginDateStr, String endDateStr) {
		if(companyId == null){
			logger.info("当前用户所在公司的id为空，当前操作的用户是admin");
		}
		Map<String,Object> paramsMap = new HashMap<String,Object>();
		paramsMap.put("companyId", companyId);
		paramsMap.put("beginDateStr", beginDateStr);
		paramsMap.put("endDateStr", endDateStr);
		BigDecimal carNumCount = this.baseMapper.getViolationTotalDeposit(paramsMap);
		return carNumCount;
	}

}
