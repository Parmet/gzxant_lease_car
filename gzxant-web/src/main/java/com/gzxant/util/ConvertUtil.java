package com.gzxant.util;

import com.gzxant.base.vo.DataTable;
import com.gzxant.dto.CustomerDTO;
import com.gzxant.entity.customer.info.certificate.CustomerInfoCertificate;
import com.gzxant.entity.customer.info.customer.CustomerInfoCustomer;
import com.gzxant.enums.CertificatesStatusEnum;
import com.gzxant.enums.SexEnum;
import com.gzxant.vo.CustomerDetailVO;
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

    public static CustomerVO convert(CustomerDTO customerDTO) {
        CustomerVO customerVO = new CustomerVO();
        try {
            BeanUtils.copyProperties(customerDTO,customerVO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customerVO;
    }

    public static List<CustomerDTO> convert(List<CustomerInfoCustomer> customers) {
        List<CustomerDTO> customerDTOS = customers.stream()
                .map(e -> convert(e))
                .collect(Collectors.toList());
        return customerDTOS;
    }

    public static List<CustomerVO> convertCustomerDTOToCustomerVO(List<CustomerDTO> customerDTOS) {
        List<CustomerVO> list = customerDTOS.stream()
                .map(e -> convert(e))
                .collect(Collectors.toList());
        return list;
    }

    public static DataTable<CustomerVO> convert(DataTable<CustomerDTO> dtoDateTable) {
        List<CustomerDTO> rows = dtoDateTable.getRows();
		List<CustomerVO> customerVOS = convertCustomerDTOToCustomerVO(rows);
		DataTable<CustomerVO> voDataTable = new DataTable<>();
		BeanUtils.copyProperties(dtoDateTable,voDataTable);
        voDataTable.setRows(customerVOS);
        return voDataTable;
    }


    /**
     * 参数：CustomerDetailVO    返回值：List    List元素有：一个Customer和两个Certificate
     */
    public static List convert(CustomerDetailVO customerDetailVO) {
        List list = new ArrayList();
        //封装数据添加到customer
        CustomerInfoCustomer customer = new CustomerInfoCustomer();
        BeanUtils.copyProperties(customerDetailVO, customer);
        customer.setIdentityNumber(customerDetailVO.getIdentityNumber());
        customer.setDriveNumber(customerDetailVO.getDriveNumber());
        list.add(customer);
        //身份证
        CustomerInfoCertificate certificateIdentity = new CustomerInfoCertificate();
        certificateIdentity.setCustomerId(customer.getId());
        certificateIdentity.setType(CertificatesStatusEnum.IDENTITY.getCode());
        certificateIdentity.setNumber(customerDetailVO.getIdentityNumber());
        certificateIdentity.setsAttachmentUrl(customerDetailVO.getsIdentityImageUrl());
        certificateIdentity.setAttachmentUrl(customerDetailVO.getIdentityImageUrl());
        certificateIdentity.setIssueDate(DateUtils.convertStrToDate(customerDetailVO.getiIssueDate()));
        certificateIdentity.setValidityPeriod(DateUtils.convertStrToDate(customerDetailVO.getiValidityPeriod()));
        list.add(certificateIdentity);
        //驾驶证
        CustomerInfoCertificate certificateDrive = new CustomerInfoCertificate();
        certificateDrive.setCustomerId(customer.getId());
        certificateDrive.setType(CertificatesStatusEnum.DRIVE.getCode());
        certificateDrive.setNumber(customerDetailVO.getDriveNumber());
        certificateDrive.setsAttachmentUrl(customerDetailVO.getsDriveImageUrl());
        certificateDrive.setAttachmentUrl(customerDetailVO.getDriveImageUrl());
        certificateDrive.setIssueDate(DateUtils.convertStrToDate(customerDetailVO.getdIssueDate()));
        certificateDrive.setValidityPeriod(DateUtils.convertStrToDate(customerDetailVO.getdValidityPeriod()));
        list.add(certificateDrive);
        return list;
    }




}
