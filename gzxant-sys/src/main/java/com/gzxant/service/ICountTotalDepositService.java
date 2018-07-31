package com.gzxant.service;

import java.math.BigDecimal;

public interface ICountTotalDepositService {
	
	BigDecimal getCarRentalTotalDeposit(Long companyId,String beginDate,String endDate);
	
	BigDecimal getViolationTotalDeposit(Long companyId,String beginDate,String endDate);
}
