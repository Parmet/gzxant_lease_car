package com.gzxant.controller.car.fault;

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
import com.gzxant.service.car.fault.ICarFaultService;
import com.gzxant.entity.car.fault.CarFault;
import com.gzxant.util.ReturnDTOUtil;
import com.gzxant.base.controller.BaseController;

import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 故障 前端控制器
 * </p>
 *
 * @author ycxiao
 * @since 2018-07-30
 */
@Controller
@RequestMapping("/car/fault")
public class CarFaultController extends BaseController {
	@Autowired
	private ICarFaultService carFaultService;

	@Autowired
	private ISysDictService sysDictService;

	@Autowired
	private ISysCompanyService sysCompanyService;

	@ApiOperation(value = "进入故障列表界面", notes = "进入故障列表界面")
	@GetMapping(value = "")
	public String list(Model model) {
		setMaintainModel(model);
		return "/car/fault/list";
	}

	@ApiOperation(value = "进入故障编辑界面", notes = "进入故障编辑界面")
	@GetMapping(value = {"/{action}", "/{action}/{id}"})
	public String detail(@PathVariable("action") String action,
	                     @PathVariable(value = "id" ,required = false) String id,
	                     Model model) {
		setMaintainModel(model);
		model.addAttribute("action", action);
		if (StringUtils.isNotBlank(id)) {
            model.addAttribute("entity", carFaultService.selectById(id));
		}

		return "/car/fault/" + action;
	}

	@ApiOperation(value = "获取故障列表数据", notes = "获取故障列表数据:使用约定的DataTable")
	@PostMapping(value = "/list")
	@ResponseBody
	public DataTable<CarFault> list(@RequestBody DataTable<CarFault> dt) {
		return carFaultService.pageSearch(dt);
	}

	@ApiOperation(value = "添加故障", notes = "添加故障")
	@PostMapping(value = "/insert")
	@ResponseBody
	public ReturnDTO insert(CarFault param) {
		param.setBelongstoId(GzxantSysUser.companyId());
		carFaultService.insert(param);
		return ReturnDTOUtil.success();
	}

	@ApiOperation(value = "编辑故障", notes = "编辑故障")
	@PostMapping(value = "/update")
	@ResponseBody
	public ReturnDTO update(CarFault param) {
		carFaultService.updateById(param);
		return ReturnDTOUtil.success();
	}

	@SLog("批量删除故障")
	@ApiOperation(value = "批量删除故障", notes = "批量删除故障")
	@PostMapping(value = "/delete")
	@ResponseBody
	public ReturnDTO delete(@RequestParam("ids") List<Long> ids) {
		boolean success = carFaultService.deleteBatchIds(ids);
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
