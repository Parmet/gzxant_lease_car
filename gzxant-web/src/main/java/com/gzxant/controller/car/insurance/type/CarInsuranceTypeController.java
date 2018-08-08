package com.gzxant.controller.car.insurance.type;

import java.util.List;
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
import com.gzxant.service.car.insurance.type.ICarInsuranceTypeService;
import com.gzxant.entity.car.insurance.type.CarInsuranceType;
import com.gzxant.util.ReturnDTOUtil;
import com.gzxant.base.controller.BaseController;

import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 保险种类 前端控制器
 * </p>
 *
 * @author ycxiao
 * @since 2018-07-30
 */
@Controller
@RequestMapping("/car/insurance/type")
public class CarInsuranceTypeController extends BaseController {
	@Autowired
	private ICarInsuranceTypeService carInsuranceTypeService;

	@ApiOperation(value = "进入保险种类列表界面", notes = "进入保险种类列表界面")
	@GetMapping(value = "")
	public String list(Model model) {
		return "/car/insurance/type/list";
	}

	@ApiOperation(value = "进入保险种类编辑界面", notes = "进入保险种类编辑界面")
	@GetMapping(value = {"/{action}", "/{action}/{id}"})
	public String detail(@PathVariable("action") String action,
	                     @PathVariable(value = "id" ,required = false) String id,
	                     Model model) {
		model.addAttribute("action", action);
		if (StringUtils.isNotBlank(id)) {
            model.addAttribute("entity", carInsuranceTypeService.selectById(id));
		}

		return "/car/insurance/type/" + action;
	}

	@ApiOperation(value = "获取保险种类列表数据", notes = "获取保险种类列表数据:使用约定的DataTable")
	@PostMapping(value = "/list")
	@ResponseBody
	public DataTable<CarInsuranceType> list(@RequestBody DataTable<CarInsuranceType> dt) {
		return carInsuranceTypeService.pageSearch(dt);
	}

	@ApiOperation(value = "添加保险种类", notes = "添加保险种类")
	@PostMapping(value = "/insert")
	@ResponseBody
	public ReturnDTO insert(CarInsuranceType param) {
		carInsuranceTypeService.insert(param);
		return ReturnDTOUtil.success();
	}

	@ApiOperation(value = "编辑保险种类", notes = "编辑保险种类")
	@PostMapping(value = "/update")
	@ResponseBody
	public ReturnDTO update(CarInsuranceType param) {
		carInsuranceTypeService.updateById(param);
		return ReturnDTOUtil.success();
	}

	@SLog("批量删除保险种类")
	@ApiOperation(value = "批量删除保险种类", notes = "批量删除保险种类")
	@PostMapping(value = "/delete")
	@ResponseBody
	public ReturnDTO delete(@RequestParam("ids") List<Long> ids) {
		boolean success = carInsuranceTypeService.deleteBatchIds(ids);
		if (success) {
			return ReturnDTOUtil.success();
		}
		return ReturnDTOUtil.fail();
	}
}
