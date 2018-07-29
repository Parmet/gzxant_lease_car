package com.gzxant.controller.insurance;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONArray;
import com.gzxant.base.entity.ReturnDTO;
import com.gzxant.constant.Setting;
import com.gzxant.dto.CODE;
import com.gzxant.dto.InsuranceEO;
import com.gzxant.dto.WebJsonBean;
import com.gzxant.entity.insurance.InsuranceFile;
import com.gzxant.entity.insurance.InsuranceInfo;
import com.gzxant.entity.insurance.InsuranceSpecies;
import com.gzxant.service.insurance.InsuranceService;
import com.gzxant.shiro.GzxantSysUser;
import com.gzxant.util.DateUtils;
import com.gzxant.util.FileUtils;
import com.gzxant.util.PathUtils;
import com.gzxant.util.ReturnDTOUtil;
import com.gzxant.vo.InsuranceVo;

@Controller
@RequestMapping(value="/insurance")
public class InsuranceController {
	private Logger log = LoggerFactory.getLogger(InsuranceController.class);
	
	@Autowired
	private InsuranceService insuranceService;
	
	// 分页查询保险列表
	@ResponseBody
	@RequestMapping(value = "/queryInsuranceListPage")
	public WebJsonBean queryInsuranceListPage(InsuranceEO insuranceEO) {
		return new WebJsonBean(CODE.SUCCESS, insuranceService.queryInsuranceListPage(insuranceEO));
	}
	
	// 查看保险基本信息
	@ResponseBody
	@RequestMapping(value = "/queryInsuranceInfo")
	public WebJsonBean queryInsuranceInfo(String code) {
		if (StringUtils.isEmpty(code)){
			return new WebJsonBean(CODE.FAIL, "请选择保险单");
		}
		return new WebJsonBean(CODE.SUCCESS, insuranceService.queryInsuranceInfo(code));
	}
	
	// 查看保险种类
	@ResponseBody
	@RequestMapping(value = "/queryInsuranceSpecies")
	public WebJsonBean queryInsuranceSpecies(String code) {
		if (StringUtils.isEmpty(code)){
			return new WebJsonBean(CODE.FAIL, "请选择保险单");
		}
		return new WebJsonBean(CODE.SUCCESS, insuranceService.queryInsuranceSpecies(code));
	}
	
	// 查看保险附件
	@ResponseBody
	@RequestMapping(value = "/queryInsuranceFile")
	public WebJsonBean queryInsuranceFile(String code) {
		if (StringUtils.isEmpty(code)){
			return new WebJsonBean(CODE.FAIL, "请选择保险单");
		}
		return new WebJsonBean(CODE.SUCCESS, insuranceService.queryInsuranceFile(code));
	}
	
	// 新增保险基本信息
	@ResponseBody
	@RequestMapping(value = "/addInsuranceInfo")
	public WebJsonBean addInsuranceInfo(InsuranceInfo info) {
		if (StringUtils.isEmpty(info.getCarNo())){
			return new WebJsonBean(CODE.FAIL, "请输入车牌号");
		}
		if (StringUtils.isEmpty(info.getBuyOrganization())){
			return new WebJsonBean(CODE.FAIL, "请选择购买组织");
		}
		if (StringUtils.isEmpty(info.getInsuranceNo())){
			return new WebJsonBean(CODE.FAIL, "请输入保险单号");
		}
		if (StringUtils.isEmpty(info.getInsuranceType())){
			return new WebJsonBean(CODE.FAIL, "请选择保单类型");
		}
		if (StringUtils.isEmpty(info.getInsuranceCompany())){
			return new WebJsonBean(CODE.FAIL, "请选择保险公司");
		}
		if (StringUtils.isEmpty(info.getInsuranceCommissioner())){
			return new WebJsonBean(CODE.FAIL, "请输入保险专员");
		}
		if (info.getInsuranceTotalAmount() == null){
			return new WebJsonBean(CODE.FAIL, "请输入总保费");
		}
		if (info.getWorkDate() == null){
			return new WebJsonBean(CODE.FAIL, "请输入起效日期");
		}
		if (info.getExpiryDate() == null){
			return new WebJsonBean(CODE.FAIL, "请输入失效日期");
		}
		if (StringUtils.isEmpty(info.getClaimsTel())){
			return new WebJsonBean(CODE.FAIL, "请输入理赔电话");
		}
		if (StringUtils.isEmpty(info.getAgentName())){
			return new WebJsonBean(CODE.FAIL, "请输入经办人");
		}
		return new WebJsonBean(CODE.SUCCESS, insuranceService.addInsuranceInfo(info));
	}
	
