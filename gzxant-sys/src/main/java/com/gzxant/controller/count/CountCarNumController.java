package com.gzxant.controller.count;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gzxant.annotation.SLog;
import com.gzxant.service.ICountCarNumService;
import com.gzxant.shiro.GzxantSysUser;

import io.swagger.annotations.ApiOperation;

/**
 * 计算车辆的数量
 * @author ZCRong
 *
 */
@Controller
@RequestMapping(value = "/numCount/manager")
public class CountCarNumController {  
	
	@Autowired
	ICountCarNumService carNumCountService;
	
	/**
	 * 计算车辆的一定时间内所有数量（总的/公司）
	 */
    @SLog("计算车辆的数量")
    @ApiOperation(value = "计算车辆的一定时间内所有数量（总的/公司）", notes = "计算车辆的一定时间内所有数量（总的/公司）")
    @GetMapping(value = "/getCarNumCount")
    @ResponseBody
	public Integer getCarNumCount(String beginDate,String endDate){
		Long companyId = GzxantSysUser.companyId();
		Integer carNumCount = carNumCountService.getCarNumCount(companyId, beginDate, endDate);
		return carNumCount;
	}
    
}
