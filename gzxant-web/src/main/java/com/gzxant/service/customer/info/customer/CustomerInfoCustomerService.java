package com.gzxant.service.customer.info.customer;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.entity.customer.info.customer.CustomerInfoCustomer;
import com.gzxant.dao.customer.info.customer.CustomerInfoCustomerDao;
import com.gzxant.service.customer.info.customer.ICustomerInfoCustomerService;
import com.gzxant.base.service.impl.BaseService;

/**
 * <p>
 * Customer's information 服务实现类
 * </p>
 *
 * @author tecty
 * @since 2018-07-05
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class CustomerInfoCustomerService extends BaseService<CustomerInfoCustomerDao, CustomerInfoCustomer> implements ICustomerInfoCustomerService {
	
}
