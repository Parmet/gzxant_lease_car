package com.gzxant.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gzxant.base.dao.CrudDao;
import com.gzxant.entity.ContractInfo;

public interface ContractInfoDao extends CrudDao<ContractInfo> {

    /**
     * 查询某个合同对象的所有信息
     * @param id
     * @return
     */
	ContractInfo selectContractInfoById(@Param("id") Long id);
    
    /**
     * 查询所有合同信息
     * @return
     */
    List<ContractInfo> selectAllContractInfo();
    
    /**
     * 新建合同对象
     */
    void insertContractInfo(ContractInfo contractInfo);
    
    /**
     * 根据合同编号查询合同对象的id
     * @param contractNo
     * @return
     */
    Long queryIdByContractNo(@Param("contractNo")String contractNo);
    
	
}
