package com.gzxant.controller.customer.info.company.contact;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gzxant.constant.SearchParam;
import com.gzxant.dto.ContactDTO;
import com.gzxant.enums.LeaseCarEnum;
import com.gzxant.exception.LeaseCatException;
import com.gzxant.service.customer.info.company.ICustomerInfoCompanyService;
import com.gzxant.util.ConvertUtil;
import com.gzxant.vo.CompanyVO;
import com.gzxant.vo.ContactVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.gzxant.base.entity.ReturnDTO;
import com.gzxant.base.vo.DataTable;
import com.gzxant.service.customer.info.company.contact.ICustomerInfoCompanyContactService;
import com.gzxant.entity.customer.info.company.contact.CustomerInfoCompanyContact;
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
@RequestMapping("/customer/info/company/contact")
public class CustomerInfoCompanyContactController extends BaseController {

	@Autowired
	private ICustomerInfoCompanyService companyService;

	@Autowired
	private ICustomerInfoCompanyContactService contactService;

	private final String COMPANY_ID = "company_id";
	private final String DEFAULT_NAME = "暂无默认值";


	@ApiOperation(value = "进入列表界面", notes = "进入列表界面")
	@GetMapping(value = "/{id}")
	public String list(@PathVariable("id") Long id, String flag, Model model) {
		model.addAttribute("id",id);
		model.addAttribute("flag", flag);
		CompanyVO companyVO = companyService.selectById(id);
		Map<String, Object> map = new HashMap<>();
		map.put("enterpriseNumber", companyVO.getEnterpriseNumber());
		map.put("name", companyVO.getName());
		model.addAttribute("company",map);
		return "customer/info/company/contact/list";
	}

	@ApiOperation(value = "获取列表数据", notes = "获取列表数据:使用约定的DataTable")
	@PostMapping(value = "/{id}/list")
	@ResponseBody
	public DataTable<ContactVO> list(@PathVariable("id")Long id,@RequestBody DataTable<CustomerInfoCompanyContact> dt) {
		if (id == null) {
			throw new LeaseCatException(LeaseCarEnum.CONTACT_SHOW_FAIL_WITH_ID_IS_NULL);
		}
		dt.getSearchParams().put(SearchParam.SEARCH_EQ + COMPANY_ID, id);
		DataTable<ContactDTO> contactDTODataTable = contactService.pageSearchDTO(dt);
		DataTable<ContactVO> contactVODataTable = ConvertUtil.convertContactDTODT2ContactVODT(contactDTODataTable);
		List<ContactVO> rows = contactVODataTable.getRows();
 		return contactVODataTable;
	}

	@ApiOperation(value = "进入添加联系人信息页面", notes = "进入添加联系人信息页面")
	@GetMapping(value = "/{companyId}/insert")
	public String toInsertPage(@PathVariable("companyId") Long companyId, Model model) {
		model.addAttribute("id", companyId);
		model.addAttribute("action","insert");
		return "customer/info/company/contact/insert";
	}

	@ApiOperation(value = "进入修改联系人信息页面", notes = "进入修改联系人信息页面")
	@GetMapping(value = "/{companyId}/update/{id}")
	public String toUpdatePage(@PathVariable("id") Long id, Model model) {
		CustomerInfoCompanyContact contact = contactService.selectById(id);
		model.addAttribute("contact", contact);
		model.addAttribute("action","insert");
		return "customer/info/company/contact/insert";
	}

	@ApiOperation(value = "添加/编辑联系人信息", notes = "添加/编辑联系人信息")
	@PostMapping(value = "/insert")
	@ResponseBody
	public ReturnDTO create(@Valid ContactVO contactVO, BindingResult result){
		if (result.hasErrors()) {
			throw new LeaseCatException(result.getFieldError().getDefaultMessage());
		}
		ContactDTO contactDTO = ConvertUtil.convert(contactVO);
		contactService.insertOrUpdate(contactDTO);
		return ReturnDTOUtil.success();
	}


	@ApiOperation(value = "批量删除用户", notes = "批量删除用户")
	@PostMapping(value = "/{id}/delete")
	@ResponseBody
	public ReturnDTO delete(@RequestParam("ids") List<Long> ids, ServletRequest request) {
		if (ids == null || ids.size() == 0) {
			return ReturnDTOUtil.fail();
		}
		contactService.deleteTheBatchIds(ids);
		return ReturnDTOUtil.success();
	}
}
