package com.gzxant.service.customer.info.customer;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.gzxant.base.vo.DataTable;
import com.gzxant.util.ConvertUtil;
import com.gzxant.dto.CustomerDTO;
import com.gzxant.entity.customer.info.certificate.CustomerInfoCertificate;
import com.gzxant.enums.CertificatesStatusEnum;
import com.gzxant.enums.LeaseCarEnum;
import com.gzxant.exception.LeaseCatException;
import com.gzxant.service.customer.info.certificate.ICustomerInfoCertificateService;
import com.gzxant.util.DateUtils;
import com.gzxant.util.StringUtils;
import com.gzxant.vo.CustomerVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.entity.customer.info.customer.CustomerInfoCustomer;
import com.gzxant.dao.customer.info.customer.CustomerInfoCustomerDao;
import com.gzxant.base.service.impl.BaseService;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class CustomerInfoCustomerService extends BaseService<CustomerInfoCustomerDao, CustomerInfoCustomer>
        implements ICustomerInfoCustomerService {

    @Autowired
    private ICustomerInfoCertificateService certificateService;

    /**
     * 分页查询
     */
    public DataTable<CustomerDTO> pageSearchDto(DataTable<CustomerInfoCustomer> dt) {

        DataTable<CustomerInfoCustomer> customerDataTable = super.pageSearch(dt);
        List<CustomerInfoCustomer> rows = customerDataTable.getRows();

        List<CustomerDTO> customerDTOS = ConvertUtil.convert(rows);

        //封装数据
        DataTable<CustomerDTO> customerDtoDataTable = new DataTable<>();
        try {
            BeanUtils.copyProperties(customerDataTable,customerDtoDataTable);
        } catch (Exception e) {
            e.printStackTrace();
        }
        customerDtoDataTable.setRows(customerDTOS);

        return customerDtoDataTable;
    }


    public CustomerVO selectById(String id) {
        CustomerInfoCustomer customer = null;
        CustomerVO customerVO = new CustomerVO();
        if (id != null) {
            customer = super.selectById(id);
            BeanUtils.copyProperties(customer, customerVO);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("customer_id", id);
            List<CustomerInfoCertificate> certificates = certificateService.selectByMap(map);
            for (CustomerInfoCertificate certificate: certificates) {
                if (CertificatesStatusEnum.IDENTITY.getMessage().equals(certificate.getType())) {
                    customerVO.setiIssueDate(DateUtils.getDateTime("yyyy-MM-dd",certificate.getIssueDate()));
                    customerVO.setiValidityPeriod(DateUtils.getDateTime("yyyy-MM-dd",certificate.getValidityPeriod()));
                    customerVO.setIdentityImageUrl(certificate.getAttachmentUrl());
                    customerVO.setsIdentityImageUrl(certificate.getsAttachmentUrl());
                    continue;
                }
                if (CertificatesStatusEnum.DRIVE.getMessage().equals(certificate.getType())) {
                    customerVO.setdIssueDate(DateUtils.getDateTime("yyyy-MM-dd",certificate.getIssueDate()));
                    customerVO.setdValidityPeriod(DateUtils.getDateTime("yyyy-MM-dd",certificate.getValidityPeriod()));
                    customerVO.setDriveImageUrl(certificate.getAttachmentUrl());
                    customerVO.setsDriveImageUrl(certificate.getsAttachmentUrl());
                    continue;
                }
            }
        }
        return customerVO;
    }

    /**
     * 批量删除
     */
    @Override
    public boolean deleteTheBatchIds(List<? extends Serializable> list) {
        if (list != null) {
            super.deleteBatchIds(list);
            //把每个id对于的证件信息删除
            for (Serializable id : list) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("customer_id",id);
                certificateService.deleteByMap(map);
            }
        } else {
            throw new LeaseCatException(LeaseCarEnum.PLEASE_SELECT_THE_DATA);
        }
        return false;
    }

    @Override
    @Transactional
    public void insertOrUpdate(CustomerVO customerVO) {

        if (customerVO == null) {
            throw new LeaseCatException(LeaseCarEnum.CUSTOMER_ADD_FAIL);
        }

        boolean flag = false;       //false:insert; true:update;
        if (!StringUtils.isEmpty(customerVO.getId())) {
            flag = true;
        }

        List list = ConvertUtil.convert(customerVO);
        String customerId = "";
        final String customerIdf = customerId;
        for (Object o : list) {
            //判断后分别调用服务添加
            if (o instanceof CustomerInfoCustomer) {
                CustomerInfoCustomer customer = (CustomerInfoCustomer) o;
                insertOrUpdate(customer);
                customerId = customer.getId();
                continue;
            }
            if (o instanceof CustomerInfoCertificate) {
                CustomerInfoCertificate certificate = (CustomerInfoCertificate) o;
                certificate.setCustomerId(customerId);
                if (!flag) {
                    certificateService.insert(certificate);
                } else {
                    EntityWrapper<CustomerInfoCertificate> ew = new EntityWrapper<>();
//                    ew.where("customer_id={0},type={1}",customerId,certificate.getType());
                    ew.where("customer_id={0}",customerId).and("type={0}",certificate.getType());
                    certificateService.update(certificate, ew);
                }
                continue;
            }
        }
    }
}
