package com.gzxant.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.Condition;
import com.gzxant.base.service.impl.BaseService;
import com.gzxant.dao.CarSetDao;
import com.gzxant.entity.CarSet;
import com.gzxant.service.ICarSetService;

/**
 * 
 * @author ZCRong
 * Describe：车辆设置
 *
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class CarSetService extends BaseService<CarSetDao,CarSet> implements ICarSetService {


    /**
     * 查询车辆设置详情
     */
	@Override
	public CarSet selectCarSetAllInfoById(Long id) {
		return this.baseMapper.selectCarSetInfoById(id);
	}

	/**
	 * 查询所有车辆设置详情列表
	 * @return
	 */
	public List<CarSet> selectAllCarSetInfoList(){
		return selectList(Condition.EMPTY);
	}	
	
	/**
	 * 创建车辆设置对象
	 */
    @Transactional(readOnly = false)
	@Override
	public boolean insertCarSet(CarSet carSet) {
		return insert(carSet);
	}

	/**
	 * 更新车辆设置信息
	 */
    @Transactional(readOnly = false)
	@Override
	public boolean updateCarSet(CarSet carSetNew) {
		return updateById(carSetNew);
	}

}