	// 新增保险种类
	@ResponseBody
	@RequestMapping(value = "/addInsuranceSpecies")
	public WebJsonBean addInsuranceSpecies(String code, String speciesListStr) {
		if (StringUtils.isEmpty(code)){
			return new WebJsonBean(CODE.FAIL, "请选择保险单");
		}
		List<InsuranceSpecies> speciesList = JSONArray.parseArray(speciesListStr, InsuranceSpecies.class);
		if (speciesList == null || speciesList.size() == 0){
			return new WebJsonBean(CODE.FAIL, "至少填写一条保险种类");
		}
		for (InsuranceSpecies species : speciesList){
			if (StringUtils.isEmpty(species.getInsuranceItem())){
				return new WebJsonBean(CODE.FAIL, "请输入保险细项");
			}
			if (StringUtils.isEmpty(species.getRate())){
				return new WebJsonBean(CODE.FAIL, "请输入费率");
			}
			if (species.getInsuredAmount() == null){
				return new WebJsonBean(CODE.FAIL, "请输入被保金额");
			}
			if (species.getInsurancePremium() == null){
				return new WebJsonBean(CODE.FAIL, "请输入被保金额");
			}
		}
		insuranceService.addInsuranceSpecies(code, speciesList);
		return new WebJsonBean(CODE.SUCCESS);
	}
	
	// 新增保险附件
	@ResponseBody
	@RequestMapping(value = "/addInsuranceFile")
	public WebJsonBean addInsuranceFile(String fileListStr) {
		List<InsuranceFile> fileList = JSONArray.parseArray(fileListStr, InsuranceFile.class);
		for (InsuranceFile file : fileList){
			if (StringUtils.isEmpty(file.getCode())){
				return new WebJsonBean(CODE.FAIL, "请选择保险单");
			}
			if (StringUtils.isEmpty(file.getFileName())){
				return new WebJsonBean(CODE.FAIL, "文件名为空");
			}
			if (StringUtils.isEmpty(file.getFileUrl())){
				return new WebJsonBean(CODE.FAIL, "文件路径为空");
			}
		}
		insuranceService.addInsuranceFile(fileList);
		return new WebJsonBean(CODE.SUCCESS);
	}
	
	// 修改保险基本信息
	@ResponseBody
	@RequestMapping(value = "/modifyInsuranceInfo")
	public WebJsonBean modifyInsuranceInfo(InsuranceInfo info) {
		if (StringUtils.isEmpty(info.getCode())){
			return new WebJsonBean(CODE.FAIL, "请选择保险单");
		}
		if (StringUtils.isEmpty(info.getCarNo())){
			return new WebJsonBean(CODE.FAIL, "请输入车牌号");
		}
		if (StringUtils.isEmpty(info.getBuyOrganization())){
			return new WebJsonBean(CODE.FAIL, "请选择购买组织");
		}
		if (StringUtils.isEmpty(info.getInsuranceNo())){
			return new WebJsonBean(CODE.FAIL, "请输入保险单号");
		}
		if (StringUtils.isEmpty(info.getInsuranceType())){
			return new WebJsonBean(CODE.FAIL, "请选择保单类型");
		}
		if (StringUtils.isEmpty(info.getInsuranceCompany())){
			return new WebJsonBean(CODE.FAIL, "请选择保险公司");
		}
		if (StringUtils.isEmpty(info.getInsuranceCommissioner())){
			return new WebJsonBean(CODE.FAIL, "请输入保险专员");
		}
		if (info.getInsuranceTotalAmount() == null){
			return new WebJsonBean(CODE.FAIL, "请输入总保费");
		}
		if (info.getWorkDate() == null){
			return new WebJsonBean(CODE.FAIL, "请输入起效日期");
		}
		if (info.getExpiryDate() == null){
			return new WebJsonBean(CODE.FAIL, "请输入失效日期");
		}
		if (StringUtils.isEmpty(info.getClaimsTel())){
			return new WebJsonBean(CODE.FAIL, "请输入理赔电话");
		}
		if (StringUtils.isEmpty(info.getAgentName())){
			return new WebJsonBean(CODE.FAIL, "请输入经办人");
		}
		info.setUpdateTime(new Date());
		insuranceService.modifyInsuranceInfo(info);
		return new WebJsonBean(CODE.SUCCESS);
	}
	
