package com.gzxant.controller.customer.info.customer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.gzxant.annotation.SLog;
import com.gzxant.dto.CustomerDTO;
import com.gzxant.entity.customer.info.certificate.CustomerInfoCertificate;
import com.gzxant.enums.CertificatesStatusEnum;
import com.gzxant.enums.LeaseCarEnum;
import com.gzxant.exception.LeaseCatException;
import com.gzxant.service.ISysDictService;
import com.gzxant.service.customer.info.certificate.ICustomerInfoCertificateService;
import com.gzxant.util.DateUtils;
import com.gzxant.util.StringUtils;
import com.gzxant.vo.CustomerVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.gzxant.base.entity.ReturnDTO;
import com.gzxant.base.vo.DataTable;
import com.gzxant.service.customer.info.customer.ICustomerInfoCustomerService;
import com.gzxant.entity.customer.info.customer.CustomerInfoCustomer;
import com.gzxant.util.ReturnDTOUtil;
import com.gzxant.base.controller.BaseController;

import io.swagger.annotations.ApiOperation;

import javax.servlet.ServletRequest;
import javax.validation.Valid;

/**
 * <p>
 * Customer's information 控制器
 * </p>
 *
 * @author tecty
 * @since 2018-07-05
 */
@Controller
@RequestMapping("/customer/info/customer")
public class CustomerInfoCustomerController extends BaseController {

	@Autowired
	private ICustomerInfoCustomerService customerService;
	@Autowired
	private ISysDictService iSysDictService;

	/*@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}*/

	@ApiOperation(value = "进入用户信息列表界面", notes = "进入用户信息列表界面")
	@GetMapping(value = "")
	public String list(@RequestParam(value = "page",defaultValue = "1") int page,
					   @RequestParam(value = "page_size",defaultValue = "10") int pageSize) {
		return "customer/info/customer/list";
	}

	@ApiOperation(value = "获取用户信息列表数据", notes = "获取用户信息列表数据:使用约定的DataTable")
	@PostMapping(value = "/list")
	@ResponseBody
	public DataTable<CustomerDTO> list(@RequestBody DataTable<CustomerInfoCustomer> dt) {
		return customerService.pageSearchDto(dt);
	}

	@ApiOperation(value = "进入添加用户信息页面", notes = "进入添加用户信息页面")
	@GetMapping(value = "/insert")
	public String toInsertPage(Model model) {

		model.addAttribute("action","insert");
		//字典查询
		model.addAttribute("genderList", iSysDictService.getDictTree("sex"));
		model.addAttribute("statusList", iSysDictService.getDictTree("CustomerStatus"));
		model.addAttribute("capabilityList", iSysDictService.getDictTree("DriveCapability"));
		model.addAttribute("contactList", iSysDictService.getDictTree("EmergencyContactRelationship"));
		return "customer/info/customer/insert";
	}

	@ApiOperation(value = "进入编辑用户信息页面", notes = "进入编辑用户信息页面")
	@GetMapping(value = "/update/{id}")
	public String toUpdatePage(@PathVariable("id") String id, Model model) {

		model.addAttribute("action","insert");
		//字典查询
		model.addAttribute("genderList", iSysDictService.getDictTree("sex"));
		model.addAttribute("statusList", iSysDictService.getDictTree("CustomerStatus"));
		model.addAttribute("capabilityList", iSysDictService.getDictTree("DriveCapability"));
		model.addAttribute("contactList", iSysDictService.getDictTree("EmergencyContactRelationship"));
		CustomerVO customerVO = null;
		if (id != null) {
            customerVO = customerService.selectById(id);
			model.addAttribute("customer", customerVO);
		} else {
			throw new LeaseCatException(LeaseCarEnum.CUSTOMER_ADD_PAGE_ECHO_FAIL);
		}
		return "customer/info/customer/insert";
	}


    @ApiOperation(value = "进入用户详情信息页面", notes = "进入用户详情信息页面")
    @GetMapping(value = "/detail/{id}")
    public String toDetailPage(@PathVariable("id") String id, Model model) {

        model.addAttribute("action","detail");
        //字典查询
        model.addAttribute("genderList", iSysDictService.getDictTree("sex"));
        model.addAttribute("statusList", iSysDictService.getDictTree("CustomerStatus"));
        model.addAttribute("capabilityList", iSysDictService.getDictTree("DriveCapability"));
        model.addAttribute("contactList", iSysDictService.getDictTree("EmergencyContactRelationship"));
        CustomerVO customerVO = null;
        if (id != null) {
            customerVO = customerService.selectById(id);
            model.addAttribute("customer", customerVO);
        } else {
            throw new LeaseCatException(LeaseCarEnum.CUSTOMER_ADD_PAGE_ECHO_FAIL);
        }
        return "customer/info/customer/insert";
    }

	@ApiOperation(value = "添加/编辑用户信息", notes = "添加/编辑用户信息")
	@PostMapping(value = "/insert")
	@ResponseBody
	public ReturnDTO create(@Valid CustomerVO customerVO, BindingResult result){
		if (result.hasErrors()) {
			throw new LeaseCatException(result.getFieldError().getDefaultMessage());
		}
		customerService.insertOrUpdate(customerVO);
		return ReturnDTOUtil.success();
	}

    @SLog("批量删除用户")
    @ApiOperation(value = "批量删除用户", notes = "批量删除用户")
    @PostMapping(value = "/delete")
    @ResponseBody
    public ReturnDTO delete(@RequestParam("ids") List<String> ids, ServletRequest request) {
        boolean success = customerService.deleteBatchIds(ids);
        if (success) {
            return ReturnDTOUtil.success();
        }
        return ReturnDTOUtil.fail();

    }

}
