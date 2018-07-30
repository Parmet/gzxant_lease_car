package com.gzxant.service.violation.regulations;

import com.gzxant.entity.violation.regulations.ViolationRegulations;
import com.gzxant.base.service.IBaseService;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 违章 服务类
 * </p>
 *
 * @author Fatal
 * @since 2018-07-30
 */
public interface IViolationRegulationsService extends IBaseService<ViolationRegulations> {

    void deleteAllIds(List<? extends Serializable> list);

}
