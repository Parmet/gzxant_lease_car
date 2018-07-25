package com.gzxant.service.customer.info.company.contact;

import com.gzxant.base.vo.DataTable;
import com.gzxant.constant.Global;
import com.gzxant.constant.SearchParam;
import com.gzxant.dto.ContactDTO;
import com.gzxant.enums.LeaseCarEnum;
import com.gzxant.exception.LeaseCatException;
import com.gzxant.util.ConvertUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.entity.customer.info.company.contact.CustomerInfoCompanyContact;
import com.gzxant.dao.customer.info.company.contact.CustomerInfoCompanyContactDao;
import com.gzxant.base.service.impl.BaseService;

import java.io.Serializable;
import java.util.List;

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
public class CustomerInfoCompanyContactService extends BaseService<CustomerInfoCompanyContactDao,
        CustomerInfoCompanyContact> implements ICustomerInfoCompanyContactService {

    private final String DEL_FLAG = "del_flag";

    @Override
    public DataTable<ContactDTO> pageSearchDTO(DataTable<CustomerInfoCompanyContact> dt) {
        dt.getSearchParams().put(SearchParam.SEARCH_LIKE + DEL_FLAG, Global.DEL_FLAG_NORMAL);
        DataTable<CustomerInfoCompanyContact> contactDataTable = super.pageSearch(dt);
        DataTable<ContactDTO> contactDTODataTable = null;
        try {
            contactDTODataTable = ConvertUtil.convertContactDT2DDT(contactDataTable);
            if (contactDataTable == null) {
                throw new LeaseCatException(LeaseCarEnum.CONTACT_SHOW_FAIL_WITH_CONVERT_FAIL);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contactDTODataTable;
    }

    @Override
    @Transactional
    public void insertOrUpdate(ContactDTO contactDTO) {
        CustomerInfoCompanyContact convert = ConvertUtil.convert(contactDTO);
        try {
            super.insertOrUpdate(convert);
        } catch (Exception e) {
            e.printStackTrace();
            throw new LeaseCatException(LeaseCarEnum.CONTACT_OR_UPDATE_ADD_FAIL);
        }
    }

    @Override
    @Transactional
    public void deleteTheBatchIds(List<? extends Serializable> list) {
        if (list != null) {
            for (Serializable id : list) {
                CustomerInfoCompanyContact contact = new CustomerInfoCompanyContact();
                contact.setId((Long)id);
                contact.setDelFlag(Global.DEL_FLAG_DELETE);
                updateById(contact);
            }
        }
    }
}
