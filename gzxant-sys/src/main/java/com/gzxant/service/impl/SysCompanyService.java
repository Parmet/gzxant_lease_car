package com.gzxant.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.base.service.impl.BaseService;
import com.gzxant.dao.SysCompanyDao;
import com.gzxant.entity.SysCompany;
import com.gzxant.service.ISysCompanyService;

/**
 *
 * @author chen
 * @date 2017/7/31
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe: 公司 service
 */
@Service
@Transactional(readOnly = true,rollbackFor = Exception.class)
public class SysCompanyService extends BaseService<SysCompanyDao, SysCompany> implements ISysCompanyService {

}
