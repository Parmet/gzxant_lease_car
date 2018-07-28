package com.gzxant.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gzxant.base.dao.CrudDao;
import com.gzxant.entity.ContractCarInfo;

public interface ContractCarInfoDao extends CrudDao<ContractCarInfo> {
	
    /**
     * 查询某个合同车辆的所有信息
     * @param id
     * @return
     */
	ContractCarInfo selectContractCarInfoById(@Param("id") Long id);
    
    /**
     * 查询所有合同车辆信息
     * @return
     */
    List<ContractCarInfo> selectAllContractCarInfo();
    
    /**
     * 新建合同车辆对象
     */
    void insertContractCarInfo(ContractCarInfo contractCarInfo);
    
    /**
     * 根据合同编号查询合同车辆信息对象集合
     * @return
     */
    List<ContractCarInfo> queryContractCarBycontractId(@Param("contractId") Long contractId);
    
    
}
