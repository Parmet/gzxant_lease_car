package com.gzxant.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.Condition;
import com.gzxant.base.service.impl.BaseService;
import com.gzxant.dao.ContractInfoDao;
import com.gzxant.entity.ContractCarInfo;
import com.gzxant.entity.ContractInfo;
import com.gzxant.service.IContractCarInfoService;
import com.gzxant.service.IContractInfoService;
import com.gzxant.shiro.GzxantSysUser;
import com.gzxant.vo.ContractInfoVO;



/**
 * 
 * @author ZCRong
 * Describe：合同管理
 *
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ContractInfoService extends BaseService<ContractInfoDao,ContractInfo> implements IContractInfoService {

	@Autowired
	IContractCarInfoService service;
	
	
    /**
     * 查询合同对象详情
     */
	@Override
	public ContractInfo selectContractInfoAllInfoById(Long id) {
		return this.baseMapper.selectContractInfoById(id);
	}
	
	/**
	 * 查询合同对象详情
	 */
	@Override
	public ContractInfo queryContractByContractNo(String contractNo) {
		return this.baseMapper.queryContractByContractNo(contractNo);
	}

	/**
	 * 查询所有合同对象详情列表
	 * @return
	 */
	public List<ContractInfo> selectAllContractInfoList(){
		return selectList(Condition.EMPTY);
	}	
	
	/**
	 * 创建合同
	 */
    @Transactional(readOnly = false)
	@Override
	public boolean insertContractInfo(ContractInfo contractInfo) {
		return insert(contractInfo);
	}

	/**
	 * 更新合同信息
	 */
    @Transactional(readOnly = false)
	@Override
	public boolean updateContractInfo(ContractInfo contractInfoNew) {
		return updateById(contractInfoNew);
	}
    
    /**
     * 更新合同对象的groupId为old，将合同设置为过期合同
     */
    @Transactional(readOnly = false)
    @Override
    public boolean updateContractGroupId(String old,String contractNoOld) {
    	boolean flag = false;
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("old", old);
    	map.put("contractNoOld", contractNoOld);
    	Integer num = this.baseMapper.updateContractGroupId(map);
    	if(num > 0 ){
    		flag = true;
    	}
    	return flag;
    }
    
    @Transactional(readOnly = false)
    @Override
    public boolean updateContractAndCar(ContractInfoVO contractInfoVO){
    	boolean flag = false;
		ContractInfo contractInfo = new ContractInfo();
		ContractCarInfo contractCarInfo = new ContractCarInfo();
		vo2contractInfo(contractInfoVO, contractInfo);
		boolean updateContractInfo = updateContractInfo(contractInfo);
		vo2ContractCarInfo(contractInfoVO, contractInfo, contractCarInfo);
		boolean updateContractCarInfo = service.updateContractCarInfo(contractCarInfo);
		if(updateContractInfo&&updateContractCarInfo){
			flag = true;
		}
		return flag;
    }
    
    @Transactional(readOnly = false)
	@Override
	public boolean insertContractAndCar(ContractInfoVO contractInfoVO) {
		boolean flag = false;
		ContractInfo contractInfo = new ContractInfo();
		ContractCarInfo contractCarInfo = new ContractCarInfo();
		
		vo2contractInfo(contractInfoVO, contractInfo);
		//保存合同对象
		boolean insertContractInfo = insertContractInfo(contractInfo);
		vo2ContractCarInfo(contractInfoVO, contractInfo, contractCarInfo);
		boolean insertContractCarInfo = service.insertContractCarInfo(contractCarInfo);
		if(insertContractInfo&&insertContractCarInfo){
			flag = true;
		}
		return flag;
	}

	private void vo2ContractCarInfo(ContractInfoVO contractInfoVO, ContractInfo contractInfo,
			ContractCarInfo contractCarInfo) {
		Long contractId = queryIdByContractNo(contractInfo.getContractNo());
		//根据合同编号查询合同对象，再获取合同的id，设置进合同车辆对象里的合同id字段，再保存进数据库
		contractCarInfo.setId(contractInfoVO.getContractCarInfoId());
		contractCarInfo.setNumber(contractInfoVO.getNumber());
		contractCarInfo.setPrice(contractInfoVO.getPrice());
		contractCarInfo.setRemark1(contractInfoVO.getRemark1());
		contractCarInfo.setTotalPrice(contractInfoVO.getTotalPrice());
		contractCarInfo.setVehicleType(contractInfoVO.getVehicleType());
		contractCarInfo.setcontractId(contractId);
	}

	private void vo2contractInfo(ContractInfoVO contractInfoVO, ContractInfo contractInfo) {
		Long companyId = GzxantSysUser.companyId();
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		contractInfo.setEnclosureName(contractInfoVO.getEnclosureName());
		contractInfo.setGroupId(uuid+uuid);
		contractInfo.setIsOver("new");
		contractInfo.setCompanyId(companyId);
		contractInfo.setId(contractInfoVO.getContractInfoId());
		contractInfo.setAgent(contractInfoVO.getAgent());
		contractInfo.setBusinessNumber(contractInfoVO.getBusinessNumber());
		contractInfo.setCarNumber(contractInfoVO.getCarNumber());
		contractInfo.setCarRentalDeposit(contractInfoVO.getCarRentalDeposit());
		contractInfo.setCompanyName(contractInfoVO.getCompanyName());
		contractInfo.setContractAmount(contractInfoVO.getContractAmount());
		contractInfo.setContractBank(contractInfoVO.getContractBank());
		contractInfo.setContractNo(contractInfoVO.getContractNo());
		contractInfo.setContractStatus(contractInfoVO.getContractStatus());
		contractInfo.setContractType(contractInfoVO.getContractType());
		contractInfo.setCustomerNameB(contractInfoVO.getCustomerNameB());
		contractInfo.setCustomerNameC(contractInfoVO.getCustomerNameC());
		contractInfo.setCustomerPhoneB(contractInfoVO.getCustomerPhoneB());
		contractInfo.setCustomerTypeB(contractInfoVO.getCustomerTypeB());
		contractInfo.setCustomerTypeC(contractInfoVO.getCustomerTypeC());
		contractInfo.setEnclosure(contractInfoVO.getEnclosure());
		contractInfo.setLeaseBeginDate(contractInfoVO.getLeaseBeginDate());
		contractInfo.setLeaseEndDate(contractInfoVO.getLeaseEndDate());
		contractInfo.setPaymentMethod(contractInfoVO.getPaymentMethod());
		contractInfo.setReceivableAccount(contractInfoVO.getReceivableAccount());
		contractInfo.setReceivableName(contractInfoVO.getReceivableName());
		contractInfo.setRefundsAccountB(contractInfoVO.getRefundsAccountB());
		contractInfo.setRefundsAccountC(contractInfoVO.getRefundsAccountC());
		contractInfo.setRefundsBankB(contractInfoVO.getRefundsBankB());
		contractInfo.setRefundsBankC(contractInfoVO.getRefundsBankC());
		contractInfo.setRefundsNameB(contractInfoVO.getRefundsNameB());
		contractInfo.setRefundsNameC(contractInfoVO.getRefundsNameC());
		contractInfo.setViolationDeposit(contractInfoVO.getViolationDeposit());
	}

	/**
	 * 查询合同对象详情
	 */
    @Transactional(readOnly = false)
	@Override
	public Long queryIdByContractNo(String id) {
		return this.baseMapper.queryIdByContractNo(id);
	}

	@Override
    @Transactional(readOnly = false)
	public boolean deleteContractAndCar(Long id) {
		return delContract(id);
	}

	private boolean delContract(Long id) {
		boolean flag = false;
		boolean delContractCarInfoflag = true;
		delContractCarInfoflag = delContractCars(id, delContractCarInfoflag);
		boolean deleteById = deleteById(id);
		if(deleteById&&delContractCarInfoflag){
			flag = true;
		}
		return flag;
	}

	private boolean delContractCars(Long id, boolean delContractCarInfoflag) {
		List<ContractCarInfo> ContractCarInfoList = service.queryContractCarBycontractId(id);
		for (ContractCarInfo contractCarInfo : ContractCarInfoList) {
			boolean deleteById2 = service.deleteById(contractCarInfo.getId());
			if(!deleteById2){
				delContractCarInfoflag = false;
				logger.debug("合同车辆类型删除失败，该id值为：{}",contractCarInfo.getId());
			}
		}
		return delContractCarInfoflag;
	}

    @Transactional(readOnly = false)
	@Override
	public boolean deleteContractAndCarBatchIds(List<Long> ids) {
		boolean flag = true;
		for (Long id : ids) {
			boolean delContract = delContract(id);
			if(!delContract){
				flag = false;
				logger.debug("删除合同对象失败，其id为：{}",id);
			}
		}
		return flag;
	}

	@Override
	public List<ContractInfo> selectContractListByIsOver(String isOver) {
		return this.baseMapper.selectContractListByIsOver(isOver);
	}

	@Override
	public boolean setNewGroupId(String contractNoOld,String groupIdNew) {
		boolean flag = false;
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("contractNoOld", contractNoOld);
		map.put("groupIdNew", groupIdNew);
		Integer num = this.baseMapper.setNewGroupId(map);
		if(num > 0){
			flag = true;
		}
		return flag;
	}

}
