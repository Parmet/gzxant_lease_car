package com.gzxant.dao;

import java.util.Map;

import com.gzxant.base.dao.CrudDao;
import com.gzxant.entity.Car;

public interface CountCarNumDao extends CrudDao<Car> {
	
	/**
	 * 计算车辆的一定时间内所有数量（总的/公司）
	 * @return
	 */
	Integer getCarNumCount(Map<String,Object> paramsMap);
	
}
