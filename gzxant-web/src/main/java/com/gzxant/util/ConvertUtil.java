package com.gzxant.util;

import com.gzxant.base.vo.DataTable;
import com.gzxant.dto.CompanyDTO;
import com.gzxant.dto.ContactDTO;
import com.gzxant.dto.CustomerDTO;
import com.gzxant.dto.EntityDTO;
import com.gzxant.entity.customer.info.certificate.CustomerInfoCertificate;
import com.gzxant.entity.customer.info.company.CustomerInfoCompany;
import com.gzxant.entity.customer.info.company.contact.CustomerInfoCompanyContact;
import com.gzxant.entity.customer.info.customer.CustomerInfoCustomer;
import com.gzxant.enums.*;
import com.gzxant.vo.CompanyVO;
import com.gzxant.vo.ContactVO;
import com.gzxant.vo.CustomerDetailVO;
import com.gzxant.vo.CustomerVO;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;

import java.lang.reflect.Constructor;
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

    public static ContactDTO convert(CustomerInfoCompanyContact contact) {
        ContactDTO contactDTO = new ContactDTO();
        try {
            BeanUtils.copyProperties(contact, contactDTO);
        } catch (BeansException e) {
            e.printStackTrace();
        }
        return contactDTO;
    }

    public static CustomerInfoCompanyContact convert(ContactDTO contactDTO) {
        CustomerInfoCompanyContact contact = new CustomerInfoCompanyContact();
        try {
            BeanUtils.copyProperties(contactDTO, contact);
        } catch (BeansException e) {
            e.printStackTrace();
        }
        return contact;
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

    public static ContactDTO convert(ContactVO contactVO) {
        ContactDTO contactDTO = new ContactDTO();
        try {
            BeanUtils.copyProperties(contactVO, contactDTO);
        } catch (BeansException e) {
            e.printStackTrace();
        }
        return contactDTO;
    }

    public static ContactVO convertContactDTO2VO(ContactDTO contactDTO) {
        ContactVO contactVO = new ContactVO();
        try {
            BeanUtils.copyProperties(contactDTO, contactVO);
        } catch (BeansException e) {
            e.printStackTrace();
        }
        return contactVO;
    }

    public static CompanyVO convert(CompanyDTO companyDTO) {
        CompanyVO companyVO = new CompanyVO();
        try {
            BeanUtils.copyProperties(companyDTO, companyVO);
            companyVO.setRegisteredDate(DateUtils.getDateTime(companyDTO.getRegisteredDate()));
            companyVO.setProperty(PropertyEnum.getMessageByCode(companyDTO.getProperty()));
            companyVO.setCategory(CategoryEnum.getMessageByCode(companyDTO.getCategory()));
            companyVO.setStatus(CustomerStatusEnum.getMessageByCode(companyDTO.getStatus()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return companyVO;
    }

    public static List<CustomerDTO> convert(List<CustomerInfoCustomer> customers) {
        List<CustomerDTO> customerDTOS = customers.stream()
                .map(e -> convert(e))
                .collect(Collectors.toList());
        return customerDTOS;
    }

    public static CompanyDTO convertCompanyToDTO(CustomerInfoCompany company) {
        CompanyDTO companyDTO = new CompanyDTO();
        try {
            BeanUtils.copyProperties(company, companyDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return companyDTO;
    }

    public static List<CompanyDTO> convertCompanysToDTOS(List<CustomerInfoCompany> companies) {
        return companies.stream()
                .map(e -> convertCompanyToDTO(e))
                .collect(Collectors.toList());
    }

    public static List<ContactDTO> convertContactsToDTOS(List<CustomerInfoCompanyContact> contacts) {
        List<ContactDTO> list = contacts.stream()
                .map(e -> convert(e))
                .collect(Collectors.toList());
        return list;
    }


    public static List<CustomerVO> convertCustomerDTOToCustomerVO(List<CustomerDTO> customerDTOS) {
        List<CustomerVO> list = customerDTOS.stream()
                .map(e -> convert(e))
                .collect(Collectors.toList());
        return list;
    }

    public static List<CompanyVO> convertCompanyDTOToCompanyVO(List<CompanyDTO> companyDTOS) {
        List<CompanyVO> list = companyDTOS.stream()
                .map(e -> convert(e))
                .collect(Collectors.toList());
        return list;
    }

    public static List<ContactVO> convertContactDTO2VO(List<ContactDTO> contactDTOS) {
        List<ContactVO> list = contactDTOS.stream()
                .map(e -> convertContactDTO2VO(e))
                .collect(Collectors.toList());
        return list;
    }

    /**
     * CustomerDTODataTable 2 CustomerVODataTable
     * @param dtoDateTable
     * @return
     */
    public static DataTable<CustomerVO> convertCustomerDDT2VDT(DataTable<CustomerDTO> dtoDateTable) {
        List<CustomerDTO> rows = dtoDateTable.getRows();
        List<CustomerVO> customerVOS = convertCustomerDTOToCustomerVO(rows);
        DataTable<CustomerVO> voDataTable = new DataTable<>();
        BeanUtils.copyProperties(dtoDateTable,voDataTable);
        voDataTable.setRows(customerVOS);
        return voDataTable;
    }

    public static DataTable<ContactDTO> convertContactDT2DDT(DataTable<CustomerInfoCompanyContact> contactDataTable) {
        DataTable<ContactDTO> contactDTODataTable = new DataTable<>();
        List<CustomerInfoCompanyContact> rows = contactDataTable.getRows();
        List<ContactDTO> contactDTOS = convertContactsToDTOS(rows);
        contactDTODataTable.setRows(contactDTOS);
        return contactDTODataTable;
    }


    public static DataTable<ContactVO> convertContactDDT2VDT(DataTable<ContactDTO> dtoDateTable) {
        DataTable<ContactVO> contactVODataTable = new DataTable<>();
        List<ContactDTO> rows = dtoDateTable.getRows();
        List<ContactVO> contactVOS = convertContactDTO2VO(rows);
        contactVODataTable.setRows(contactVOS);
        return contactVODataTable;
    }

    public static DataTable<CompanyVO> convertCompanyDTOToCompanyVO(DataTable<CompanyDTO> dtoDateTable) {
        DataTable<CompanyVO> voDataTable = new DataTable<>();
        if (dtoDateTable != null) {
            List<CompanyDTO> rows = dtoDateTable.getRows();
            List<CompanyVO> vos = convertCompanyDTOToCompanyVO(rows);
            BeanUtils.copyProperties(dtoDateTable, voDataTable);

            voDataTable.setRows(vos);
        }
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
