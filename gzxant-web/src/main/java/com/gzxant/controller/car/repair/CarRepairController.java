package com.gzxant.controller.car.repair;

import java.util.List;

import com.gzxant.constant.Global;
import com.gzxant.constant.SearchParam;
import com.gzxant.service.ICarService;
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
import com.gzxant.service.car.repair.ICarRepairService;
import com.gzxant.entity.car.repair.CarRepair;
import com.gzxant.util.ReturnDTOUtil;
import com.gzxant.base.controller.BaseController;

import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 车辆维修 前端控制器
 * </p>
 *
 * @author Fatal
 * @since 2018-07-30
 */
@Controller
@RequestMapping("/car/repair")
public class CarRepairController extends BaseController {

	@Autowired
	private ISysDictService sysDictService;

	@Autowired
	private ICarRepairService carRepairService;

	@Autowired
	private ISysCompanyService sysCompanyService;

	@Autowired
	private ICarService carService;

	private final String DEL_FLAG = "del_flag";

	@ApiOperation(value = "进入车辆维修列表界面", notes = "进入车辆维修列表界面")
	@GetMapping(value = "")
	public String list(Model model) {
		echo(model);
		return "/car/repair/list";
	}

	@ApiOperation(value = "进入车辆维修编辑界面", notes = "进入车辆维修编辑界面")
	@GetMapping(value = {"/{action}", "/{action}/{id}"})
	public String detail(@PathVariable("action") String action,
	                     @PathVariable(value = "id" ,required = false) String id,
	                     Model model) {
		model.addAttribute("action", action);
		echo(model);
		if (StringUtils.isNotBlank(id)) {
            model.addAttribute("entity", carRepairService.selectById(id));
		}

		return "/car/repair/insert";
	}

	@ApiOperation(value = "获取车辆维修列表数据", notes = "获取车辆维修列表数据:使用约定的DataTable")
	@PostMapping(value = "/list")
	@ResponseBody
	public DataTable<CarRepair> list(@RequestBody DataTable<CarRepair> dt) {
		dt.getSearchParams().put(SearchParam.SEARCH_EQ + DEL_FLAG, Global.DEL_FLAG_NORMAL);
		return carRepairService.pageSearch(dt);
	}

	@ApiOperation(value = "添加车辆维修", notes = "添加车辆维修")
	@PostMapping(value = "/insert")
	@ResponseBody
	public ReturnDTO insert(CarRepair param) {
		param.setBelongstoId(GzxantSysUser.companyId());
		carRepairService.insert(param);
		return ReturnDTOUtil.success();
	}

	@ApiOperation(value = "编辑车辆维修", notes = "编辑车辆维修")
	@PostMapping(value = "/update")
	@ResponseBody
	public ReturnDTO update(CarRepair param) {
		carRepairService.updateById(param);
		return ReturnDTOUtil.success();
	}

	@SLog("批量删除车辆维修")
	@ApiOperation(value = "批量删除车辆维修", notes = "批量删除车辆维修")
	@PostMapping(value = "/delete")
	@ResponseBody
	public ReturnDTO delete(@RequestParam("ids") List<Long> ids) {
		carRepairService.deleteAllIds(ids);
		return ReturnDTOUtil.success();
	}


	public void echo (Model model) {
		model.addAttribute("repairTypeList",sysDictService.getDictTree("MAINTENANCE_TYPE"));
		model.addAttribute("repairResultList",sysDictService.getDictTree("MAINTENANCE_RESULT"));
		model.addAttribute("carTypeList",sysDictService.getDictTree("CAR_TYPE"));
		model.addAttribute("companyList",sysCompanyService.selectList(null));
	}
}
