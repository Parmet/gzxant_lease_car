package com.gzxant.service.car.yearly.inspection;

import com.gzxant.entity.car.yearly.inspection.CarYearlyInspection;
import com.gzxant.base.service.IBaseService;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 年检 服务类
 * </p>
 *
 * @author Fatal
 * @since 2018-07-30
 */
public interface ICarYearlyInspectionService extends IBaseService<CarYearlyInspection> {

    void deleteAllIds(List<? extends Serializable> list);
}
