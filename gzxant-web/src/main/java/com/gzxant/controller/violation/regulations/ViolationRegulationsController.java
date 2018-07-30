package com.gzxant.controller.violation.regulations;

import java.util.List;

import com.gzxant.constant.Global;
import com.gzxant.constant.SearchParam;
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
import com.gzxant.service.violation.regulations.IViolationRegulationsService;
import com.gzxant.entity.violation.regulations.ViolationRegulations;
import com.gzxant.util.ReturnDTOUtil;
import com.gzxant.base.controller.BaseController;

import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 违章 前端控制器
 * </p>
 *
 * @author Fatal
 * @since 2018-07-30
 */
@Controller
@RequestMapping("/violation/regulations")
public class ViolationRegulationsController extends BaseController {

	@Autowired
	private ISysDictService sysDictService;

	@Autowired
	private ISysCompanyService sysCompanyService;

	@Autowired
	private IViolationRegulationsService violationRegulationsService;

	private final String DEL_FLAG = "del_flag";

	@ApiOperation(value = "进入违章列表界面", notes = "进入违章列表界面")
	@GetMapping(value = "")
	public String list(Model model) {
		echo(model);
		return "/violation/regulations/list";
	}

	@ApiOperation(value = "进入违章编辑界面", notes = "进入违章编辑界面")
	@GetMapping(value = {"/{action}", "/{action}/{id}"})
	public String detail(@PathVariable("action") String action,
	                     @PathVariable(value = "id" ,required = false) String id,
	                     Model model) {
		model.addAttribute("action", action);
		echo(model);
		if (StringUtils.isNotBlank(id)) {
            model.addAttribute("entity", violationRegulationsService.selectById(id));
		}
		return "/violation/regulations/insert";
	}

	@ApiOperation(value = "获取违章列表数据", notes = "获取违章列表数据:使用约定的DataTable")
	@PostMapping(value = "/list")
	@ResponseBody
	public DataTable<ViolationRegulations> list(@RequestBody DataTable<ViolationRegulations> dt) {
		dt.getSearchParams().put(SearchParam.SEARCH_EQ + DEL_FLAG, Global.DEL_FLAG_NORMAL);
		return violationRegulationsService.pageSearch(dt);
	}

	@ApiOperation(value = "添加违章", notes = "添加违章")
	@PostMapping(value = "/insert")
	@ResponseBody
	public ReturnDTO insert(ViolationRegulations param) {
		param.setBelongstoId(GzxantSysUser.companyId());
		violationRegulationsService.insert(param);
		return ReturnDTOUtil.success();
	}

	@ApiOperation(value = "编辑违章", notes = "编辑违章")
	@PostMapping(value = "/update")
	@ResponseBody
	public ReturnDTO update(ViolationRegulations param) {
		violationRegulationsService.updateById(param);
		return ReturnDTOUtil.success();
	}

	@SLog("批量删除违章")
	@ApiOperation(value = "批量删除违章", notes = "批量删除违章")
	@PostMapping(value = "/delete")
	@ResponseBody
	public ReturnDTO delete(@RequestParam("ids") List<Long> ids) {
		violationRegulationsService.deleteAllIds(ids);
		return ReturnDTOUtil.success();
	}

	public void echo(Model model) {
		model.addAttribute("statusList",sysDictService.getDictTree("VIOLATION_REGULATIONS_STATUS"));
		model.addAttribute("companyList",sysCompanyService.selectList(null));
		model.addAttribute("isList",sysDictService.getDictTree("IS_REPRESENTATIVE"));
		model.addAttribute("carTypeList", sysDictService.getDictTree("CAR_TYPE"));
	}
}
