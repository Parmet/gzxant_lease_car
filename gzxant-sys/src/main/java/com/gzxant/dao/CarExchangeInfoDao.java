package com.gzxant.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gzxant.base.dao.CrudDao;
import com.gzxant.entity.CarExchangeInfo;
import com.gzxant.entity.ContractInfo;

public interface CarExchangeInfoDao extends CrudDao<CarExchangeInfo> {

    /**
     * 查询某个合同对象的所有信息
     * @param id
     * @return
     */
	CarExchangeInfo selectCarExchangeInfoById(@Param("id") Long id);
    
    /**
     * 查询所有合同信息
     * @return
     */
    List<CarExchangeInfo> selectAllCarExchangeInfo();
    
    /**
     * 新建合同对象
     */
    void insertCarExchangeInfo(CarExchangeInfo carExchangeInfo);
	
}
