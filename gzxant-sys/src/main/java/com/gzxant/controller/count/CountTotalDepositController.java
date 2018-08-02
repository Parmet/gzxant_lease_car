package com.gzxant.controller.count;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gzxant.annotation.SLog;
import com.gzxant.service.ICountTotalDepositService;
import com.gzxant.shiro.GzxantSysUser;

import io.swagger.annotations.ApiOperation;

/**
 * 计算车辆的数量
 * @author ZCRong
 *
 */
@Controller
@RequestMapping(value = "/numCount/manager")
public class CountTotalDepositController {
	
	@Autowired
	ICountTotalDepositService countTotalDepositService;
    
    /**
     * 计算租车押金
     */
    @SLog("计算租车押金")
    @ApiOperation(value = "计算租车押金", notes = "计算租车押金")
    @GetMapping(value = "/getCarRentalTotalDeposit")
    @ResponseBody
    public BigDecimal getCarRentalTotalDeposit(String beginDate,String endDate){
    	Long companyId = GzxantSysUser.companyId();
    	BigDecimal carRentalTotalDeposit = countTotalDepositService.getCarRentalTotalDeposit(companyId, beginDate, endDate);
    	return carRentalTotalDeposit;
    }
    
    /**
     * 计算违章押金
     */
    @SLog("计算违章押金")
    @ApiOperation(value = "计算违章押金", notes = "计算违章押金")
    @GetMapping(value = "/getViolationTotalDeposit")
    @ResponseBody
    public BigDecimal getViolationTotalDeposit(String beginDate,String endDate){
    	Long companyId = GzxantSysUser.companyId();
    	BigDecimal violationTotalDeposit = countTotalDepositService.getViolationTotalDeposit(companyId, beginDate, endDate);
    	return violationTotalDeposit;
    }
    
}
