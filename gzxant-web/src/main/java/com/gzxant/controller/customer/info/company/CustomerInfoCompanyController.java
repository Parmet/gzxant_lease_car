package com.gzxant.controller.customer.info.company;

import java.util.HashMap;
import java.util.List;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.gzxant.dto.CompanyDTO;
import com.gzxant.entity.SysCompany;
import com.gzxant.exception.LeaseCatException;
import com.gzxant.service.ISysCompanyService;
import com.gzxant.service.ISysDictService;
import com.gzxant.util.ConvertUtil;
import com.gzxant.vo.CompanyVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
import com.gzxant.service.customer.info.company.ICustomerInfoCompanyService;
import com.gzxant.entity.customer.info.company.CustomerInfoCompany;
import com.gzxant.util.ReturnDTOUtil;
import com.gzxant.base.controller.BaseController;

import io.swagger.annotations.ApiOperation;

import javax.servlet.ServletRequest;
import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tecty
 * @since 2018-07-05
 */
@Controller
@RequestMapping("/customer/info/company")
public class CustomerInfoCompanyController extends BaseController {

	private Logger logger= LoggerFactory.getLogger(getClass());

	@Autowired
	private ICustomerInfoCompanyService companyService;

	@Autowired
	private ISysDictService iSysDictService;

	@Autowired
	private ISysCompanyService iSysCompanyService;

	@ApiOperation(value = "进入列表界面", notes = "进入列表界面")
	@GetMapping(value = "")
	public String list(Model model) {
		return "customer/info/company/list";
	}

	@ApiOperation(value = "获取列表数据", notes = "获取列表数据:使用约定的DataTable")
	@PostMapping(value = "/list")
	@ResponseBody
	public DataTable<CompanyVO> list(@RequestBody DataTable<CustomerInfoCompany> dt) {
		DataTable<CompanyDTO> companyDTODataTable = companyService.pageSearchDTO(dt);
		return ConvertUtil.convertCompanyDTOToCompanyVO(companyDTODataTable);
	}

	@ApiOperation(value = "进入添加公司信息界面", notes = "进入添加公司信息界面")
	@GetMapping(value = "/insert")
	public String detail(Model model) {
		model.addAttribute("action", "insert");
		model.addAttribute("propertyList", iSysDictService.getDictTree("TheNatureOfTheCompany"));
		model.addAttribute("categoryList", iSysDictService.getDictTree("Company Category"));
		model.addAttribute("belongstoList",iSysCompanyService.selectByMap(null));
		model.addAttribute("statusList",iSysDictService.getDictTree("CustomerStatus"));
		return "customer/info/company/insert";
	}

	@ApiOperation(value = "进入编辑公司信息页面", notes = "进入编辑公司信息页面")
	@GetMapping(value = "/update/{id}")
	public String toUpdatePage(@PathVariable("id") Long id, Model model) {
 		model.addAttribute("action", "insert");
		model.addAttribute("propertyList", iSysDictService.getDictTree("TheNatureOfTheCompany"));
		model.addAttribute("categoryList", iSysDictService.getDictTree("Company Category"));
		model.addAttribute("belongstoList",iSysCompanyService.selectByMap(null));
		model.addAttribute("statusList",iSysDictService.getDictTree("CustomerStatus"));
		model.addAttribute("company",companyService.selectById(id));
		return "customer/info/company/insert";
	}

	@ApiOperation(value = "添加/编辑公司信息", notes = "添加/编辑公司信息")
	@PostMapping(value = "/insert")
	@ResponseBody
	public ReturnDTO create(@Valid CompanyVO companyVO, BindingResult result){
		if (result.hasErrors()) {
			logger.info("【客户添加】公司添加失败 -- 参数不能为空");
			return ReturnDTOUtil.fail();
		}
		Long id = companyService.insertOrUpdate(companyVO);
		if (id == null) {
			logger.info("【客户添加】公司添加失败 -- 返回id不能为空");
			return ReturnDTOUtil.fail();
		}
		return ReturnDTOUtil.success(id);
	}

	@SLog("批量删除用户")
	@ApiOperation(value = "批量删除用户", notes = "批量删除用户")
	@PostMapping(value = "/delete")
	@ResponseBody
	public ReturnDTO delete(@RequestParam("ids") List<Long> ids, ServletRequest request) {
		try {
			companyService.deleteTheBatchIds(ids);
			return ReturnDTOUtil.success();
		} catch (Exception e) {
			e.printStackTrace();
			return ReturnDTOUtil.fail();
		}
	}
}
