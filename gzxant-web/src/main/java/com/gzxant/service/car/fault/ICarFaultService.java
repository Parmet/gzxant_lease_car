package com.gzxant.service.car.fault;

import com.gzxant.entity.car.fault.CarFault;
import com.gzxant.base.service.IBaseService;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 故障 服务类
 * </p>
 *
 * @author Fatal
 * @since 2018-07-30
 */
public interface ICarFaultService extends IBaseService<CarFault> {

    void deleteALLIds(List<? extends Serializable> list);

}
