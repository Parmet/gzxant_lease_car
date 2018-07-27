package com.gzxant.dao.insurance;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gzxant.dto.InsuranceEO;
import com.gzxant.entity.insurance.InsuranceFile;
import com.gzxant.entity.insurance.InsuranceInfo;
import com.gzxant.entity.insurance.InsuranceSpecies;
import com.gzxant.vo.InsuranceVo;

public interface InsuranceInfoDao {
	List<InsuranceVo> queryInsuranceListPage(InsuranceEO insuranceEO);
	
	Long queryInsuranceListPageTotal(InsuranceEO insuranceEO);
	
	InsuranceVo queryInsuranceInfo(@Param("code")String code);
	
	List<InsuranceSpecies> queryInsuranceSpecies(@Param("code")String code);
	
	List<InsuranceFile> queryInsuranceFile(@Param("code")String code);
	
	int insertInsuranceInfo(InsuranceInfo info);
	
	int insertInsuranceSpecies(InsuranceSpecies species);
	
	int insertInsuranceFile(InsuranceFile file);
	
	int updateInsuranceInfo(InsuranceInfo info);
	
	int deleteInsuranceInfo(@Param("code")String code);
	
	int deleteInsuranceSpecies(@Param("code")String code);
	
	int deleteInsuranceFile(@Param("code")String code);
}
