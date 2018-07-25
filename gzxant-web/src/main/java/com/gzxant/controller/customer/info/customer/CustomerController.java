package com.gzxant.controller.customer.info.customer;

import java.util.List;

import com.gzxant.annotation.SLog;
import com.gzxant.dto.CustomerDTO;
import com.gzxant.enums.LeaseCarEnum;
import com.gzxant.exception.LeaseCatException;
import com.gzxant.service.ISysDictService;
import com.gzxant.util.ConvertUtil;
import com.gzxant.util.FileUtils;
import com.gzxant.vo.CustomerDetailVO;
import com.gzxant.vo.CustomerVO;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.gzxant.base.entity.ReturnDTO;
import com.gzxant.base.vo.DataTable;
import com.gzxant.service.customer.info.customer.ICustomerInfoCustomerService;
import com.gzxant.entity.customer.info.customer.CustomerInfoCustomer;
import com.gzxant.util.ReturnDTOUtil;
import com.gzxant.base.controller.BaseController;

import io.swagger.annotations.ApiOperation;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * <p>
 *     CustomerDTO 控制器
 * </p>
 *
 * @author Fatal
 * @date 218-07-21
 */
@Controller
@RequestMapping("/customer/info/customer")
public class CustomerController extends BaseController {

	@Autowired
	private ICustomerInfoCustomerService customerService;
	@Autowired
	private ISysDictService iSysDictService;

	private final String CUSTOMER_DATA = "客户信息";
	private final String CUSTOMER_ID = "客户编码";
	private final String CUSTOMER_NAME = "姓名";
	private final String CUSTOMER_SEX = "性别";
	private final String CUSTOMER_TEL = "联系方式";
	private final String IDENTITY_CARD = "身份证号码";
	private final String DRIVE_CARD = "驾驶证号码";
	private final String CUSTOMER_ADDRESS = "地址";

	@GetMapping("/exportXls")
	public String exportXls(HttpServletRequest request,
							HttpServletResponse response) throws Exception {
		//查询所有数据
		List<CustomerDTO> customerDTOS = customerService.selectList();

		//在内存中创建一个excel文件
		HSSFWorkbook workbook = new HSSFWorkbook();
		//创建一个标签页
		HSSFSheet sheet = workbook.createSheet(CUSTOMER_DATA);
		//创建标题行
		HSSFRow headRow = sheet.createRow(0);
		headRow.createCell(0).setCellValue(CUSTOMER_ID);
		headRow.createCell(1).setCellValue(CUSTOMER_NAME);
		headRow.createCell(2).setCellValue(CUSTOMER_SEX);
		headRow.createCell(3).setCellValue(CUSTOMER_TEL);
		headRow.createCell(4).setCellValue(IDENTITY_CARD);
		headRow.createCell(5).setCellValue(DRIVE_CARD);
		headRow.createCell(6).setCellValue(CUSTOMER_ADDRESS);

		for (CustomerDTO customerDTO : customerDTOS) {
			HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum() + 1);
			dataRow.createCell(0).setCellValue(customerDTO.getCustomerId());
			dataRow.createCell(1).setCellValue(customerDTO.getName());
			dataRow.createCell(2).setCellValue(customerDTO.getGender());
			dataRow.createCell(3).setCellValue(customerDTO.getTel());
			dataRow.createCell(4).setCellValue(customerDTO.getIdentityNumber());
			dataRow.createCell(5).setCellValue(customerDTO.getDriveNumber());
			dataRow.createCell(6).setCellValue(customerDTO.getAddress());
		}

		//使用输出流进行文件下载（一个流、两个头）
		String filename = CUSTOMER_DATA + ".xls";
		String mimeType = request.getServletContext().getMimeType(filename);
		ServletOutputStream out = response.getOutputStream();
		response.setContentType(mimeType);
		response.setCharacterEncoding("utf-8");

		//获得客户端浏览器类型
		String agent = request.getHeader("User-Agent");
		filename = FileUtils.encodeDownloadFilename(filename, agent);
		response.setHeader("content-disposition", "attachment;filename=" + filename);

		workbook.write(out);
		return null;
	}

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
	public DataTable<CustomerVO> list(@RequestBody DataTable<CustomerInfoCustomer> dt) {
		DataTable<CustomerDTO> customerDTODataTable = customerService.pageSearchDTO(dt);
		return ConvertUtil.convertCustomerDTODT2CustomerVODT(customerDTODataTable);
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
		CustomerDetailVO customerDetailVO = null;
		if (id != null) {
            customerDetailVO = customerService.selectById(id);
			model.addAttribute("customer", customerDetailVO);
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
        CustomerDetailVO customerDetailVO = null;
        if (id != null) {
            customerDetailVO = customerService.selectById(id);
            model.addAttribute("customer", customerDetailVO);
        } else {
            throw new LeaseCatException(LeaseCarEnum.CUSTOMER_ADD_PAGE_ECHO_FAIL);
        }
        return "customer/info/customer/insert";
    }

	@ApiOperation(value = "添加/编辑用户信息", notes = "添加/编辑用户信息")
	@PostMapping(value = "/insert")
	@ResponseBody
	public ReturnDTO create(@Valid CustomerDetailVO customerDetailVO, BindingResult result){
		if (result.hasErrors()) {
			throw new LeaseCatException(result.getFieldError().getDefaultMessage());
		}
		customerService.insertOrUpdate(customerDetailVO);
		return ReturnDTOUtil.success();
	}

    @SLog("批量删除用户")
    @ApiOperation(value = "批量删除用户", notes = "批量删除用户")
    @PostMapping(value = "/delete")
    @ResponseBody
    public ReturnDTO delete(@RequestParam("ids") List<String> ids, ServletRequest request) {
		///TODO
		customerService.deleteTheBatchIds(ids);
		return ReturnDTOUtil.success();
    }

}
