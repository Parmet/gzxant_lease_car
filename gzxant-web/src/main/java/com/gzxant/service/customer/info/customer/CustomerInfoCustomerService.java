package com.gzxant.service.customer.info.customer;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.gzxant.base.vo.DataTable;
import com.gzxant.constant.Global;
import com.gzxant.dto.CustomerDTO;
import com.gzxant.util.ConvertUtil;
import com.gzxant.entity.customer.info.certificate.CustomerInfoCertificate;
import com.gzxant.enums.CertificatesStatusEnum;
import com.gzxant.enums.LeaseCarEnum;
import com.gzxant.exception.LeaseCatException;
import com.gzxant.service.customer.info.certificate.ICustomerInfoCertificateService;
import com.gzxant.util.DateUtils;
import com.gzxant.util.StringUtils;
import com.gzxant.vo.CustomerDetailVO;
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
 * CustomerDTO's information 服务实现类
 * </p>
 *
 * @author tecty
 * @since 2018-07-05
 * @author Fatal
 * @date 218-07-21
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class CustomerInfoCustomerService extends BaseService<CustomerInfoCustomerDao, CustomerInfoCustomer>
        implements ICustomerInfoCustomerService {

    @Autowired
    private ICustomerInfoCertificateService certificateService;

    /**
     * 导出数据
     */
    @Override
    public List<CustomerDTO> selectList() {
        //查询所有数据
        EntityWrapper<CustomerInfoCustomer> ew = new EntityWrapper<>();
            ew.where("del_flag", Global.DEL_FLAG_NORMAL);
        List<CustomerInfoCustomer> customers = selectList(ew);
        List<CustomerDTO> customerDTOS = ConvertUtil.convert(customers);
        return customerDTOS;
    }

    /**
     * 分页查询
     */
    public DataTable<CustomerDTO> pageSearchDTO(DataTable<CustomerInfoCustomer> dt) {
        dt.getSearchParams().put("search_like_del_flag",Global.DEL_FLAG_NORMAL);
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


    public CustomerDetailVO selectById(String id) {
        CustomerInfoCustomer customer = null;
        CustomerDetailVO customerDetailVO = new CustomerDetailVO();
        if (id != null) {
            customer = super.selectById(id);
            BeanUtils.copyProperties(customer, customerDetailVO);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("customer_id", id);
            List<CustomerInfoCertificate> certificates = certificateService.selectByMap(map);
            for (CustomerInfoCertificate certificate: certificates) {
                if (CertificatesStatusEnum.IDENTITY.getCode().equals(certificate.getType())) {
                    customerDetailVO.setiIssueDate(DateUtils.getDateTime("yyyy-MM-dd",certificate.getIssueDate()));
                    customerDetailVO.setiValidityPeriod(DateUtils.getDateTime("yyyy-MM-dd",certificate.getValidityPeriod()));
                    customerDetailVO.setIdentityImageUrl(certificate.getAttachmentUrl());
                    customerDetailVO.setsIdentityImageUrl(certificate.getsAttachmentUrl());
                    continue;
                }
                if (CertificatesStatusEnum.DRIVE.getCode().equals(certificate.getType())) {
                    customerDetailVO.setdIssueDate(DateUtils.getDateTime("yyyy-MM-dd",certificate.getIssueDate()));
                    customerDetailVO.setdValidityPeriod(DateUtils.getDateTime("yyyy-MM-dd",certificate.getValidityPeriod()));
                    customerDetailVO.setDriveImageUrl(certificate.getAttachmentUrl());
                    customerDetailVO.setsDriveImageUrl(certificate.getsAttachmentUrl());
                    continue;
                }
            }
        }
        return customerDetailVO;
    }

    /**
     * 批量删除 该删除标记
     */
    @Override
    @Transactional
    public void deleteTheBatchIds(List<? extends Serializable> list) {
        if (list != null) {
            for (Serializable id : list) {
                CustomerInfoCustomer customer = new CustomerInfoCustomer();
                customer.setId((String) id);
                customer.setDelFlag(Global.DEL_FLAG_DELETE);
                updateById(customer);
            }
            //把每个id对于的证件信息删除
            for (Serializable id : list) {
                CustomerInfoCertificate certificate = new CustomerInfoCertificate();
                certificate.setDelFlag(Global.DEL_FLAG_DELETE);
                EntityWrapper<CustomerInfoCertificate> ew = new EntityWrapper<>();
                ew.where("customer_id={0}",id);
                certificateService.update(certificate, ew);
            }
        } else {
            throw new LeaseCatException(LeaseCarEnum.PLEASE_SELECT_THE_DATA);
        }
    }

    @Override
    @Transactional
    public void insertOrUpdate(CustomerDetailVO customerDetailVO) {

        if (customerDetailVO == null) {
            throw new LeaseCatException(LeaseCarEnum.CUSTOMER_OR_UPDATE_ADD_FAIL);
        }

        boolean flag = false;       //false:insert; true:update;
        if (!StringUtils.isEmpty(customerDetailVO.getId())) {
            flag = true;
        }

        List list = ConvertUtil.convert(customerDetailVO);
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
                    ew.where("customer_id={0}",customerId).and("type={0}",certificate.getType());
                    certificateService.update(certificate, ew);
                }
                continue;
            }
        }
    }


}
