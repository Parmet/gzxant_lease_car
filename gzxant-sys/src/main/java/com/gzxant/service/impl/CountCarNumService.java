package com.gzxant.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.base.service.impl.BaseService;
import com.gzxant.dao.CountCarNumDao;
import com.gzxant.entity.Car;
import com.gzxant.service.ICountCarNumService;

@Service
@Transactional(readOnly = false, rollbackFor = Exception.class)
public class CountCarNumService extends BaseService<CountCarNumDao,Car> implements ICountCarNumService {

	
	@Override
	public Integer getCarNumCount(Long companyId,String beginDateStr,String endDateStr) {
		if(companyId == null){
			logger.info("当前用户所在公司的id为空，当前操作的用户是admin");
		}
		Integer carNumCount = 0;
		Map<String,Object> paramsMap = new HashMap<String,Object>();
		paramsMap.put("companyId", companyId);
		paramsMap.put("beginDateStr", beginDateStr);
		paramsMap.put("endDateStr", endDateStr);
		carNumCount = this.baseMapper.getCarNumCount(paramsMap);
		return carNumCount;
	}

}
