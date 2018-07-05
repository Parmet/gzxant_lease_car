package com.gzxant.service.customer.info.company;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.entity.customer.info.company.CustomerInfoCompany;
import com.gzxant.dao.customer.info.company.CustomerInfoCompanyDao;
import com.gzxant.service.customer.info.company.ICustomerInfoCompanyService;
import com.gzxant.base.service.impl.BaseService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tecty
 * @since 2018-07-05
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class CustomerInfoCompanyService extends BaseService<CustomerInfoCompanyDao, CustomerInfoCompany> implements ICustomerInfoCompanyService {
	
}
