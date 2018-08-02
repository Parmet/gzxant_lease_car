package com.gzxant.controller.car.maintain;

import java.util.List;

import com.gzxant.service.ISysCompanyService;
import com.gzxant.service.ISysDictService;
import com.gzxant.shiro.GzxantSysUser;
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
import com.gzxant.service.car.maintain.ICarMaintainService;
import com.gzxant.entity.car.maintain.CarMaintain;
import com.gzxant.util.ReturnDTOUtil;
import com.gzxant.base.controller.BaseController;

import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 车辆保养 前端控制器
 * </p>
 *
 * @author ycxiao
 * @since 2018-07-29
 */
@Controller
@RequestMapping("/car/maintain")
public class CarMaintainController extends BaseController {
	@Autowired
	private ICarMaintainService carMaintainService;

	@Autowired
	private ISysDictService sysDictService;

	@Autowired
	private ISysCompanyService sysCompanyService;

	@ApiOperation(value = "进入车辆保养列表界面", notes = "进入车辆保养列表界面")
	@GetMapping(value = "")
	public String list(Model model) {
		setMaintainModel(model);
		return "/car/maintain/list";
	}

	@ApiOperation(value = "进入车辆保养编辑界面", notes = "进入车辆保养编辑界面")
	@GetMapping(value = {"/{action}", "/{action}/{id}"})
	public String detail(@PathVariable("action") String action,
	                     @PathVariable(value = "id" ,required = false) String id,
	                     Model model) {
		model.addAttribute("action", action);
		if (StringUtils.isNotBlank(id)) {
            model.addAttribute("entity", carMaintainService.selectById(id));
		}

		setMaintainModel(model);
		return "/car/maintain/" + action;
	}

	@ApiOperation(value = "获取车辆保养列表数据", notes = "获取车辆保养列表数据:使用约定的DataTable")
	@PostMapping(value = "/list")
	@ResponseBody
	public DataTable<CarMaintain> list(@RequestBody DataTable<CarMaintain> dt) {
		return carMaintainService.pageSearch(dt);
	}

	@ApiOperation(value = "添加车辆保养", notes = "添加车辆保养")
	@PostMapping(value = "/insert")
	@ResponseBody
	public ReturnDTO insert(CarMaintain param) {
		param.setBelongstoId(GzxantSysUser.companyId());
		carMaintainService.insert(param);
		return ReturnDTOUtil.success();
	}

	@ApiOperation(value = "编辑车辆保养", notes = "编辑车辆保养")
	@PostMapping(value = "/update")
	@ResponseBody
	public ReturnDTO update(CarMaintain param) {
		carMaintainService.updateById(param);
		return ReturnDTOUtil.success();
	}

	@SLog("批量删除车辆保养")
	@ApiOperation(value = "批量删除车辆保养", notes = "批量删除车辆保养")
	@PostMapping(value = "/delete")
	@ResponseBody
	public ReturnDTO delete(@RequestParam("ids") List<Long> ids) {
		boolean success = carMaintainService.deleteBatchIds(ids);
		if (success) {
			return ReturnDTOUtil.success();
		}
		return ReturnDTOUtil.fail();
	}

	/**
	 * 下拉框需要的数据
	 * @param model
	 */
	private void setMaintainModel(Model model) {
		setBaseModel(model);
		model.addAttribute("levelDict", sysDictService.getDictTree("MAINTAIN_LEVEL"));
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
