package com.gzxant.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.Condition;
import com.gzxant.base.service.impl.BaseService;
import com.gzxant.dao.CarExchangeInfoDao;
import com.gzxant.entity.CarExchangeInfo;
import com.gzxant.entity.ContractInfo;
import com.gzxant.enums.HttpCodeEnum;
import com.gzxant.exception.SlifeException;
import com.gzxant.service.ICarExchangeInfoService;
import com.gzxant.service.IContractInfoService;

/**
 * 
 * @author ZCRong
 * Describe：车辆申请管理
 *
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class CarExchangeInfoService extends BaseService<CarExchangeInfoDao,CarExchangeInfo> implements ICarExchangeInfoService {

	@Autowired
    private IContractInfoService contractInfoService;
	
    /**
     * 查询车辆申请对象详情
     */
	@Override
	public CarExchangeInfo selectCarExchangeInfoAllInfoById(Long id) {
		return this.baseMapper.selectCarExchangeInfoById(id);
	}

	/**
	 * 查询所有车辆申请对象详情列表
	 * @return
	 */
	public List<CarExchangeInfo> selectAllCarExchangeInfoList(){
		return selectList(Condition.EMPTY);
	}	
	
	/**
	 * 创建车辆申请
	 */
    @Transactional(readOnly = false)
	@Override
	public boolean insertCarExchangeInfo(CarExchangeInfo carExchangeInfo) {
    	
    	
        //将合同设置为过期
        boolean updateContractGroupId = contractInfoService.updateContractGroupId("old",carExchangeInfo.getContractNoOld());
        if(!updateContractGroupId){
        	logger.error("修改合同为过期合同失败，合同编号为：{}",carExchangeInfo.getContractNoOld());
        	throw new SlifeException(HttpCodeEnum.INTERNAL_SERVER_ERROR);
        }
        //将新旧合同以及其以前涉及的合同，修改为同一groupID
        String contractNoOld = carExchangeInfo.getContractNoOld();
        //获取新合同的groupId
        ContractInfo contractInfoNew = contractInfoService.queryContractByContractNo(carExchangeInfo.getContractNoNew());
        String groupIdNew = contractInfoNew.getGroupId();
        //查询出当前合同编号下的合同总金额
        BigDecimal contractAmount = contractInfoNew.getContractAmount();
        carExchangeInfo.setContractAmount(contractAmount);
        //将旧合同以及其下的涉及的合同的groupId设置为新合同的groupId
        boolean setNewGroupId = contractInfoService.setNewGroupId(contractNoOld, groupIdNew);
        if(!setNewGroupId){
        	logger.error("给旧合同设置新的groupId失败，合同编号为：{}",carExchangeInfo.getContractNoOld());
        	throw new SlifeException(HttpCodeEnum.INTERNAL_SERVER_ERROR);
        }
		return insert(carExchangeInfo);

	}

	/**
	 * 更新车辆申请信息
	 */
    @Transactional(readOnly = false)
	@Override
	public boolean updateCarExchangeInfo(CarExchangeInfo CarExchangeInfoNew) {
		return updateById(CarExchangeInfoNew);
	}


}
