package com.gzxant.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.Condition;
import com.gzxant.base.service.impl.BaseService;
import com.gzxant.dao.ContractCarInfoDao;
import com.gzxant.entity.ContractCarInfo;
import com.gzxant.service.IContractCarInfoService;

/**
 * 
 * @author ZCRong
 * Describe：合同管理
 *
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ContractCarInfoService extends BaseService<ContractCarInfoDao,ContractCarInfo> implements IContractCarInfoService {

	
    /**
     * 查询合同对象详情
     */
	@Override
	public ContractCarInfo selectContractCarInfoAllInfoById(Long id) {
		return this.baseMapper.selectContractCarInfoById(id);
	}

	/**
	 * 查询所有合同对象详情列表
	 * @return
	 */
	public List<ContractCarInfo> selectAllContractCarInfoList(){
		return selectList(Condition.EMPTY);
	}	
	
	/**
	 * 创建合同
	 */
    @Transactional(readOnly = false)
	@Override
	public boolean insertContractCarInfo(ContractCarInfo ContractCarInfo) {
		return insert(ContractCarInfo);
	}

	/**
	 * 更新合同信息
	 */
    @Transactional(readOnly = false)
	@Override
	public boolean updateContractCarInfo(ContractCarInfo ContractCarInfoNew) {
		return updateById(ContractCarInfoNew);
	}

    /**
     * 根据订单编号查找合同车辆对象集合
     */
	@Override
	public List<ContractCarInfo> queryContractCarBycontractId(Long contractId) {
		
		return this.baseMapper.queryContractCarBycontractId(contractId);
	}


}
