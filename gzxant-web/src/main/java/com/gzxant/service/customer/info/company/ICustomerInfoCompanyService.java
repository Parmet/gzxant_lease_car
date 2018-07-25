package com.gzxant.service.customer.info.company;

import com.gzxant.base.vo.DataTable;
import com.gzxant.dto.CompanyDTO;
import com.gzxant.entity.customer.info.company.CustomerInfoCompany;
import com.gzxant.base.service.IBaseService;
import com.gzxant.vo.CompanyVO;
import com.gzxant.vo.CustomerVO;

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
public interface ICustomerInfoCompanyService extends IBaseService<CustomerInfoCompany> {

    public DataTable<CompanyDTO> pageSearchDTO(DataTable<CustomerInfoCompany> dt);

    public Long insertOrUpdate(CompanyVO companyVO);

    public CompanyVO selectById(Long id);

    public void deleteTheBatchIds(List<? extends Serializable> list);
}
