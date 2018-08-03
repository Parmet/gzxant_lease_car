package com.gzxant.service;

import java.util.List;

import com.gzxant.base.service.IBaseService;
import com.gzxant.entity.ContractCarInfo;

public interface IContractCarInfoService extends IBaseService<ContractCarInfo> {
     
     /**
      * 查询某个合同车辆信息对象的所有信息
      *
      * @param id
      * @return
      */
	  ContractCarInfo selectContractCarInfoAllInfoById(Long id) ;
      
      /**
       * 创建一个合同车辆信息对象 或者更新一个合同车辆信息对象
       *
       * @param ContractCarInfo
       */
      boolean insertContractCarInfo(ContractCarInfo ContractCarInfo) ;
      
      /**
       * 更新合同车辆信息对象
       *
       * @param ContractCarInfoNew
       */
       boolean updateContractCarInfo(ContractCarInfo ContractCarInfoNew) ;
       
       /**
        * 查询所有合同车辆信息对象列表
        * @return
        */
       List<ContractCarInfo> selectAllContractCarInfoList();
       
       /**
        * 根据合同编号查询合同车俩个信息对象集合
        * @param contractId
        * @return
        */
       List<ContractCarInfo> queryContractCarBycontractId(Long contractId);
       
       
}
