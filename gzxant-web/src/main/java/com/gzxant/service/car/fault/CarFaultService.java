package com.gzxant.service.car.fault;

import com.gzxant.constant.Global;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.entity.car.fault.CarFault;
import com.gzxant.dao.car.fault.CarFaultDao;
import com.gzxant.service.car.fault.ICarFaultService;
import com.gzxant.base.service.impl.BaseService;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 故障 服务实现类
 * </p>
 *
 * @author Fatal
 * @since 2018-07-30
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class CarFaultService extends BaseService<CarFaultDao, CarFault>
        implements ICarFaultService {

    @Override
    @Transactional(readOnly = false)
    public void deleteALLIds(List<? extends Serializable> list) {
        if (list != null && list.size() > 0) {
            for (Serializable id : list) {
                CarFault carFault = new CarFault();
                carFault.setId((Long)id);
                carFault.setDelFlag(Global.DEL_FLAG_DELETE);
                updateById(carFault);
            }
        }
    }
}
