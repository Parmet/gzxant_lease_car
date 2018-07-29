package com.gzxant.controller.server;

import com.gzxant.base.controller.BaseController;
import com.gzxant.entity.Car;
import com.gzxant.service.ISysCompanyService;
import com.gzxant.service.ISysDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 标准分类表 前端控制器
 * </p>
 *
 * @author ycxiao
 * @since 2018-05-17
 */
@Controller
@RequestMapping("/car/server/")
public class CarServerController extends BaseController {

	@Autowired
	private ISysDictService sysDictService;

	@Autowired
	private ISysCompanyService sysCompanyService;

	@GetMapping(value = {"/{type}/{action}", "/{type}/{action}/{id}"})
	public String toDetail(@PathVariable("type") String type,
						   @PathVariable("action") String action,
						   @PathVariable(value = "id", required = false) String id,
						   Model model) {
		setListModel(model);
		model.addAttribute("action", action);
		model.addAttribute("id", id);
		return "server/" + type + "/" + action;
	}

	/**
	 * 下拉框需要的数据
	 * @param model
	 */
	private void setListModel(Model model) {
		setBaseModel(model);
	}

	/**
	 * 下拉框需要的数据
	 * @param model
	 */
	private void setBaseModel(Model model) {
		model.addAttribute("carTypeDict", sysDictService.getDictTree("CAR_TYPE"));
		model.addAttribute("levelDict", sysDictService.getDictTree("ACCIDENT_LEVEL"));
		model.addAttribute("statusDict", sysDictService.getDictTree("ACCIDENT_DEAL_STATUS"));
		model.addAttribute("operNatureDict", sysDictService.getDictTree("ACCIDENT_OPER_NATURE"));
		model.addAttribute("useNatureDict", sysDictService.getDictTree("ACCIDENT_USE_NATURE"));
		model.addAttribute("responsibilityDivideDict", sysDictService.getDictTree("ACCIDENT_RESPONSIBILITY_DIVIDE"));
		model.addAttribute("scheduleDict", sysDictService.getDictTree("ACCIDENT_SCHEDULE"));
		model.addAttribute("companyList", sysCompanyService.selectList(null));
	}
}
