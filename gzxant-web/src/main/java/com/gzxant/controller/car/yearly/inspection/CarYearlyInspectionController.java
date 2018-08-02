package com.gzxant.controller.car.yearly.inspection;

import java.util.List;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.gzxant.constant.Global;
import com.gzxant.constant.SearchParam;
import com.gzxant.entity.Car;
import com.gzxant.entity.SysCompany;
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
import com.gzxant.service.car.yearly.inspection.ICarYearlyInspectionService;
import com.gzxant.entity.car.yearly.inspection.CarYearlyInspection;
import com.gzxant.util.ReturnDTOUtil;
import com.gzxant.base.controller.BaseController;

import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 年检 前端控制器
 * </p>
 *
 * @author Fatal
 * @since 2018-07-30
 */
@Controller
@RequestMapping("/car/yearly/inspection")
public class CarYearlyInspectionController extends BaseController {

	@Autowired
	private ISysDictService sysDictService;

	@Autowired
	private ISysCompanyService sysCompanyService;

	@Autowired
	private ICarService carService;

	@Autowired
	private ICarYearlyInspectionService carYearlyInspectionService;

	private final String DEL_FLAG = "del_flag";

	@ApiOperation(value = "进入年检列表界面", notes = "进入年检列表界面")
	@GetMapping(value = "")
	public String list(Model model) {
		echo(model);
		return "/car/yearly/inspection/list";
	}

	@ApiOperation(value = "进入年检编辑界面", notes = "进入年检编辑界面")
	@GetMapping(value = {"/{action}", "/{action}/{id}"})
	public String detail(@PathVariable("action") String action,
	                     @PathVariable(value = "id" ,required = false) String id,
	                     Model model) {
		model.addAttribute("action", action);
		echo(model);
		if (StringUtils.isNotBlank(id)) {
            model.addAttribute("entity", carYearlyInspectionService.selectById(id));
		}

		return "/car/yearly/inspection/" + action;
	}

	@ApiOperation(value = "获取年检列表数据", notes = "获取年检列表数据:使用约定的DataTable")
	@PostMapping(value = "/list")
	@ResponseBody
	public DataTable<CarYearlyInspection> list(@RequestBody DataTable<CarYearlyInspection> dt) {
		dt.getSearchParams().put(SearchParam.SEARCH_EQ + DEL_FLAG, Global.DEL_FLAG_NORMAL);
		return carYearlyInspectionService.pageSearch(dt);
	}

	@ApiOperation(value = "添加年检", notes = "添加年检")
	@PostMapping(value = "/insert")
	@ResponseBody
	public ReturnDTO insert(CarYearlyInspection param) {
		editInit(param);
		carYearlyInspectionService.insert(param);
		return ReturnDTOUtil.success();
	}

	@ApiOperation(value = "编辑年检", notes = "编辑年检")
	@PostMapping(value = "/update")
	@ResponseBody
	public ReturnDTO update(CarYearlyInspection param) {
		editInit(param);
		carYearlyInspectionService.updateById(param);
		return ReturnDTOUtil.success();
	}

	@SLog("批量删除年检")
	@ApiOperation(value = "批量删除年检", notes = "批量删除年检")
	@PostMapping(value = "/delete")
	@ResponseBody
	public ReturnDTO delete(@RequestParam("ids") List<Long> ids) {
		carYearlyInspectionService.deleteAllIds(ids);
		return ReturnDTOUtil.success();
	}

	private void echo(Model model) {
		//年检结果
		model.addAttribute("resultList", sysDictService.getDictTree("RESULTS_OF_ANNUAL_INSPECTION"));
		//所属组织
		model.addAttribute("companyList", sysCompanyService.selectList(null));
		//车辆类型
		model.addAttribute("carTypeList", sysDictService.getDictTree("CAR_TYPE"));
	}

	public void editInit(CarYearlyInspection param) {
		EntityWrapper<Car> ew = new EntityWrapper<>();
		ew.where("car_number={0}", param.getCarNumber());
		Car car = carService.selectOne(ew);
		if (car != null) {
			param.setCarType(car.getVehicleType());
			param.setFrameNumber(car.getFrameNumber());
		}
		param.setBelongstoId(GzxantSysUser.companyId());
	}
}
