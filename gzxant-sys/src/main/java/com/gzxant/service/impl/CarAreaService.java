package com.gzxant.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.Condition;
import com.gzxant.base.service.impl.BaseService;
import com.gzxant.dao.CarAreaDao;
import com.gzxant.entity.CarArea;
import com.gzxant.service.ICarAreaService;

/**
 * 
 * @author ZCRong
 * Describe：车辆设置
 *
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class CarAreaService extends BaseService<CarAreaDao,CarArea> implements ICarAreaService {


    /**
     * 查询车辆设置详情
     */
	@Override
	public CarArea selectCarAreaAllInfoById(Long id) {
		return this.baseMapper.selectCarAreaInfoById(id);
	}

	/**
	 * 查询所有车辆设置详情列表
	 * @return
	 */
	public List<CarArea> selectAllCarAreaInfoList(){
		return selectList(Condition.EMPTY);
	}	
	
	/**
	 * 创建车辆设置对象
	 */
    @Transactional(readOnly = false)
	@Override
	public boolean insertCarArea(CarArea carArea) {
		return insert(carArea);
	}

	/**
	 * 更新车辆设置信息
	 */
    @Transactional(readOnly = false)
	@Override
	public boolean updateCarArea(CarArea carAreaNew) {
		return updateById(carAreaNew);
	}

}
