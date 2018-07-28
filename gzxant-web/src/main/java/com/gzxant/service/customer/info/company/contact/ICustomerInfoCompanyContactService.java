package com.gzxant.service.customer.info.company.contact;

import com.gzxant.base.vo.DataTable;
import com.gzxant.dto.ContactDTO;
import com.gzxant.entity.customer.info.company.contact.CustomerInfoCompanyContact;
import com.gzxant.base.service.IBaseService;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tecty
 * @since 2018-07-05
 */
public interface ICustomerInfoCompanyContactService extends IBaseService<CustomerInfoCompanyContact> {

    public DataTable<ContactDTO> pageSearchDTO(DataTable<CustomerInfoCompanyContact> dt);

    public void insertOrUpdate(ContactDTO contactDTO);

    public void deleteTheBatchIds(List<? extends Serializable> list);
}
