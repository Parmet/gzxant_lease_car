package com.gzxant.service.customer.info.customer;

import com.gzxant.base.vo.DataTable;
import com.gzxant.dto.CustomerDTO;
import com.gzxant.entity.customer.info.customer.CustomerInfoCustomer;
import com.gzxant.base.service.IBaseService;
import com.gzxant.vo.CustomerDetailVO;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * Customer's information 服务类
 * </p>
 *
 * @author tecty
 * @since 2018-07-05
 * @author Fatal
 * @date 218-07-21
 */
public interface ICustomerInfoCustomerService extends IBaseService<CustomerInfoCustomer> {

    public DataTable<CustomerDTO> pageSearchDTO(DataTable<CustomerInfoCustomer> dt);

    public CustomerDetailVO selectById(String id);

    boolean deleteTheBatchIds(List<? extends Serializable> list);

    public void insertOrUpdate(CustomerDetailVO customerDetailVO);

    List<CustomerDTO> selectList();
}
