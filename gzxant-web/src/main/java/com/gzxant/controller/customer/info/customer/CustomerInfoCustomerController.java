package com.gzxant.controller.customer.info.customer;

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
import com.gzxant.service.customer.info.customer.ICustomerInfoCustomerService;
import com.gzxant.entity.customer.info.customer.CustomerInfoCustomer;
import com.gzxant.util.ReturnDTOUtil;
import com.gzxant.base.controller.BaseController;

import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * Customer's information 前端控制器
 * </p>
 *
 * @author tecty
 * @since 2018-07-05
 */
@Controller
@RequestMapping("/customer/info/customer")
public class CustomerInfoCustomerController extends BaseController {
	@Autowired
	private ICustomerInfoCustomerService customerInfoCustomerService;

	@ApiOperation(value = "进入Customer's information列表界面", notes = "进入Customer's information列表界面")
	@GetMapping(value = "")
	public String list(Model model) {
		return "/customer/info/customer/list";
	}

	@ApiOperation(value = "进入Customer's information编辑界面", notes = "进入Customer's information编辑界面")
	@GetMapping(value = "/detail/{action}")
	public String detail(@PathVariable("action") String action, Model model) {
		model.addAttribute("action", action);
		return "/customer/info/customer/detail";
	}

	@ApiOperation(value = "获取Customer's information列表数据", notes = "获取Customer's information列表数据:使用约定的DataTable")
	@PostMapping(value = "/list")
	@ResponseBody
	public DataTable<CustomerInfoCustomer> list(@RequestBody DataTable<CustomerInfoCustomer> dt) {
		return customerInfoCustomerService.pageSearch(dt);
	}

	@ApiOperation(value = "添加Customer's information", notes = "添加Customer's information")
	@PostMapping(value = "/create")
	@ResponseBody
	public ReturnDTO create(CustomerInfoCustomer param) {
		customerInfoCustomerService.insert(param);
		return ReturnDTOUtil.success();
	}

	@ApiOperation(value = "编辑Customer's information", notes = "编辑Customer's information")
	@PostMapping(value = "/update")
	@ResponseBody
	public ReturnDTO update(CustomerInfoCustomer param) {
		customerInfoCustomerService.updateById(param);
		return ReturnDTOUtil.success();
	}

	@SLog("批量删除Customer's information")
	@ApiOperation(value = "批量删除Customer's information", notes = "批量删除Customer's information")
	@PostMapping(value = "/delete")
	@ResponseBody
	public ReturnDTO delete(@RequestParam("ids") List<Long> ids) {
		boolean success = customerInfoCustomerService.deleteBatchIds(ids);
		if (success) {
			return ReturnDTOUtil.success();
		}
		return ReturnDTOUtil.fail();
	}
}
