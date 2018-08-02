package com.gzxant.dao;

import java.util.List;
import java.util.Map;

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
     * 根据groupId查询所有合同信息
     * @return
     */
    List<ContractInfo> selectContractListByIsOver(@Param("isOver") String isOver);
    
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
    
    /**
     * 根据合同编号查询合同对象
     * @param contractNo
     * @return
     */
    ContractInfo queryContractByContractNo(@Param("contractNo")String contractNo);
    
    /**
     * 将合同对象设置为过期合同
     * @param groupId
     * @return
     */
    Integer updateContractGroupId(Map<String,Object> map);
    
    /**
     * 将旧合同以及其下的涉及的合同的groupId设置为新合同的groupId
     * @param contractNo
     * @param groupIdNew
     * @return
     */
    Integer setNewGroupId(Map<String,Object> map);
    
}
