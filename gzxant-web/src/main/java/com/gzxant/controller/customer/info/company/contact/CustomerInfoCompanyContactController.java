package com.gzxant.controller.customer.info.company.contact;

import java.util.List;

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
import com.gzxant.service.customer.info.company.contact.ICustomerInfoCompanyContactService;
import com.gzxant.entity.customer.info.company.contact.CustomerInfoCompanyContact;
import com.gzxant.util.ReturnDTOUtil;
import com.gzxant.base.controller.BaseController;

import io.swagger.annotations.ApiOperation;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tecty
 * @since 2018-07-05
 */
@Controller
@RequestMapping("/customer/info/company/contact")
public class CustomerInfoCompanyContactController extends BaseController {
	@Autowired
	private ICustomerInfoCompanyContactService customerInfoCompanyContactService;

	@ApiOperation(value = "进入列表界面", notes = "进入列表界面")
	@GetMapping(value = "")
	public String list(Model model) {
		return "/customer/info/company/contact/list.ftl";
	}

	@ApiOperation(value = "进入编辑界面", notes = "进入编辑界面")
	@GetMapping(value = "/detail/{action}")
	public String detail(@PathVariable("action") String action, Model model) {
		model.addAttribute("action", action);
		return "/customer/info/company/contact/detail";
	}

	@ApiOperation(value = "获取列表数据", notes = "获取列表数据:使用约定的DataTable")
	@PostMapping(value = "/list")
	@ResponseBody
	public DataTable<CustomerInfoCompanyContact> list(@RequestBody DataTable<CustomerInfoCompanyContact> dt) {
		return customerInfoCompanyContactService.pageSearch(dt);
	}

	@ApiOperation(value = "添加", notes = "添加")
	@PostMapping(value = "/create")
	@ResponseBody
	public ReturnDTO create(CustomerInfoCompanyContact param) {
		customerInfoCompanyContactService.insert(param);
		return ReturnDTOUtil.success();
	}

	@ApiOperation(value = "编辑", notes = "编辑")
	@PostMapping(value = "/update")
	@ResponseBody
	public ReturnDTO update(CustomerInfoCompanyContact param) {
		customerInfoCompanyContactService.updateById(param);
		return ReturnDTOUtil.success();
	}

	@SLog("批量删除")
	@ApiOperation(value = "批量删除", notes = "批量删除")
	@PostMapping(value = "/delete")
	@ResponseBody
	public ReturnDTO delete(@RequestParam("ids") List<Long> ids) {
		boolean success = customerInfoCompanyContactService.deleteBatchIds(ids);
		if (success) {
			return ReturnDTOUtil.success();
		}
		return ReturnDTOUtil.fail();
	}
}
