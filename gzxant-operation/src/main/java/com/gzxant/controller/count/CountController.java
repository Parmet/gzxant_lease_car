package com.gzxant.controller.count;

import com.gzxant.base.entity.ReturnDTO;
import com.gzxant.entity.insurance.InsuranceCondition;
import com.gzxant.service.accident.AccidentService;
import com.gzxant.service.insurance.InsuranceService;
import com.gzxant.service.transgress.TransgressService;
import com.gzxant.shiro.GzxantSysUser;
import com.gzxant.util.DateUtils;
import com.gzxant.util.ReturnDTOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 统计接口
 * @author: Fatal
 * @date: 2018/7/29 0029 15:54
 */
@Controller
@RequestMapping("/count")
public class CountController {

    @Autowired
    private AccidentService accidentService;

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private TransgressService transgressService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @GetMapping(value = "/accident", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ReturnDTO countAccident(Date beginDate, Date endDate) {
        Long id = GzxantSysUser.companyId();
        /*//测试数据
        String begin = "2018-07-05";
        String end = "2018-07-30";
        beginDate = DateUtils.convertStrToDate(begin);
        endDate = DateUtils.convertStrToDate(end);*/
        Integer count = accidentService.count(id,beginDate,endDate);
        return ReturnDTOUtil.success(count);
    }

    @GetMapping(value = "/insurance", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ReturnDTO countInsurance(Date beginDate, Date endDate) {
        Long id = GzxantSysUser.companyId();
        /*//测试数据
        id = 132L;
        String begin = "2018-07-05";
        String end = "2018-07-30";
        beginDate = DateUtils.convertStrToDate(begin);
        endDate = DateUtils.convertStrToDate(end);*/
        InsuranceCondition condition = new InsuranceCondition(id,beginDate,endDate);
        Integer count = insuranceService.count(condition);
        return ReturnDTOUtil.success(count);
    }

    @GetMapping(value = "/transgress", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ReturnDTO countTransgress(Date beginDate, Date endDate) {
        Long id = GzxantSysUser.companyId();
        /*//测试数据
        id = 123L;
        String begin = "2018-07-05";
        String end = "2018-07-30";
        beginDate = DateUtils.convertStrToDate(begin);
        endDate = DateUtils.convertStrToDate(end);*/
        Integer count = transgressService.count(id,beginDate,endDate);
        return ReturnDTOUtil.success(count);
    }



}
