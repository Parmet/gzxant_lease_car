package com.gzxant.service;

import java.util.List;

import com.gzxant.base.service.IBaseService;
import com.gzxant.entity.ContractInfo;
import com.gzxant.vo.ContractInfoVO;

public interface IContractInfoService extends IBaseService<ContractInfo> {
     
     /**
      * 查询某个合同对象的所有信息
      *
      * @param id
      * @return
      */
	  ContractInfo selectContractInfoAllInfoById(Long id) ;
      
      /**
       * 创建一个合同 或者更新一个合同
       *
       * @param contractInfo
       */
      boolean insertContractInfo(ContractInfo contractInfo) ;
      
      /**
       * 更新合同对象
       *
       * @param contractInfoNew
       */
       boolean updateContractInfo(ContractInfo contractInfoNew) ;
       
       /**
        * 将合同对象设置为过期合同
        * @param groupId
        * @return
        */
       boolean updateContractGroupId(String old,String contractNoOld);
       
       /**
        * 查询所有合同对象信息列表
        * @return
        */
       List<ContractInfo> selectAllContractInfoList();
       
       /**
        * 查找未过期的合同对象
        * @return
        */
       List<ContractInfo> selectContractListByIsOver(String isOver);
       
       /**
        * 保存合同对象以及合同车辆信息对象
        * @return
        */
       boolean insertContractAndCar(ContractInfoVO contractInfoVO);
       
       /**
        * 修改合同对象以及合同车辆信息对象
        * @return
        */
       boolean updateContractAndCar(ContractInfoVO contractInfoVO);
       
       /**
        * 根据一个id删除合同对象以及合同车辆信息对象
        * @return
        */
       boolean deleteContractAndCar(Long id);
       
       /**
        * 根据多个id删除合同对象以及合同车辆信息对象
        * @return
        */
       boolean deleteContractAndCarBatchIds(List<Long> ids);

       /**
        * 根据合同编号查询合同对象的id
        * @param id
        * @return
        */
       Long queryIdByContractNo(String contractNo);

       /**
        * 根据合同编号查询合同对象
        * @param contractNo
        * @return
        */
       ContractInfo queryContractByContractNo(String contractNo);
       
       /**
        * 将旧合同以及其下的涉及的合同的groupId设置为新合同的groupId
        * @param contractNo
        * @return
        */
       boolean setNewGroupId(String contractNo,String groupIdNew);
       
       
       
}
