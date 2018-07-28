package com.gzxant.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.Condition;
import com.gzxant.base.service.impl.BaseService;
import com.gzxant.dao.CarExchangeInfoDao;
import com.gzxant.entity.CarExchangeInfo;
import com.gzxant.service.ICarExchangeInfoService;

/**
 * 
 * @author ZCRong
 * Describe：车辆申请管理
 *
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class CarExchangeInfoService extends BaseService<CarExchangeInfoDao,CarExchangeInfo> implements ICarExchangeInfoService {


    /**
     * 查询车辆申请对象详情
     */
	@Override
	public CarExchangeInfo selectCarExchangeInfoAllInfoById(Long id) {
		return this.baseMapper.selectCarExchangeInfoById(id);
	}

	/**
	 * 查询所有车辆申请对象详情列表
	 * @return
	 */
	public List<CarExchangeInfo> selectAllCarExchangeInfoList(){
		return selectList(Condition.EMPTY);
	}	
	
	/**
	 * 创建车辆申请
	 */
    @Transactional(readOnly = false)
	@Override
	public boolean insertCarExchangeInfo(CarExchangeInfo CarExchangeInfo) {
		return insert(CarExchangeInfo);
	}

	/**
	 * 更新车辆申请信息
	 */
    @Transactional(readOnly = false)
	@Override
	public boolean updateCarExchangeInfo(CarExchangeInfo CarExchangeInfoNew) {
		return updateById(CarExchangeInfoNew);
	}


}
