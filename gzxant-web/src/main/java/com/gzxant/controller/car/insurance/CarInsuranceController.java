package com.gzxant.controller.car.insurance;

import java.util.List;

import com.baomidou.mybatisplus.mapper.Condition;
import com.gzxant.dto.CarInsuranceDTO;
import com.gzxant.entity.car.insurance.type.CarInsuranceType;
import com.gzxant.service.ISysCompanyService;
import com.gzxant.service.ISysDictService;
import com.gzxant.service.car.insurance.type.ICarInsuranceTypeService;
import com.gzxant.shiro.GzxantSysUser;
import com.gzxant.util.data.JsonUtil;
import org.apache.commons.lang3.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gzxant.annotation.SLog;
import com.gzxant.base.entity.ReturnDTO;
import com.gzxant.base.vo.DataTable;
import com.gzxant.service.car.insurance.ICarInsuranceService;
import com.gzxant.entity.car.insurance.CarInsurance;
import com.gzxant.util.ReturnDTOUtil;
import com.gzxant.base.controller.BaseController;

import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 车辆保险 前端控制器
 * </p>
 *
 * @author ycxiao
 * @since 2018-07-30
 */
@Controller
@RequestMapping("/car/insurance")
public class CarInsuranceController extends BaseController {
	@Autowired
	private ICarInsuranceService carInsuranceService;

	@Autowired
	private ICarInsuranceTypeService carInsuranceTypeService;

	@Autowired
	private ISysDictService sysDictService;

	@Autowired
	private ISysCompanyService sysCompanyService;

	@ApiOperation(value = "进入车辆保险列表界面", notes = "进入车辆保险列表界面")
	@GetMapping(value = "")
	public String list(Model model) {
		setInsuranceModel(model);
		return "/car/insurance/list";
	}

	@ApiOperation(value = "进入车辆保险编辑界面", notes = "进入车辆保险编辑界面")
	@GetMapping(value = {"/{action}", "/{action}/{id}"})
	public String detail(@PathVariable("action") String action,
	                     @PathVariable(value = "id" ,required = false) String id,
	                     Model model) {
		setInsuranceModel(model);
		model.addAttribute("action", action);
		if (StringUtils.isNotBlank(id)) {
            model.addAttribute("entity", carInsuranceService.selectById(id));
			model.addAttribute("types", carInsuranceTypeService
					.selectList(Condition.create().eq("car_insurance_id", id)));
		}

		return "/car/insurance/" + action;
	}

	@ApiOperation(value = "获取车辆保险列表数据", notes = "获取车辆保险列表数据:使用约定的DataTable")
	@PostMapping(value = "/list")
	@ResponseBody
	public DataTable<CarInsurance> list(@RequestBody DataTable<CarInsurance> dt) {
		return carInsuranceService.pageSearch(dt);
	}

	@ApiOperation(value = "添加车辆保险", notes = "添加车辆保险")
	@PostMapping(value = "/insert")
	@ResponseBody
	public ReturnDTO insert(String data) {
		CarInsuranceDTO param = JsonUtil.toBean(data, CarInsuranceDTO.class);
		param.getInfo().setBelongstoId(GzxantSysUser.companyId());
		carInsuranceService.insert(param.getInfo());

		if (param.getTypes().size() > 0
				&& StringUtils.isNotBlank(param.getTypes().get(0).getTerm())) {
			for (CarInsuranceType type: param.getTypes()) {
				type.setCarInsuranceId(param.getInfo().getId());
			}

			carInsuranceTypeService.insertBatch(param.getTypes());
		}
		return ReturnDTOUtil.success();
	}

	@ApiOperation(value = "编辑车辆保险", notes = "编辑车辆保险")
	@PostMapping(value = "/update")
	@ResponseBody
	public ReturnDTO update(String data) {
		CarInsuranceDTO param = JsonUtil.toBean(data, CarInsuranceDTO.class);
		param.getInfo().setBelongstoId(GzxantSysUser.companyId());
		carInsuranceService.updateById(param.getInfo());

		carInsuranceTypeService.delete(Condition.create()
				.eq("car_insurance_id", param.getInfo().getId()));
		if (param.getTypes().size() > 0
				&& StringUtils.isNotBlank(param.getTypes().get(0).getTerm())) {
			for (CarInsuranceType type : param.getTypes()) {
				type.setCarInsuranceId(param.getInfo().getId());
			}

			carInsuranceTypeService.insertBatch(param.getTypes());
		}
		return ReturnDTOUtil.success();
	}

	@SLog("批量删除车辆保险")
	@ApiOperation(value = "批量删除车辆保险", notes = "批量删除车辆保险")
	@PostMapping(value = "/delete")
	@ResponseBody
	public ReturnDTO delete(@RequestParam("ids") List<Long> ids) {
		boolean success = carInsuranceService.deleteBatchIds(ids);
		carInsuranceTypeService.delete(Condition.create()
				.in("car_insurance_id", ids));

		if (success) {
			return ReturnDTOUtil.success();
		}
		return ReturnDTOUtil.fail();
	}

	/**
	 * 下拉框需要的数据
	 * @param model
	 */
	private void setInsuranceModel(Model model) {
		setBaseModel(model);
		model.addAttribute("insuranceTypeDict", sysDictService.getDictTree("INSURANCE_TYPE"));
		model.addAttribute("insuranceCompanyDict", sysDictService.getDictTree("INSURANCE_COMPANY"));
		model.addAttribute("insuranceStatusDict", sysDictService.getDictTree("INSURANCE_STATUS"));
	}

	/**
	 * 下拉框需要的数据
	 * @param model
	 */
	private void setBaseModel(Model model) {
		model.addAttribute("carTypeDict", sysDictService.getDictTree("CAR_TYPE"));
		model.addAttribute("companyList", sysCompanyService.selectList(null));
	}
}
