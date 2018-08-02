package com.gzxant.service.car.repair;

import com.gzxant.entity.car.repair.CarRepair;
import com.gzxant.base.service.IBaseService;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 车辆维修 服务类
 * </p>
 *
 * @author Fatal
 * @since 2018-07-30
 */
public interface ICarRepairService extends IBaseService<CarRepair> {

    void deleteAllIds(List<? extends Serializable> list);

}
