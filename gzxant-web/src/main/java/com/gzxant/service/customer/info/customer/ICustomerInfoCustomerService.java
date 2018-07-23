package com.gzxant.service.customer.info.customer;

import com.gzxant.base.vo.DataTable;
import com.gzxant.dto.CustomerDTO;
import com.gzxant.entity.customer.info.customer.CustomerInfoCustomer;
import com.gzxant.base.service.IBaseService;
import com.gzxant.vo.CustomerVO;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * Customer's information 服务类
 * </p>
 *
 * @author tecty
 * @since 2018-07-05
 */
public interface ICustomerInfoCustomerService extends IBaseService<CustomerInfoCustomer> {

    public DataTable<CustomerDTO> pageSearchDto(DataTable<CustomerInfoCustomer> dt);

    public CustomerVO selectById(String id);

    boolean deleteTheBatchIds(List<? extends Serializable> list);

    public void insertOrUpdate(CustomerVO customerVO);
}
