package com.gzxant.service.customer.info.certificate;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.entity.customer.info.certificate.CustomerInfoCertificate;
import com.gzxant.dao.customer.info.certificate.CustomerInfoCertificateDao;
import com.gzxant.service.customer.info.certificate.ICustomerInfoCertificateService;
import com.gzxant.base.service.impl.BaseService;

/**
 * <p>
 * Certificate table 服务实现类
 * </p>
 *
 * @author tecty
 * @since 2018-07-05
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class CustomerInfoCertificateService extends BaseService<CustomerInfoCertificateDao, CustomerInfoCertificate> implements ICustomerInfoCertificateService {
	
}
