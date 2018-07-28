package com.gzxant.service.enclosure.impl;

import com.gzxant.base.service.impl.BaseService;
import com.gzxant.dao.enclosure.EnclosureDao;
import com.gzxant.entity.enclosure.Enclosure;
import com.gzxant.service.enclosure.IEnclosureService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: Fatal
 * @date: 2018/7/28 0028 13:33
 */
@Service
@Transactional(readOnly = false, rollbackFor = Exception.class)
public class EnclosureServiceImpl extends BaseService<EnclosureDao, Enclosure>
        implements IEnclosureService {
}
