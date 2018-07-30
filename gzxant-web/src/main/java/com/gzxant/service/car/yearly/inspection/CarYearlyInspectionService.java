package com.gzxant.service.car.yearly.inspection;

import com.gzxant.constant.Global;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.entity.car.yearly.inspection.CarYearlyInspection;
import com.gzxant.dao.car.yearly.inspection.CarYearlyInspectionDao;
import com.gzxant.service.car.yearly.inspection.ICarYearlyInspectionService;
import com.gzxant.base.service.impl.BaseService;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 年检 服务实现类
 * </p>
 *
 * @author Fatal
 * @since 2018-07-30
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class CarYearlyInspectionService extends BaseService<CarYearlyInspectionDao,
        CarYearlyInspection> implements ICarYearlyInspectionService {

    @Override
    @Transactional(readOnly = false)
    public void deleteAllIds(List<? extends Serializable> list) {
        if (list != null && list.size() > 0) {
            for (Serializable id : list) {
                CarYearlyInspection inspection = new CarYearlyInspection();
                inspection.setId((Long)id);
                inspection.setDelFlag(Global.DEL_FLAG_DELETE);
                updateById(inspection);
            }
        }
    }
}
