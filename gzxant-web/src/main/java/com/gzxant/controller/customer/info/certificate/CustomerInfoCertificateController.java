package com.gzxant.controller.customer.info.certificate;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import com.gzxant.service.ISysDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.gzxant.annotation.SLog;
import com.gzxant.base.entity.ReturnDTO;
import com.gzxant.base.vo.DataTable;
import com.gzxant.service.customer.info.certificate.ICustomerInfoCertificateService;
import com.gzxant.entity.customer.info.certificate.CustomerInfoCertificate;
import com.gzxant.util.ReturnDTOUtil;
import com.gzxant.base.controller.BaseController;

import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * Certificate table 前端控制器
 * </p>
 *
 * @author tecty
 * @since 2018-07-05
 */
@Controller
@RequestMapping("/customer/info/certificate")
public class CustomerInfoCertificateController extends BaseController {
	@Autowired
	private ICustomerInfoCertificateService customerInfoCertificateService;
	@Autowired
	private ISysDictService iSysDictService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}


	@ApiOperation(value = "进入Certificate table列表界面", notes = "进入Certificate table列表界面")
	@GetMapping(value = "")
	public String list(Model model) {
		return "/customer/info/certificate/list";
	}

	@ApiOperation(value = "进入Certificate table编辑界面", notes = "进入Certificate table编辑界面")
	@GetMapping(value = "/detail/{action}")
	public String detail(@PathVariable("action") String action, Model model) {
		model.addAttribute("action", action);
		return "/customer/info/certificate/detail";
	}

	@GetMapping(value = "/insert")
	public String insert(Model model){
		model.addAttribute("typeList",iSysDictService.getDictTree("CertificateType"));
		return "/customer/info/certificate/insert";
	}

	@ApiOperation(value = "获取Certificate table列表数据", notes = "获取Certificate table列表数据:使用约定的DataTable")
	@PostMapping(value = "/list")
	@ResponseBody
	public DataTable<CustomerInfoCertificate> list(@RequestBody DataTable<CustomerInfoCertificate> dt) {
		return customerInfoCertificateService.pageSearch(dt);
	}

	@ApiOperation(value = "添加Certificate table", notes = "添加Certificate table")
	@PostMapping(value = "/")
	@ResponseBody
	public ReturnDTO create(CustomerInfoCertificate param) {
		customerInfoCertificateService.insert(param);
		return ReturnDTOUtil.success();
	}

	@ApiOperation(value = "编辑Certificate table", notes = "编辑Certificate table")
	@PostMapping(value = "/update")
	@ResponseBody
	public ReturnDTO update(CustomerInfoCertificate param) {
		customerInfoCertificateService.updateById(param);
		return ReturnDTOUtil.success();
	}

	@SLog("批量删除Certificate table")
	@ApiOperation(value = "批量删除Certificate table", notes = "批量删除Certificate table")
	@PostMapping(value = "/delete")
	@ResponseBody
	public ReturnDTO delete(@RequestParam("ids") List<Long> ids) {
		boolean success = customerInfoCertificateService.deleteBatchIds(ids);
		if (success) {
			return ReturnDTOUtil.success();
		}
		return ReturnDTOUtil.fail();
	}
}
