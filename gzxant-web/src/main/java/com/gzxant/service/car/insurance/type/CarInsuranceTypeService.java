package com.gzxant.service.car.insurance.type;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.entity.car.insurance.type.CarInsuranceType;
import com.gzxant.dao.car.insurance.type.CarInsuranceTypeDao;
import com.gzxant.service.car.insurance.type.ICarInsuranceTypeService;
import com.gzxant.base.service.impl.BaseService;

/**
 * <p>
 * 保险种类 服务实现类
 * </p>
 *
 * @author ycxiao
 * @since 2018-07-30
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class CarInsuranceTypeService extends BaseService<CarInsuranceTypeDao, CarInsuranceType> implements ICarInsuranceTypeService {
	
}
