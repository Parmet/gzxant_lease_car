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

    /** Entity 2 DTO */

    /** Customer 2 CustomerDTO */
    public static CustomerDTO convertEntity2DTO(CustomerInfoCustomer customer){
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

    /** Contact 2 CustomerDTO */
    public static ContactDTO convertEntity2DTO(CustomerInfoCompanyContact contact) {
        ContactDTO contactDTO = new ContactDTO();
        try {
            BeanUtils.copyProperties(contact, contactDTO);
        } catch (BeansException e) {
            e.printStackTrace();
        }
        return contactDTO;
    }

    /** Company 2 CustomerDTO */
    public static CompanyDTO convertEntity2DTO(CustomerInfoCompany company) {
        CompanyDTO companyDTO = new CompanyDTO();
        try {
            BeanUtils.copyProperties(company, companyDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return companyDTO;
    }

    /** Customers 2 CustomerDTOS */
    public static List<CustomerDTO> convertEntitys2CustomerDTOS(List<CustomerInfoCustomer> customers) {
        List<CustomerDTO> customerDTOS = customers.stream()
                .map(e -> convertEntity2DTO(e))
                .collect(Collectors.toList());
        return customerDTOS;
    }

    /** Companys 2 CustomerDTOS */
    public static List<CompanyDTO> convertEntitys2CompanyDTOS(List<CustomerInfoCompany> companies) {
        return companies.stream()
                .map(e -> convertEntity2DTO(e))
                .collect(Collectors.toList());
    }

    /** Contacts 2 CustomerDTOS */
    public static List<ContactDTO> convertEntitys2ContactDTOS(List<CustomerInfoCompanyContact> contacts) {
        List<ContactDTO> list = contacts.stream()
                .map(e -> convertEntity2DTO(e))
                .collect(Collectors.toList());
        return list;
    }

    /** DataTable -> contact 2 ContactDTO */
    public static DataTable<ContactDTO> convertEntityDT2ContactDTODT(DataTable<CustomerInfoCompanyContact> contactDataTable) {
        DataTable<ContactDTO> contactDTODataTable = new DataTable<>();
        List<CustomerInfoCompanyContact> rows = contactDataTable.getRows();
        List<ContactDTO> contactDTOS = convertEntitys2ContactDTOS(rows);
        contactDTODataTable.setRows(contactDTOS);
        return contactDTODataTable;
    }


    /** DTO 2 VO */

    /** CustomerDTO 2 CustomerVO */
    public static CustomerVO convertDTO2VO(CustomerDTO customerDTO) {
        CustomerVO customerVO = new CustomerVO();
        try {
            BeanUtils.copyProperties(customerDTO,customerVO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customerVO;
    }

    /** ContactDTO 2 ContactVO */
    public static ContactVO convertDTO2VO(ContactDTO contactDTO) {
        ContactVO contactVO = new ContactVO();
        try {
            BeanUtils.copyProperties(contactDTO, contactVO);
        } catch (BeansException e) {
            e.printStackTrace();
        }
        return contactVO;
    }

    /** CompanyDTO 2 CompanyVO */
    public static CompanyVO convertDTO2VO(CompanyDTO companyDTO) {
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

    /** CustomerDTOS 2 CustomerVOS */
    public static List<CustomerVO> convertCustomerDTOS2CustomerVOS(List<CustomerDTO> customerDTOS) {
        List<CustomerVO> list = customerDTOS.stream()
                .map(e -> convertDTO2VO(e))
                .collect(Collectors.toList());
        return list;
    }

    /** CompanyDTOS 2 CompanyVOS */
    public static List<CompanyVO> convertCompanyDTOS2CompanyVOS(List<CompanyDTO> companyDTOS) {
        List<CompanyVO> list = companyDTOS.stream()
                .map(e -> convertDTO2VO(e))
                .collect(Collectors.toList());
        return list;
    }

    /** ContactDTOS 2 ContactVO */
    public static List<ContactVO> convertContactDTOS2ContactVOS(List<ContactDTO> contactDTOS) {
        List<ContactVO> list = contactDTOS.stream()
                .map(e -> convertDTO2VO(e))
                .collect(Collectors.toList());
        return list;
    }

    /** DataTable -> ContactDTO 2 ContactVO */
    public static DataTable<ContactVO> convertContactDTODT2ContactVODT(DataTable<ContactDTO> dtoDateTable) {
        DataTable<ContactVO> contactVODataTable = new DataTable<>();
        List<ContactDTO> rows = dtoDateTable.getRows();
        List<ContactVO> contactVOS = convertContactDTOS2ContactVOS(rows);
        contactVODataTable.setRows(contactVOS);
        return contactVODataTable;
    }

    /**
     * CustomerDTODataTable 2 CustomerVODataTable
     * @param dtoDateTable
     * @return
     */
    public static DataTable<CustomerVO> convertCustomerDTODT2CustomerVODT(DataTable<CustomerDTO> dtoDateTable) {
        List<CustomerDTO> rows = dtoDateTable.getRows();
        List<CustomerVO> customerVOS = convertCustomerDTOS2CustomerVOS(rows);
        DataTable<CustomerVO> voDataTable = new DataTable<>();
        BeanUtils.copyProperties(dtoDateTable,voDataTable);
        voDataTable.setRows(customerVOS);
        return voDataTable;
    }

    /** DataTable CompanyDTO 2 CompanyVO */
    public static DataTable<CompanyVO> convertCompanyDTODT2CompanyVODT(DataTable<CompanyDTO> dtoDateTable) {
        DataTable<CompanyVO> voDataTable = new DataTable<>();
        if (dtoDateTable != null) {
            List<CompanyDTO> rows = dtoDateTable.getRows();
            List<CompanyVO> vos = convertCompanyDTOS2CompanyVOS(rows);
            BeanUtils.copyProperties(dtoDateTable, voDataTable);

            voDataTable.setRows(vos);
        }
        return voDataTable;
    }


    /** VO 2 DTO */

    /** ContactVO 2 ContactDTO */
    public static ContactDTO convert(ContactVO contactVO) {
        ContactDTO contactDTO = new ContactDTO();
        try {
            BeanUtils.copyProperties(contactVO, contactDTO);
        } catch (BeansException e) {
            e.printStackTrace();
        }
        return contactDTO;
    }

    /** DTO 2 Entity */

    /** ContactDTO 2 Contact */
    public static CustomerInfoCompanyContact convert(ContactDTO contactDTO) {
        CustomerInfoCompanyContact contact = new CustomerInfoCompanyContact();
        try {
            BeanUtils.copyProperties(contactDTO, contact);
        } catch (BeansException e) {
            e.printStackTrace();
        }
        return contact;
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
