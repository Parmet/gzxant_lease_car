package com.gzxant.controller.util;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	private final static String Excel_2003 = ".xls"; // 2003 版本的excel
	private final static String Excel_2007 = ".xlsx"; // 2007 版本的excel

	/**
	 * @param in
	 * @param fileName
	 * @param columNum
	 *            自定义列数
	 * @return
	 */
	public List<List<Object>> getBankListByExcel(InputStream in, String fileName) throws Exception {
		List<List<Object>> list = null;

		// 创建Excel工作簿
		Workbook work = this.getWorkbook(in, fileName);
		if (work == null) {
			throw new Exception("创建Excel工作簿为空！");
		}
		Sheet sheet = null;
		Row row = null;
		Cell cell = null;

		list = new ArrayList<List<Object>>();
		// 遍历Excel中的所有sheet
		for (int i = 0; i < work.getNumberOfSheets(); i++) {
			sheet = work.getSheetAt(i);
			if (sheet == null) {
				continue;
			}
			// 遍历当前sheet中的所有行
			// int totalRow =
			// sheet.getPhysicalNumberOfRows();//如果excel有格式，这种方式取值不准确
			int totalRow = sheet.getPhysicalNumberOfRows();
			for (int j = sheet.getFirstRowNum(); j < totalRow; j++) {
				row = sheet.getRow(j);
				if (row != null && !"".equals(row)) {
					// 获取第一个单元格的数据是否存在
					Cell fristCell = row.getCell(0);
					if (fristCell != null) {
						// 遍历所有的列
						List<Object> li = new ArrayList<Object>();
						// int totalColum = row.getLastCellNum();
						for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++) {
							cell = row.getCell(y);
							String callCal = this.getCellValue(cell) + "";
							li.add(callCal);
						}
						list.add(li);
					}
				}

			}
		}
		in.close();
		return list;
	}

	/**
	 * 描述：根据文件后缀，自动适应上传文件的版本
	 * 
	 * @param inStr,fileName
	 * @return
	 * @throws Exception
	 */
	public Workbook getWorkbook(InputStream inStr, String fileName) throws Exception {
		Workbook work = null;
		String fileType = fileName.substring(fileName.lastIndexOf("."));
		if (Excel_2003.equals(fileType)) {
			work = new HSSFWorkbook(inStr);// 2003 版本的excel
		} else if (Excel_2007.equals(fileType)) {
			work = new XSSFWorkbook(inStr);// 2007 版本的excel
		} else {
			throw new Exception("解析文件格式有误！");
		}
		return work;
	}

	/**
	 * 描述：对表格中数值进行格式化
	 * 
	 * @param cell
	 * @return
	 */
	public Object getCellValue(Cell cell) {
		Object value = null;
		DecimalFormat df1 = new DecimalFormat("0");// 格式化number，string字符
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 日期格式化
		DecimalFormat df2 = new DecimalFormat("0.00");// 格式化数字
		if (cell != null && !"".equals(cell)) {
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_STRING:
				value = cell.getRichStringCellValue().getString();
				break;
			case Cell.CELL_TYPE_NUMERIC:
				if ("General".equals(cell.getCellStyle().getDataFormatString())) {
					value = df1.format(cell.getNumericCellValue());
				} else if ("m/d/yy".equals(cell.getCellStyle().getDataFormatString())) {
					value = sdf.format(cell.getDateCellValue());
				} else if (HSSFDateUtil.isCellDateFormatted(cell)) {
					Date date = cell.getDateCellValue();
					value = sdf.format(date);
				} else {
					value = df2.format(cell.getNumericCellValue());
				}
				break;
			case Cell.CELL_TYPE_BOOLEAN:
				value = cell.getBooleanCellValue();
				break;
			case Cell.CELL_TYPE_BLANK:
				value = "";
				break;
			default:
				break;
			}
		}
		return value;
	}

	public String getFormat(String str) {
		if (str.equals("null")) {
			str = "";
			return str;
		} else {
			return str;
		}
	}

	public Integer getFormats(Integer str) {
		if (str == null) {
			str = 0;
			return str;
		} else {
			return str;
		}
	}

	public Date getDate(String str) throws ParseException {
		String result = getFormat(str);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 日期格式化
		return sdf.parse(result);
	}

	/**
	 * 导出Excel
	 * 
	 * @param sheetName
	 *            sheet名称
	 * @param title
	 *            标题
	 * @param values
	 *            内容
	 * @param wb
	 *            HSSFWorkbook对象
	 * @return
	 */
	public static HSSFWorkbook getHSSFWorkbook(String sheetName, String[] title, String[][] values, HSSFWorkbook wb) {

		// 第一步，创建一个HSSFWorkbook，对应一个Excel文件
		if (wb == null) {
			wb = new HSSFWorkbook();
		}

		// 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet(sheetName);

		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
		HSSFRow row = sheet.createRow(0);

		// 第四步，创建单元格，并设置值表头 设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

		// 声明列对象
		HSSFCell cell = null;

		// 创建标题
		for (int i = 0; i < title.length; i++) {
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}

		// 创建内容
		for (int i = 0; i < values.length; i++) {
			row = sheet.createRow(i + 1);
			for (int j = 0; j < values[i].length; j++) {
				// 将内容按顺序赋给对应的列对象
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		return wb;
	}

	/** 发送响应流方法 */
	public static void setResponseHeader(HttpServletResponse response, String fileName) {
		try {
			try {
				fileName = new String(fileName.getBytes(), "ISO8859-1");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			response.setContentType("application/octet-stream;charset=ISO8859-1");
			response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
			response.addHeader("Pargam", "no-cache");
			response.addHeader("Cache-Control", "no-cache");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
