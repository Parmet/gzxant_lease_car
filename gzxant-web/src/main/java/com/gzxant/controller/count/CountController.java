package com.gzxant.controller.count;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.gzxant.base.entity.ReturnDTO;
import com.gzxant.entity.insurance.InsuranceCondition;
import com.gzxant.service.accident.AccidentService;
import com.gzxant.service.car.accident.CarAccidentService;
import com.gzxant.service.car.accident.ICarAccidentService;
import com.gzxant.service.car.fault.ICarFaultService;
import com.gzxant.service.car.repair.ICarRepairService;
import com.gzxant.service.car.yearly.inspection.ICarYearlyInspectionService;
import com.gzxant.service.insurance.InsuranceService;
import com.gzxant.service.transgress.TransgressService;
import com.gzxant.service.violation.regulations.IViolationRegulationsService;
import com.gzxant.shiro.GzxantSysUser;
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
    private ICarAccidentService carAccidentService;

    @Autowired
    private IViolationRegulationsService regulationsService;

    @Autowired
    private ICarFaultService carFaultService;

    @Autowired
    private ICarRepairService carRepairService;

    @Autowired
    private ICarYearlyInspectionService inspectionService;

    /*@Autowired
    private ICarMaintainService carMaintainService;

    @Autowired
    private ICarInsuranceService carInsuranceService;*/

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    /**
     * 事故
     * @param beginDate
     * @param endDate
     * @return
     */
    @GetMapping(value = "/accident", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ReturnDTO countAccident(Date beginDate, Date endDate) {
        Wrapper wrapper = ininWrapper(beginDate, endDate);
        Integer selectCount = carAccidentService.selectCount(wrapper);
        return ReturnDTOUtil.success(selectCount);
    }

    /**
     * 保险
     * @param beginDate
     * @param endDate
     * @return
     */
    /*@GetMapping(value = "/insurance", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ReturnDTO countInsurance(Date beginDate, Date endDate) {
        Wrapper wrapper = ininWrapper(beginDate, endDate);
        Integer selectCount = carInsuranceService.selectCount(wrapper);
        return ReturnDTOUtil.success(selectCount);
    }*/

    /**
     * 保养
     * @param beginDate
     * @param endDate
     * @return
     */
    /*@GetMapping(value = "/maintain", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ReturnDTO countMaintain(Date beginDate, Date endDate) {
        Wrapper wrapper = ininWrapper(beginDate, endDate);
        Integer selectCount = carMaintainService.selectCount(wrapper);
        return ReturnDTOUtil.success(selectCount);
    }*/


    /**
     * 违章
     * @param beginDate
     * @param endDate
     * @return
     */
    @GetMapping(value = "/regulations", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ReturnDTO countRegulations(Date beginDate, Date endDate) {
        Wrapper wrapper = ininWrapper(beginDate, endDate);
        Integer selectCount = regulationsService.selectCount(wrapper);
        return ReturnDTOUtil.success(selectCount);
    }

    /**
     * 故障
     * @param beginDate
     * @param endDate
     * @return
     */
    @GetMapping(value = "/fault", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ReturnDTO countFault(Date beginDate, Date endDate) {
        Wrapper wrapper = ininWrapper(beginDate, endDate);
        Integer selectCount = carFaultService.selectCount(wrapper);
        return ReturnDTOUtil.success(selectCount);
    }

    /**
     * 维修
     * @param beginDate
     * @param endDate
     * @return
     */
    @GetMapping(value = "/repair", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ReturnDTO countepair(Date beginDate, Date endDate) {
        Wrapper wrapper = ininWrapper(beginDate, endDate);
        Integer selectCount = carRepairService.selectCount(wrapper);
        return ReturnDTOUtil.success(selectCount);
    }

    /**
     * 年检
     * @param beginDate
     * @param endDate
     * @return
     */
    @GetMapping(value = "/inspection", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ReturnDTO countInspection(Date beginDate, Date endDate) {
        Wrapper wrapper = ininWrapper(beginDate, endDate);
        Integer selectCount = inspectionService.selectCount(wrapper);
        return ReturnDTOUtil.success(selectCount);
    }




    /**
     * 初始化传条件
     * @param beginDate
     * @param endDate
     * @return
     */
    public Wrapper ininWrapper(Date beginDate, Date endDate) {
        Long id = GzxantSysUser.companyId();
        Wrapper wrapper = Condition.create().setSqlSelect("count(1)");
        if (id != null) {
            wrapper.eq("belongsto_id", id);
        }
        if (beginDate != null && endDate != null) {
            wrapper.between("create_date", beginDate, endDate);
        }
        return wrapper;
    }

}
