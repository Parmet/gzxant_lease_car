package com.gzxant.service.car.fault;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.entity.car.fault.CarFault;
import com.gzxant.dao.car.fault.CarFaultDao;
import com.gzxant.service.car.fault.ICarFaultService;
import com.gzxant.base.service.impl.BaseService;

/**
 * <p>
 * 故障 服务实现类
 * </p>
 *
 * @author ycxiao
 * @since 2018-07-30
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class CarFaultService extends BaseService<CarFaultDao, CarFault> implements ICarFaultService {
	
}
