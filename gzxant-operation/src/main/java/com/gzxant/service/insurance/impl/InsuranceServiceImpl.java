package com.gzxant.service.insurance.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.dao.insurance.InsuranceInfoDao;
import com.gzxant.dto.InsuranceEO;
import com.gzxant.dto.PageBean;
import com.gzxant.entity.insurance.InsuranceFile;
import com.gzxant.entity.insurance.InsuranceInfo;
import com.gzxant.entity.insurance.InsuranceSpecies;
import com.gzxant.service.insurance.InsuranceService;
import com.gzxant.utils.UniqueNoUtils;
import com.gzxant.vo.InsuranceVo;

@Service
public class InsuranceServiceImpl implements InsuranceService{
	
	@Autowired
	private InsuranceInfoDao insuranceInfoDao;

	@Override
	public PageBean<InsuranceVo> queryInsuranceListPage(InsuranceEO insuranceEO) {
		List<InsuranceVo> list = insuranceInfoDao.queryInsuranceListPage(insuranceEO);
		return new PageBean<>(list, insuranceInfoDao.queryInsuranceListPageTotal(insuranceEO), insuranceEO.getPageSize(), insuranceEO.getPageNo());
	}

	@Override
	public InsuranceVo queryInsuranceInfo(String code) {
		return insuranceInfoDao.queryInsuranceInfo(code);
	}

	@Override
	public List<InsuranceSpecies> queryInsuranceSpecies(String code) {
		return insuranceInfoDao.queryInsuranceSpecies(code);
	}

	@Override
	public List<InsuranceFile> queryInsuranceFile(String code) {
		return insuranceInfoDao.queryInsuranceFile(code);
	}

	@Override
	public String addInsuranceInfo(InsuranceInfo info) {
		String code = UniqueNoUtils.next();
		info.setCode(code);
		info.setCreateTime(new Date());
		insuranceInfoDao.insertInsuranceInfo(info);
		return code;
	}

	@Override
	@Transactional
	public void addInsuranceSpecies(String code, List<InsuranceSpecies> speciesList) {
		for (InsuranceSpecies species : speciesList){
			species.setCode(code);
			species.setCreateTime(new Date());
			insuranceInfoDao.insertInsuranceSpecies(species);
		}
	}

	@Override
	@Transactional
	public void addInsuranceFile(List<InsuranceFile> fileList) {
		for (InsuranceFile file : fileList){
			insuranceInfoDao.insertInsuranceFile(file);
		}
	}

	@Override
	public void modifyInsuranceInfo(InsuranceInfo info) {
		insuranceInfoDao.updateInsuranceInfo(info);
	}

	@Override
	@Transactional
	public void modifyInsuranceSpecies(String code, List<InsuranceSpecies> speciesList) {
		insuranceInfoDao.deleteInsuranceSpecies(code);
		for (InsuranceSpecies species : speciesList){
			species.setCode(code);
			species.setCreateTime(new Date());
			insuranceInfoDao.insertInsuranceSpecies(species);
		} 
	}

	@Override
	@Transactional
	public void modifyInsuranceFile(String code, List<InsuranceFile> fileList) {
		insuranceInfoDao.deleteInsuranceFile(code);
		for (InsuranceFile file : fileList){
			file.setCode(code);
			insuranceInfoDao.insertInsuranceFile(file);
		}
	}

	@Override
	@Transactional
	public void deleteInsurance(String code) {
		insuranceInfoDao.deleteInsuranceInfo(code);
		insuranceInfoDao.deleteInsuranceSpecies(code);
		insuranceInfoDao.deleteInsuranceFile(code);
	}

}
