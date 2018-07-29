package com.gzxant.controller.car.accident;

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
import com.gzxant.service.car.accident.ICarAccidentService;
import com.gzxant.entity.car.accident.CarAccident;
import com.gzxant.util.ReturnDTOUtil;
import com.gzxant.base.controller.BaseController;

import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 事故 前端控制器
 * </p>
 *
 * @author ycxiao
 * @since 2018-07-29
 */
@Controller
@RequestMapping("/car/accident")
public class CarAccidentController extends BaseController {
	@Autowired
	private ICarAccidentService carAccidentService;

	@ApiOperation(value = "进入事故列表界面", notes = "进入事故列表界面")
	@GetMapping(value = "")
	public String list(Model model) {
		return "/car/accident/list";
	}

	@ApiOperation(value = "进入事故编辑界面", notes = "进入事故编辑界面")
	@GetMapping(value = {"/{action}", "/{action}/{id}"})
	public String detail(@PathVariable("action") String action,
	                     @PathVariable(value = "id" ,required = false) String id,
	                     Model model) {
		model.addAttribute("action", action);
		if (StringUtils.isNotBlank(id)) {
            model.addAttribute("entity", carAccidentService.selectById(id));
		}

		return "/car/accident/" + action;
	}

	@ApiOperation(value = "获取事故列表数据", notes = "获取事故列表数据:使用约定的DataTable")
	@PostMapping(value = "/list")
	@ResponseBody
	public DataTable<CarAccident> list(@RequestBody DataTable<CarAccident> dt) {
		return carAccidentService.pageSearch(dt);
	}

	@ApiOperation(value = "添加事故", notes = "添加事故")
	@PostMapping(value = "/insert")
	@ResponseBody
	public ReturnDTO create(CarAccident param) {
		carAccidentService.insert(param);
		return ReturnDTOUtil.success();
	}

	@ApiOperation(value = "编辑事故", notes = "编辑事故")
	@PostMapping(value = "/update")
	@ResponseBody
	public ReturnDTO update(CarAccident param) {
		carAccidentService.updateById(param);
		return ReturnDTOUtil.success();
	}

	@SLog("批量删除事故")
	@ApiOperation(value = "批量删除事故", notes = "批量删除事故")
	@PostMapping(value = "/delete")
	@ResponseBody
	public ReturnDTO delete(@RequestParam("ids") List<Long> ids) {
		boolean success = carAccidentService.deleteBatchIds(ids);
		if (success) {
			return ReturnDTOUtil.success();
		}
		return ReturnDTOUtil.fail();
	}
}
