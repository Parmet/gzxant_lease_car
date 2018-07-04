package com.gzxant.controller.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gzxant.base.entity.ReturnDTO;
import com.gzxant.entity.Car;
import com.gzxant.service.ICarService;
import com.gzxant.util.ReturnDTOUtil;

import io.swagger.annotations.ApiOperation;

/**
 * Describe:汽车管理
 * @author ZCRONG
 *
 */
@Controller
@RequestMapping(value = "/car")
public class CarController {
	
    @Autowired
    private ICarService carService;
	
    /**
     * 创建汽车操作
     * @param car
     * @param roleIds
     * @return
     */
    @ApiOperation(value = "创建汽车操作", notes = "创建汽车操作")
    @PostMapping(value = "/insert")
    @ResponseBody
    public ReturnDTO list(Car car) {
    	carService.add(car);
        return ReturnDTOUtil.success();
    }
    
    
}
