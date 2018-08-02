package com.gzxant.service.car.accident;

import com.gzxant.entity.car.accident.CarAccident;
import com.gzxant.base.service.IBaseService;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 事故 服务类
 * </p>
 *
 * @author ycxiao
 * @since 2018-07-29
 */
public interface ICarAccidentService extends IBaseService<CarAccident> {

    void deleteAllIds(List<Long> list);
}
