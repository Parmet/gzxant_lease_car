package com.gzxant.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.base.service.impl.BaseService;
import com.gzxant.dao.GzxantLogDao;
import com.gzxant.entity.GzxantLog;
import com.gzxant.service.IGzxantLogService;

/**
 * @author chen
 * @date 2017/9/19
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe: slife 日志 service
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class GzxantLogService extends BaseService<GzxantLogDao, GzxantLog> implements IGzxantLogService {


}
