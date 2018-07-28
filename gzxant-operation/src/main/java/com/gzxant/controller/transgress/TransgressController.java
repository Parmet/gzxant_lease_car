package com.gzxant.controller.transgress;

import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.gzxant.controller.util.ExcelUtil;
import com.gzxant.controller.vo.TransgressVo;
import com.gzxant.entity.transgress.Transgress;
import com.gzxant.service.transgress.TransgressService;

@Controller
@RequestMapping("/oper/trans")
public class TransgressController {

	@Autowired
	private TransgressService tgService;

	// 查询违章记录
	@ResponseBody
	@RequestMapping(value = "/query", method = RequestMethod.POST)
	public ResponseEntity<List<Transgress>> query(@RequestParam(value = "tgVo", required = false) TransgressVo tgVo) {
		List<Transgress> tgList;
		try {
			tgList = tgService.query(tgVo);
			return ResponseEntity.ok(tgList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	}

	// 导入
	@ResponseBody
	@RequestMapping(value = "/input", method = RequestMethod.POST)
	public ResponseEntity<Void> input(MultipartFile myFile, HttpServletResponse res) {
		List<String> errorList = new ArrayList<String>();
		try {
			ExcelUtil util = new ExcelUtil();
			InputStream input = null;
			List<List<Object>> lists = null;
			if (myFile.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
			} else {
				if (errorList.size() == 0) {
					String fileName = myFile.getOriginalFilename();
					input = myFile.getInputStream();
					lists = util.getBankListByExcel(input, fileName);
					input.close();
					// 循环将excel中的数据存入库
					for (int i = 1; i < lists.size(); i++) {
						List<Object> list = lists.get(i);
						Transgress tg = new Transgress();
						tg.setPlateNum(util.getFormat(String.valueOf(list.get(0))));
						tg.setType(util.getFormat(String.valueOf(list.get(1))));
						tg.setBrand(util.getFormat(String.valueOf(list.get(2))));
						tg.setDeduction(util.getFormats(Integer.parseInt(String.valueOf(list.get(3)))));
						tg.setFine(util.getFormats(Integer.parseInt(String.valueOf(list.get(4)))));
						tg.setAssetCompany(util.getFormat(String.valueOf(list.get(5))));
						tg.setOperateCompany(util.getFormat(String.valueOf(list.get(6))));
						tg.setCustomer(util.getFormat(String.valueOf(list.get(7))));
						tg.setTgTime(util.getDate(String.valueOf(list.get(8))));
						tg.setPlace(util.getFormat(String.valueOf(list.get(9))));
						tg.setReason(util.getFormat(String.valueOf(list.get(10))));
						tg.setDepartment(util.getFormat(String.valueOf(list.get(11))));
						String t1 = util.getFormat(String.valueOf(list.get(12)));
						tg.setCommisson("是".equals(t1));
						tg.setCode(util.getFormats(Integer.parseInt(String.valueOf(list.get(13)))));
						tg.setTgNum(util.getFormats(Integer.parseInt(String.valueOf(list.get(14)))));
						String t2 = util.getFormat(String.valueOf(list.get(15)));
						tg.setStatus("已处理".equals(t2));
						tg.setQueryTime(util.getDate(String.valueOf(list.get(16))));
						tg.setUpdateTime(util.getDate(String.valueOf(list.get(17))));
						tgService.add(tg);
					}
					return ResponseEntity.ok(null);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);

	}

	// 导出
	@ResponseBody
	@RequestMapping(value = "/output", method = RequestMethod.GET)
	public ResponseEntity<Void> output(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="tgVo",required=false) TransgressVo tgVo) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");

		List<Transgress> tgList = tgService.query(tgVo);
		// excel标题
		String[] title = { "车牌号", "车牌类型", "品牌", "扣分", "罚款", "资产公司", "经营公司", "客户", "违章时间", "违章地点", "违章原因", "违章采集机关",
				"是否可以代办", "违章代码", "违章项文书编号", "状态", "数据查询时间", "更新为已处理时间" };
		// excel文件名
		String fileName = "违章管理表" + format1.format(System.currentTimeMillis()) + ".xls";
		// sheet名
		String sheetName = "违章管理表";
		String[][] content = new String[tgList.size()][title.length];
		;
		if (tgList.isEmpty()) {
			for (int i = 0; i < tgList.size(); i++) {
				Transgress tg = tgList.get(i);
				content[i][0] = tg.getPlateNum();
				content[i][1] = tg.getType();
				content[i][2] = tg.getBrand();
				content[i][3] = tg.getDeduction().toString();
				content[i][4] = tg.getFine().toString();
				content[i][5] = tg.getAssetCompany();
				content[i][6] = tg.getOperateCompany();
				content[i][7] = tg.getCustomer();
				content[i][8] = format.format(tg.getTgTime());
				content[i][9] = tg.getPlace();
				content[i][10] = tg.getReason();
				content[i][11] = tg.getDepartment();
				content[i][12] = tg.getCommisson() ? "是" : "否";
				content[i][13] = tg.getCode().toString();
				content[i][14] = tg.getTgNum().toString();
				content[i][15] = tg.getStatus() ? "已处理" : "未处理";
				content[i][16] = format.format(tg.getQueryTime());
				content[i][17] = format.format(tg.getUpdateTime());
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

}