	// 修改保险种类
	@ResponseBody
	@RequestMapping(value = "/modifyInsuranceSpecies")
	public WebJsonBean modifyInsuranceSpecies(String code, String speciesListStr) {
		if (StringUtils.isEmpty(code)){
			return new WebJsonBean(CODE.FAIL, "请选择保险单");
		}
		List<InsuranceSpecies> speciesList = JSONArray.parseArray(speciesListStr, InsuranceSpecies.class);
		if (speciesList == null || speciesList.size() == 0){
			return new WebJsonBean(CODE.FAIL, "至少填写一条保险种类");
		}
		for (InsuranceSpecies species : speciesList){
			if (StringUtils.isEmpty(species.getRate())){
				return new WebJsonBean(CODE.FAIL, "请输入费率");
			}
			if (species.getInsuredAmount() == null){
				return new WebJsonBean(CODE.FAIL, "请输入被保金额");
			}
			if (species.getInsurancePremium() == null){
				return new WebJsonBean(CODE.FAIL, "请输入被保金额");
			}
		}
		insuranceService.modifyInsuranceSpecies(code, speciesList);
		return new WebJsonBean(CODE.SUCCESS);
	}
	
	// 修改保险附件
	@ResponseBody
	@RequestMapping(value = "/modifyInsuranceFile")
	public WebJsonBean modifyInsuranceFile(String code, String fileListStr) {
		if (StringUtils.isEmpty(code)){
			return new WebJsonBean(CODE.FAIL, "请选择保险单");
		}
		List<InsuranceFile> fileList = JSONArray.parseArray(fileListStr, InsuranceFile.class);
		for (InsuranceFile file : fileList){
			if (StringUtils.isEmpty(file.getCode())){
				return new WebJsonBean(CODE.FAIL, "请选择保险单");
			}
			if (StringUtils.isEmpty(file.getFileName())){
				return new WebJsonBean(CODE.FAIL, "文件名为空");
			}
			if (StringUtils.isEmpty(file.getFileUrl())){
				return new WebJsonBean(CODE.FAIL, "文件路径为空");
			}
		}
		insuranceService.modifyInsuranceFile(code, fileList);
		return new WebJsonBean(CODE.SUCCESS);
	}
	
	// 删除保险附件
	@ResponseBody
	@RequestMapping(value = "/deleteInsurance")
	public WebJsonBean deleteInsurance(String code) {
		if (StringUtils.isEmpty(code)){
			return new WebJsonBean(CODE.FAIL, "请选择保险单");
		}
		insuranceService.deleteInsurance(code);
		return new WebJsonBean(CODE.SUCCESS);
	}
	
