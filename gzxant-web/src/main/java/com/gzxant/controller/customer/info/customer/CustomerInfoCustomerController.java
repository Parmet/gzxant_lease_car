package com.gzxant.controller.customer.info.customer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.gzxant.entity.customer.info.certificate.CustomerInfoCertificate;
import com.gzxant.service.ISysDictService;
import com.gzxant.service.customer.info.certificate.ICustomerInfoCertificateService;
import com.sun.org.apache.regexp.internal.REUtil;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.gzxant.annotation.SLog;
import com.gzxant.base.entity.ReturnDTO;
import com.gzxant.base.vo.DataTable;
import com.gzxant.service.customer.info.customer.ICustomerInfoCustomerService;
import com.gzxant.entity.customer.info.customer.CustomerInfoCustomer;
import com.gzxant.util.ReturnDTOUtil;
import com.gzxant.base.controller.BaseController;

import io.swagger.annotations.ApiOperation;

import javax.validation.Valid;

/**
 * <p>
 * Customer's information 控制器
 * </p>
 *
 * @author tecty
 * @since 2018-07-05
 */
@RestController
@RequestMapping("/customer/info/customer")
public class CustomerInfoCustomerController extends BaseController {
	@Autowired
	private ICustomerInfoCustomerService customerInfoCustomerService;
	@Autowired
	private ISysDictService iSysDictService;


	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// this binder is for successfully transfer from String to Date
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	private Map<String,Object> getReturnMap(Map<String, Object> basicMap){
		// Fetch dict information dependency then inject it into basic map.
		basicMap.putAll(iSysDictService.getDictMapByMap( new HashMap<String, String>(){{
			put("driveCapability", "DriveCapability");
			put("emergencyContactRelationship", "EmergencyContactRelationship");
			put("status", "CustomerStatus");
		}}));
		return basicMap;
	}

	/**
	 * Create new customer
	 * @return Request status
	 */
	@PostMapping("")
	public ReturnDTO create(@RequestBody @Valid CustomerInfoCustomer customer){
		// create the entity into database
		customerInfoCustomerService.insertOrUpdate(customer);
		// return the successful code.
		return ReturnDTOUtil.success();
	}

	/**
	 * Read customers
	 * @return List of customer
	 */
	@GetMapping("")
	public Map get(@RequestParam(value = "page",defaultValue = "1") int page,
				   @RequestParam(value = "page_size",defaultValue = "10") int pageSize ){
		Map<String,Object> returnMap = new HashMap<>();
		// put the customer's list
		returnMap.put("customers",
					customerInfoCustomerService.selectPage(
						new Page<CustomerInfoCustomer>(page,pageSize)
					).getRecords()
		);

		return getReturnMap(returnMap);
	}

	/**
	 * Read the correspond customer
	 * @param id id of the customer
	 * @return return entity with dict information.
	 */
	@GetMapping("/{id}")
	public Map get(@PathVariable("id") Long id ){
		Map<String,Object> returnMap = new HashMap<>();
		// get an empty instance
		returnMap.put("customer", customerInfoCustomerService.selectById(id));
		return this.getReturnMap(returnMap);
	}

	/**
	 * update the correspond customer
	 * @return request status
	 */
	@PutMapping("")
	public ReturnDTO update(@RequestBody @Valid CustomerInfoCustomer customer){
		// call update by id and store the new customer's information
		customerInfoCustomerService.updateById(customer);
		return  ReturnDTOUtil.success();
	}

	/**
	 * Delete the correspond customer by id.
	 * @return request status.
	 */
	@DeleteMapping("/{id}")
	public ReturnDTO delete(@PathVariable("id") Long id){
		customerInfoCustomerService.deleteById(id);
		return ReturnDTOUtil.success();
	}
}
