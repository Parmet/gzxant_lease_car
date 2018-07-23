package com.gzxant.util;

import com.gzxant.dto.CustomerDTO;
import com.gzxant.entity.customer.info.certificate.CustomerInfoCertificate;
import com.gzxant.entity.customer.info.customer.CustomerInfoCustomer;
import com.gzxant.enums.CertificatesStatusEnum;
import com.gzxant.enums.SexEnum;
import com.gzxant.vo.CustomerVO;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: Fatal
 * @date: 2018/7/20 0020 22:25
 */
public class ConvertUtil {

    public static CustomerDTO convert(CustomerInfoCustomer customer){
        CustomerDTO customerDTO = new CustomerDTO();
        try {
            BeanUtils.copyProperties(customer,customerDTO);
            String gender = "";
            if (SexEnum.BOY.getCode().equals(customer.getGender())) {
                gender = SexEnum.BOY.getMessage();
            }
            if (SexEnum.GIRL.getCode().equals(customer.getGender())) {
                gender = SexEnum.GIRL.getMessage();
            }
            customerDTO.setGender(gender);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customerDTO;
    }

    public static List<CustomerDTO> convert(List<CustomerInfoCustomer> customers) {
        List<CustomerDTO> customerDTOS = customers.stream()
                .map(e -> convert(e))
                .collect(Collectors.toList());
        return customerDTOS;
    }

    /**
     * 参数：CustomerVO    返回值：List    List元素有：一个Customer和两个Certificate
     */
    public static List convert(CustomerVO customerVO) {
        List list = new ArrayList();
        //封装数据添加到customer
        CustomerInfoCustomer customer = new CustomerInfoCustomer();
        BeanUtils.copyProperties(customerVO, customer);
        customer.setIdentityNumber(customerVO.getIdentityNumber());
        customer.setDriveNumber(customerVO.getDriveNumber());
        list.add(customer);
        //身份证
        CustomerInfoCertificate certificateIdentity = new CustomerInfoCertificate();
        certificateIdentity.setCustomerId(customer.getId());
        certificateIdentity.setType(CertificatesStatusEnum.IDENTITY.getMessage());
        certificateIdentity.setNumber(customerVO.getIdentityNumber());
        certificateIdentity.setsAttachmentUrl(customerVO.getsIdentityImageUrl());
        certificateIdentity.setAttachmentUrl(customerVO.getIdentityImageUrl());
        certificateIdentity.setIssueDate(DateUtils.convertStrToDate(customerVO.getiIssueDate()));
        certificateIdentity.setValidityPeriod(DateUtils.convertStrToDate(customerVO.getiValidityPeriod()));
        list.add(certificateIdentity);
        //驾驶证
        CustomerInfoCertificate certificateDrive = new CustomerInfoCertificate();
        certificateDrive.setCustomerId(customer.getId());
        certificateDrive.setType(CertificatesStatusEnum.DRIVE.getMessage());
        certificateDrive.setNumber(customerVO.getDriveNumber());
        certificateDrive.setsAttachmentUrl(customerVO.getsDriveImageUrl());
        certificateDrive.setAttachmentUrl(customerVO.getDriveImageUrl());
        certificateDrive.setIssueDate(DateUtils.convertStrToDate(customerVO.getdIssueDate()));
        certificateDrive.setValidityPeriod(DateUtils.convertStrToDate(customerVO.getdValidityPeriod()));
        list.add(certificateDrive);
        return list;
    }

}