	// 导出保险信息
	@ResponseBody
	@RequestMapping(value = "/exportInsurance")
	public WebJsonBean exportInsurance(InsuranceEO insuranceEO, HttpServletRequest request, 
			HttpServletResponse response) {
		HSSFWorkbook wb = new HSSFWorkbook();
		// sheet 对应一个工作页
		Sheet sheet = wb.createSheet("保险信息");
		// 创建第一行为标题行
		Row hssfRow = sheet.createRow(0);
		Cell hssfCell = hssfRow.createCell(0);
		String[] titleArr = {"编号","车牌号","车辆所属","保险单号","保单类型","资产状态","车型","车辆年限","保险公司",
				"起效日期","失效日期","有效/失效","总保费用"};
		int i = 0;
		/* for循环生成列名 */
		for (String key : titleArr) {
			hssfCell = hssfRow.createCell(i);
			hssfCell.setCellValue(key);
			i++;
		}
		
		List<InsuranceVo> resultList = insuranceService.queryInsuranceList(insuranceEO);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		// 填充数据
		for (int j = 1; j <= resultList.size(); j++) {
			InsuranceVo vo = resultList.get(j-1);
			hssfRow = sheet.createRow(j);
			
			hssfCell = hssfRow.createCell(0);
			hssfCell.setCellValue(vo.getCode());
			hssfCell = hssfRow.createCell(1);
			hssfCell.setCellValue(vo.getCarNo());
			hssfCell = hssfRow.createCell(2);
			hssfCell.setCellValue(vo.getAssets_belong());
			hssfCell = hssfRow.createCell(3);
			hssfCell.setCellValue(vo.getInsuranceNo());
			hssfCell = hssfRow.createCell(4);
			hssfCell.setCellValue(vo.getInsuranceType());
			hssfCell = hssfRow.createCell(5);
			hssfCell.setCellValue(vo.getAssets_state());
			hssfCell = hssfRow.createCell(6);
			hssfCell.setCellValue(vo.getVehicle_type());
			hssfCell = hssfRow.createCell(7);
			hssfCell.setCellValue(vo.getCarAgeLimit());
			hssfCell = hssfRow.createCell(8);
			hssfCell.setCellValue(vo.getInsuranceCompany());
			hssfCell = hssfRow.createCell(9);
			hssfCell.setCellValue(format.format(vo.getWorkDate()));
			hssfCell = hssfRow.createCell(10);
			hssfCell.setCellValue(format.format(vo.getExpiryDate()));
			hssfCell = hssfRow.createCell(11);
			hssfCell.setCellValue(vo.getStatus());
			hssfCell = hssfRow.createCell(12);
			hssfCell.setCellValue(vo.getInsuranceTotalAmount() == null ? "0.00" : vo.getInsuranceTotalAmount().toString());
		}
		for (int a = 0; a <= i; a++) {
			sheet.autoSizeColumn(a);// 設置自動列寬
		}
		
		// 创建文件输出流，准备输出电子表格
		try {
			String fileName = "保险信息-"+System.currentTimeMillis()+".xls";
			String agent = request.getHeader("User-Agent");
            boolean isMSIE = (agent != null && agent.indexOf("MSIE") != -1);
            if( isMSIE ){
            	fileName = java.net.URLEncoder.encode(fileName,"UTF8");
            }else{
            	//兼容火狐，否则中文乱码
            	fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
            }
			response.reset();
			response.setContentType("application/vnd.ms-excel");
			response.setCharacterEncoding("UTF-8");
			response.setHeader("content-Disposition", "attachment;filename=" + fileName);
			OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new WebJsonBean(CODE.SUCCESS);
	}
	 
	// 导出保险到期12311111
	@ResponseBody
	@RequestMapping(value = "/exportExpiryInsurance")
	public WebJsonBean exportExpiryInsurance(InsuranceEO insuranceEO, HttpServletRequest request, 
			HttpServletResponse response) {
		HSSFWorkbook wb = new HSSFWorkbook();
		// sheet 对应一个工作页
		Sheet sheet = wb.createSheet("保险信息");
		// 创建第一行为标题行
		Row hssfRow = sheet.createRow(0);
		Cell hssfCell = hssfRow.createCell(0);
		String[] titleArr = {"编号","车牌号","车辆所属","保险单号","保单类型","资产状态","车型","车辆年限","保险公司",
				"起效日期","失效日期","有效/失效","总保费用"};
		int i = 0;
		/* for循环生成列名 */
		for (String key : titleArr) {
			hssfCell = hssfRow.createCell(i);
			hssfCell.setCellValue(key);
			i++;
		}
		insuranceEO.setStatus(0);//失效
		List<InsuranceVo> resultList = insuranceService.queryInsuranceList(insuranceEO);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		// 填充数据
		for (int j = 1; j <= resultList.size(); j++) {
			InsuranceVo vo = resultList.get(j-1);
			hssfRow = sheet.createRow(j);
			
			hssfCell = hssfRow.createCell(0);
			hssfCell.setCellValue(vo.getCode());
			hssfCell = hssfRow.createCell(1);
			hssfCell.setCellValue(vo.getCarNo());
			hssfCell = hssfRow.createCell(2);
			hssfCell.setCellValue(vo.getAssets_belong());
			hssfCell = hssfRow.createCell(3);
			hssfCell.setCellValue(vo.getInsuranceNo());
			hssfCell = hssfRow.createCell(4);
			hssfCell.setCellValue(vo.getInsuranceType());
			hssfCell = hssfRow.createCell(5);
			hssfCell.setCellValue(vo.getAssets_state());
			hssfCell = hssfRow.createCell(6);
			hssfCell.setCellValue(vo.getVehicle_type());
			hssfCell = hssfRow.createCell(7);
			hssfCell.setCellValue(vo.getCarAgeLimit());
			hssfCell = hssfRow.createCell(8);
			hssfCell.setCellValue(vo.getInsuranceCompany());
			hssfCell = hssfRow.createCell(9);
			hssfCell.setCellValue(format.format(vo.getWorkDate()));
			hssfCell = hssfRow.createCell(10);
			hssfCell.setCellValue(format.format(vo.getExpiryDate()));
			hssfCell = hssfRow.createCell(11);
			hssfCell.setCellValue(vo.getStatus());
			hssfCell = hssfRow.createCell(12);
			hssfCell.setCellValue(vo.getInsuranceTotalAmount() == null ? "0.00" : vo.getInsuranceTotalAmount().toString());
		}
		for (int a = 0; a <= i; a++) {
			sheet.autoSizeColumn(a);// 設置自動列寬
		}
		
		// 创建文件输出流，准备输出电子表格
		try {
			String fileName = "保险信息-"+System.currentTimeMillis()+".xls";
			String agent = request.getHeader("User-Agent");
			boolean isMSIE = (agent != null && agent.indexOf("MSIE") != -1);
			if( isMSIE ){
				fileName = java.net.URLEncoder.encode(fileName,"UTF8");
			}else{
				//兼容火狐，否则中文乱码
				fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
			}
			response.reset();
			response.setContentType("application/vnd.ms-excel");
			response.setCharacterEncoding("UTF-8");
			response.setHeader("content-Disposition", "attachment;filename=" + fileName);
			OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new WebJsonBean(CODE.SUCCESS);
	}
	
	 /**
     * 后台用户头像上传（图片）
     *
     * @param file     上传的文件
     * @param path     文件上传指定根目录下的目录
     * @param response
     * @param request
     * @throws IOException
     */
    @PostMapping(value = "/upload")
    @ResponseBody
    public ReturnDTO uploadTransImg(@PathVariable("type") String type, @RequestParam("file") MultipartFile file,
                                    HttpServletResponse response, HttpServletRequest request) throws IOException {

        response.setContentType("text/html; charset=UTF-8");

        List<Map<String, String> > rt=new ArrayList<>();

        rt.add( upload( type, null, file));

        return ReturnDTOUtil.success(rt);
    }

    private Map<String, String> upload(String type, String path, MultipartFile file){
        String uuid = FileUtils.createFileName();//创建文件名称

        String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();//扩展名

        String fileName = PathUtils.getUploadPath();
        if (!StringUtils.isEmpty(path)) {
        	fileName = fileName.replace("/", File.separator);
        	fileName = fileName.replace("\\", File.separator);
            fileName = fileName + File.separator + path;
        }
        
        String savePath = fileName + File.separator + type + File.separator + GzxantSysUser.id() + File.separator + uuid + "." + fileExt;//附件路径+类型（头像、附件等）+名称+扩展名
        File localFile = FileUtils.saveFileToDisk(file, savePath); //保存到磁盘

        String thumbnailName = "";
        if (FileUtils.getImageFormat(fileExt)) {
            //创建缩略图
            thumbnailName = fileName + File.separator + type + File.separator + GzxantSysUser.id() + File.separator + "s" + File.separator + uuid + "." + fileExt;//附件路径+类型（头像、附件等）+s(文件夹)+名称+扩展名
            FileUtils.createThumbnail(localFile, thumbnailName);
        }

        Map<String, String> rt = new HashMap<String, String>();

        rt.put("uuid", uuid);
        rt.put("path", Setting.BASEFLODER);
        rt.put("ext", fileExt);
        rt.put("url", savePath);
        rt.put("s_url", thumbnailName);
        rt.put("date", DateUtils.getCurDateTime());

        log.info("上传的文件地址为 fileName={}", savePath);
        return rt;
    }
}
