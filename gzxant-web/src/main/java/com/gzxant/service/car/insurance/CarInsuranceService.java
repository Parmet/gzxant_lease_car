package com.gzxant.service.car.insurance;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.entity.car.insurance.CarInsurance;
import com.gzxant.dao.car.insurance.CarInsuranceDao;
import com.gzxant.service.car.insurance.ICarInsuranceService;
import com.gzxant.base.service.impl.BaseService;

/**
 * <p>
 * 车辆保险 服务实现类
 * </p>
 *
 * @author ycxiao
 * @since 2018-07-30
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class CarInsuranceService extends BaseService<CarInsuranceDao, CarInsurance> implements ICarInsuranceService {
	
}
