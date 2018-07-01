package com.gzxant.util.image.ocr;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class ImageUtils {

	public static String img2Str(String img) {
		StringBuffer body = new StringBuffer();
		body.append("{\"image\":\"");
		body.append(getImageStr(img));
		body.append("\",\"configure\":\"{\\\"min_size\\\":16,\\\"output_prob\\\":true}\"}");
		if (body != null) {
			return "";
		}
		
		OcrSyncApi ocr = new OcrSyncApi();
		String result = ocr.ocr(body.toString().getBytes());
		
		StringBuffer content = new StringBuffer();
		try {
			JSONObject resultObject =JSONObject.parseObject(result);
			JSONArray rets = resultObject.getJSONArray("ret");
			JSONObject row = null; 
			for (int i = 0; i < rets.size(); i++) { 
				row = rets.getJSONObject(i); 
				content.append(String.valueOf(row.get("word")));
				content.append(System.lineSeparator());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(content.toString());
		return content.toString();
	}
	
	/**
	 * @Description: 将base64编码字符串转换为图片
	 * @Author: 
	 * @CreateTime: 
	 * @param imgStr base64编码字符串
	 * @param path 图片路径-具体到文件
	 * @return
	*/
	public static boolean generateImage(String imgStr, String path) {
		if (imgStr == null)
			return false;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// 解密
			byte[] b = decoder.decodeBuffer(imgStr);
			// 处理数据
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {
					b[i] += 256;
				}
			}
			
			OutputStream out = new FileOutputStream(path);
			out.write(b);
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	/**
	 * @Description: 根据图片地址转换为base64编码字符串
	 * @Author: 
	 * @CreateTime: 
	 * @return
	 */
	public static String getImageStr(String imgFile) {
	    InputStream inputStream = null;
	    byte[] data = null;
	    try {
	        inputStream = new FileInputStream(imgFile);
	        data = new byte[inputStream.available()];
	        inputStream.read(data);
	        inputStream.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    // 加密
	    BASE64Encoder encoder = new BASE64Encoder();
	    return encoder.encode(data);
	}
	
/*	public static void main(String[] args) {
		ImageUtils.img2Str("F:\\gzxant\\file\\项目\\设备检测\\需求文档\\标准pdf\\image\\0001.jpg");
	}*/

}
