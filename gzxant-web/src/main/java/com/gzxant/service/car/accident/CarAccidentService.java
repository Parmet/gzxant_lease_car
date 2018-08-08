package com.gzxant.service.car.accident;

import com.gzxant.constant.Global;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.entity.car.accident.CarAccident;
import com.gzxant.dao.car.accident.CarAccidentDao;
import com.gzxant.service.car.accident.ICarAccidentService;
import com.gzxant.base.service.impl.BaseService;

import java.util.List;

/**
 * <p>
 * 事故 服务实现类
 * </p>
 *
 * @author ycxiao
 * @since 2018-07-29
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class CarAccidentService extends BaseService<CarAccidentDao, CarAccident> implements ICarAccidentService {

    @Override
    @Transactional(readOnly = false)
    public void deleteAllIds(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long id : list) {
                CarAccident carAccident = new CarAccident();
                carAccident.setId(id);
                carAccident.setDelFlag(Global.DEL_FLAG_DELETE);
                updateById(carAccident);
            }
        }
    }
}
