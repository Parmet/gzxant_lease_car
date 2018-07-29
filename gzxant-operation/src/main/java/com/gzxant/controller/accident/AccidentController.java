package com.gzxant.controller.accident;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gzxant.base.vo.DataTable;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.gzxant.base.entity.ReturnDTO;
import com.gzxant.constant.Setting;
import com.gzxant.controller.util.ExcelUtil;
import com.gzxant.controller.vo.AccidentVo;
import com.gzxant.entity.accident.Accident;
import com.gzxant.entity.transgress.Transgress;
import com.gzxant.enums.AccidentGrade;
import com.gzxant.enums.AccidentOperNature;
import com.gzxant.enums.AccidentStatus;
import com.gzxant.enums.AccidentUseNature;
import com.gzxant.service.accident.AccidentService;
import com.gzxant.shiro.GzxantSysUser;
import com.gzxant.util.DateUtils;
import com.gzxant.util.FileUtils;
import com.gzxant.util.PathUtils;
import com.gzxant.util.ReturnDTOUtil;

@Controller
@RequestMapping("/oper/accident")
public class AccidentController {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private AccidentService aService;

	/**
	 * 上传文件
     * @param file     上传的文件
     * @param path     文件上传指定根目录下的目录
     */
    @PostMapping(value = "/upload/{type}")
    @ResponseBody
    public ReturnDTO uploadTransImg(@PathVariable("type") String type, @RequestParam("file") MultipartFile file,
                                    @RequestParam(value = "path", defaultValue = "") String path,
                                    HttpServletResponse response, HttpServletRequest request) throws IOException {

        response.setContentType("text/html; charset=UTF-8");

        List<Map<String, String> > rt=new ArrayList<>();

        rt.add( upload( type, path, file));

        return ReturnDTOUtil.success(rt);
    }

    private Map upload(String type, String path, MultipartFile file){
        String uuid = FileUtils.createFileName();//创建文件名称

        String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();//扩展名

        String fileName = PathUtils.getUploadPath();
        if (StringUtils.isNotBlank(path)) {
        	fileName = fileName.replace("/", File.separator);
        	fileName = fileName.replace("\\", File.separator);
            fileName = fileName + File.separator + path;
        }
        
        String savePath = fileName + File.separator + type + File.separator + GzxantSysUser.id() + File.separator + uuid + "." + fileExt;//附件路径+类型（头像、附件等）+名称+扩展名
        File localFile = FileUtils.saveFileToDisk(file, savePath); //保存到磁盘


        Map<String, String> rt = new HashMap<String, String>();

        rt.put("uuid", uuid);
        rt.put("path", Setting.BASEFLODER);
        rt.put("ext", fileExt);
        rt.put("url", savePath);
        rt.put("date", DateUtils.getCurDateTime());

        logger.info("上传的文件地址为 fileName={}", savePath);
        return rt;
    }

    //添加
    @ResponseBody
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResponseEntity<List<Accident>> insert(@RequestParam(value="accident")Accident accident) {
		try {
			aService.insert(accident);
			return ResponseEntity.ok(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	}
    
    //查询
 	@ResponseBody
 	@RequestMapping(value = "/query", method = RequestMethod.POST)
 	public ResponseEntity<List<Accident>> query(@RequestParam(value = "aVo", required = false) AccidentVo aVo) {
 		List<Accident> aList;
 		try {
 			aList = aService.query(aVo);
 			return ResponseEntity.ok(aList);
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
 	}
 	
 	// 导出
 	@ResponseBody
 	@RequestMapping(value = "/output", method = RequestMethod.POST)
 	public ResponseEntity<Void> output(HttpServletRequest request, HttpServletResponse response,
 			@RequestParam(value="aVo",required=false) AccidentVo aVo) {

 		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

 		List<Accident> aList = aService.query(aVo);
 		// excel标题
 		String[] title = { "车牌号", "品牌", "车型", "车架号", "事故日期", "驾驶员", "事故地址", 
 				"事故详细", "使用性质", "事故性质", "责任划分","轻伤(人)", "重伤(人)", "死亡(人)", 
 				"我方经济损失", "我方医疗费用", "三者经济损失","三者医疗费用","已赔付金额","事故等级",
 				"处理状态","事故处理进度","备注" };
 		// excel文件名
 		String fileName = "违章管理表" + format.format(System.currentTimeMillis()) + ".xls";
 		// sheet名
 		String sheetName = "违章管理表";
 		String[][] content = new String[aList.size()][title.length];
 		;
 		if (aList.isEmpty()) {
 			for (int i = 0; i < aList.size(); i++) {
 				Accident accident = aList.get(i);
 				content[i][0] = accident.getPlateNum();
 				content[i][1] = accident.getBrand();
 				content[i][2] = accident.getModelNum();
 				content[i][3] = accident.getVin();
 				content[i][4] = format.format(accident.getAccidentTime());
 				content[i][5] = accident.getDriver();
 				content[i][6] = accident.getAccidentPlace();
 				content[i][7] = accident.getDetails();
 				content[i][8] = AccidentUseNature.getName(accident.getUseNature());
 				content[i][9] = AccidentOperNature.getName(accident.getOperNature());
 				content[i][10] = AccidentOperNature.getName(accident.getResponsibilityDivide());
 				content[i][11] = accident.getMinorWound().toString();
 				content[i][12] = accident.getSeriousInjury().toString();
 				content[i][13] = accident.getDeath().toString();
 				content[i][14] = accident.getMyselfLoss().toString();
 				content[i][15] = accident.getMyselfTreatmentCost().toString();
 				content[i][16] = accident.getThirdPartyLoss().toString();
 				content[i][17] = accident.getThirdPartyTreatmentCost().toString();
 				content[i][18] = accident.getReimbursementCost().toString();
 				content[i][19] = AccidentGrade.getName(accident.getGrade());
 				content[i][20] = AccidentStatus.getName(accident.getStatus());
 				content[i][21] = accident.getSchedule();
 				content[i][22] = accident.getRemake();
 			}
 		}
 		try {
 			// 创建HSSFWorkbook
 			HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);
 			ExcelUtil.setResponseHeader(response, fileName);
 			OutputStream os = response.getOutputStream();
 			wb.write(os);
 			os.flush();
 			os.close();
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
 	}
 	
 	//根据id查询
 	@ResponseBody
 	@RequestMapping(value="getAccidentById",method=RequestMethod.POST)
 	public ResponseEntity<Accident> getAccidentById(@RequestParam(value="id")Integer id){
 		try {
			Accident accident = aService.getAccidentById(id);
			if(accident != null){
				return ResponseEntity.ok(accident);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
 	}
 	
 	//修改
 	@ResponseBody
 	@RequestMapping(value="update",method=RequestMethod.POST)
 	public ResponseEntity<Void> update(@RequestParam(value="accident")Accident accident){
 			aService.update(accident);
 			return ResponseEntity.ok(null);
 	}
 	
 	//删除
 	@ResponseBody
 	@RequestMapping(value="delete",method=RequestMethod.POST)
 	public ResponseEntity<Void> delete(@RequestParam(value="id")Integer id){
 		aService.delete(id);
 		return ResponseEntity.ok(null);
 	}
}
