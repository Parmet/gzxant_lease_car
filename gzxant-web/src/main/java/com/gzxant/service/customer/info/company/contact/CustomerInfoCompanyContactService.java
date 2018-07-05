package com.gzxant.service.customer.info.company.contact;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.entity.customer.info.company.contact.CustomerInfoCompanyContact;
import com.gzxant.dao.customer.info.company.contact.CustomerInfoCompanyContactDao;
import com.gzxant.service.customer.info.company.contact.ICustomerInfoCompanyContactService;
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
public class CustomerInfoCompanyContactService extends BaseService<CustomerInfoCompanyContactDao, CustomerInfoCompanyContact> implements ICustomerInfoCompanyContactService {
	
}
