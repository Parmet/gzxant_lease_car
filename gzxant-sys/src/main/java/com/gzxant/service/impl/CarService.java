package com.gzxant.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.base.service.impl.BaseService;
import com.gzxant.dao.CarDao;
import com.gzxant.entity.Car;
import com.gzxant.entity.SysUser;
import com.gzxant.service.ICarService;
import com.gzxant.util.PasswordUtils;

/**
 * 
 * @author ZCRong
 * Describe：汽车管理
 *
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class CarService extends BaseService<CarDao,Car> implements ICarService {

	/**
	 *	创建汽车操作 
	 */
    @Transactional(readOnly = false)
	@Override
	public void add(Car car) {
        insert(car);
    }
}
