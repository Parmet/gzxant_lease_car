package com.gzxant.controller.customer.info.company;

import java.util.HashMap;
import java.util.List;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.gzxant.dto.CompanyDTO;
import com.gzxant.dto.CustomerDTO;
import com.gzxant.entity.SysCompany;
import com.gzxant.entity.customer.info.company.contact.CustomerInfoCompanyContact;
import com.gzxant.exception.LeaseCatException;
import com.gzxant.service.ISysCompanyService;
import com.gzxant.service.ISysDictService;
import com.gzxant.util.ConvertUtil;
import com.gzxant.util.FileUtils;
import com.gzxant.vo.CompanyVO;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

	private final String COMPANY_DATA = "企业信息";
	private final String ENTERPRISE_NUMBER = "企业编码";
	private final String NAME = "公司名称";
	private final String ABBREVIATION = "简称";
	private final String PROPERTY = "公司性质";
	private final String CATEGORY = "公司类别";
	private final String ADDRESS = "所属组织";
	private final String REGISTERED_CAPITAL = "公司地址";
	private final String REMARK = "注册资金";
	private final String REGISTERED_DATE = "注册日期";
	private final String LEGAL_REPRESENTATIVE = "法人代表";
	private final String EMAIL = "邮箱地址";
	private final String LICENSE_NUMBER = "营业执照号";
	private final String STATUS = "客户状态";


	@GetMapping("/exportXls")
	public String exportXls(HttpServletRequest request,
							HttpServletResponse response) throws Exception {
		//查询所有数据
		List<CompanyDTO> companyDTOS = companyService.selectList();
		List<CompanyVO> vos = ConvertUtil.convertCompanyDTOS2CompanyVOS(companyDTOS);

		//在内存中创建一个excel文件
		HSSFWorkbook workbook = new HSSFWorkbook();
		//创建一个标签页
		HSSFSheet sheet = workbook.createSheet(COMPANY_DATA);
		//创建标题行
		HSSFRow headRow = sheet.createRow(0);
		headRow.createCell(0).setCellValue(ENTERPRISE_NUMBER);
		headRow.createCell(1).setCellValue(NAME);
		headRow.createCell(2).setCellValue(ABBREVIATION);
		headRow.createCell(3).setCellValue(PROPERTY);
		headRow.createCell(4).setCellValue(CATEGORY);
		headRow.createCell(5).setCellValue(ADDRESS);
		headRow.createCell(6).setCellValue(REGISTERED_CAPITAL);
		headRow.createCell(7).setCellValue(REMARK);
		headRow.createCell(8).setCellValue(REGISTERED_DATE);
		headRow.createCell(9).setCellValue(LEGAL_REPRESENTATIVE);
		headRow.createCell(10).setCellValue(EMAIL);
		headRow.createCell(11).setCellValue(LICENSE_NUMBER);
		headRow.createCell(12).setCellValue(STATUS);

		for (CompanyVO companyVO : vos) {
			HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum() + 1);
			dataRow.createCell(0).setCellValue(companyVO.getId());
			dataRow.createCell(1).setCellValue(companyVO.getName());
			dataRow.createCell(2).setCellValue(companyVO.getAbbreviation());
			dataRow.createCell(3).setCellValue(companyVO.getProperty());
			dataRow.createCell(4).setCellValue(companyVO.getCategory());
			dataRow.createCell(5).setCellValue(companyVO.getAddress());
			dataRow.createCell(6).setCellValue(companyVO.getRegisteredCapital());
			dataRow.createCell(7).setCellValue(companyVO.getRemark());
			dataRow.createCell(8).setCellValue(companyVO.getRegisteredDate());
			dataRow.createCell(9).setCellValue(companyVO.getLegalRepresentative());
			dataRow.createCell(10).setCellValue(companyVO.getEmail());
			dataRow.createCell(11).setCellValue(companyVO.getLicenseNumber());
			dataRow.createCell(12).setCellValue(companyVO.getStatus());
		}

		//使用输出流进行文件下载（一个流、两个头）
		String filename = COMPANY_DATA + ".xls";
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
		return ConvertUtil.convertCompanyDTODT2CompanyVODT(companyDTODataTable);
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
		if (ids == null || ids.size() == 0) {
			return ReturnDTOUtil.fail();
		}
		companyService.deleteTheBatchIds(ids);
		return ReturnDTOUtil.success();
	}
}
