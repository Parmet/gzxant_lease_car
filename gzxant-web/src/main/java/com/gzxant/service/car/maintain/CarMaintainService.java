package com.gzxant.service.car.maintain;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.entity.car.maintain.CarMaintain;
import com.gzxant.dao.car.maintain.CarMaintainDao;
import com.gzxant.service.car.maintain.ICarMaintainService;
import com.gzxant.base.service.impl.BaseService;

/**
 * <p>
 * 车辆保养 服务实现类
 * </p>
 *
 * @author ycxiao
 * @since 2018-07-29
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class CarMaintainService extends BaseService<CarMaintainDao, CarMaintain> implements ICarMaintainService {
	
}
