package com.gzxant.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.Condition;
import com.gzxant.base.service.impl.BaseService;
import com.gzxant.dao.CarDao;
import com.gzxant.entity.Car;
import com.gzxant.service.ICarService;

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
     * 查询汽车详情
     */
	@Override
	public Car selectCarAllInfoById(Long id) {
		return this.baseMapper.selectCarInfoById(id);
	}

	/**
	 * 查询所有汽车对象详情列表
	 * @return
	 */
	public List<Car> selectAllCarInfoList(){
		return selectList(Condition.EMPTY);
	}	
	
	/**
	 * 创建汽车
	 */
    @Transactional(readOnly = false)
	@Override
	public boolean insertCar(Car car) {
		return insert(car);
	}

	/**
	 * 更新汽车信息
	 */
    @Transactional(readOnly = false)
	@Override
	public boolean updateCar(Car carNew) {
		return updateById(carNew);
	}
}
