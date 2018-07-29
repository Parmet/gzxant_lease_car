package com.gzxant.service.insurance;

import java.util.List;

import com.gzxant.dto.InsuranceEO;
import com.gzxant.dto.PageBean;
import com.gzxant.entity.insurance.InsuranceFile;
import com.gzxant.entity.insurance.InsuranceInfo;
import com.gzxant.entity.insurance.InsuranceSpecies;
import com.gzxant.vo.InsuranceVo;

public interface InsuranceService {
	public PageBean<InsuranceVo> queryInsuranceListPage(InsuranceEO insuranceEO);
	
	InsuranceVo queryInsuranceInfo(String code);
	
	List<InsuranceSpecies> queryInsuranceSpecies(String code);
	
	List<InsuranceFile> queryInsuranceFile(String code);
	
	String addInsuranceInfo(InsuranceInfo info);
	
	void addInsuranceSpecies(String code, List<InsuranceSpecies> speciesList);
	
	void addInsuranceFile(List<InsuranceFile> fileList);
	
	void modifyInsuranceInfo(InsuranceInfo info);
	
	void modifyInsuranceSpecies(String code, List<InsuranceSpecies> speciesList);
	
	void modifyInsuranceFile(String code, List<InsuranceFile> fileList);
	
	void deleteInsurance(String code);
	
	List<InsuranceVo> queryInsuranceList(InsuranceEO insuranceEO);
}
