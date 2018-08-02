package com.gzxant.service.violation.regulations;

import com.gzxant.constant.Global;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.entity.violation.regulations.ViolationRegulations;
import com.gzxant.dao.violation.regulations.ViolationRegulationsDao;
import com.gzxant.service.violation.regulations.IViolationRegulationsService;
import com.gzxant.base.service.impl.BaseService;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 违章 服务实现类
 * </p>
 *
 * @author Fatal
 * @since 2018-07-30
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ViolationRegulationsService extends BaseService<ViolationRegulationsDao,
        ViolationRegulations> implements IViolationRegulationsService {

    @Override
    @Transactional(readOnly = false)
    public void deleteAllIds(List<? extends Serializable> list) {
        if (list != null && list.size() > 0) {
            for (Serializable id : list) {
                ViolationRegulations regulations = new ViolationRegulations();
                regulations.setId((Long)id);
                regulations.setDelFlag(Global.DEL_FLAG_DELETE);
                updateById(regulations);
            }
        }
    }
}
