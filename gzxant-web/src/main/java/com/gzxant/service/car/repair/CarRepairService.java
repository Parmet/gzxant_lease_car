package com.gzxant.service.car.repair;

import com.gzxant.constant.Global;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.entity.car.repair.CarRepair;
import com.gzxant.dao.car.repair.CarRepairDao;
import com.gzxant.service.car.repair.ICarRepairService;
import com.gzxant.base.service.impl.BaseService;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 车辆维修 服务实现类
 * </p>
 *
 * @author Fatal
 * @since 2018-07-30
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class CarRepairService extends BaseService<CarRepairDao, CarRepair>
        implements ICarRepairService {

    @Override
    @Transactional(readOnly = false)
    public void deleteAllIds(List<? extends Serializable> list) {
        if (list != null && list.size() > 0) {
            for (Serializable id : list) {
                CarRepair carRepair = new CarRepair();
                carRepair.setId((Long)id);
                carRepair.setDelFlag(Global.DEL_FLAG_DELETE);
                updateById(carRepair);
            }
        }
    }
}
