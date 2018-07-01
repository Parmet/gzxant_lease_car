package com.gzxant.util.image.ocr.baidu;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.baidu.aip.ocr.AipOcr;

public class ImageUtils {
	public static final String APP_ID = "11424463";
    public static final String API_KEY = "Mxh7kRFLyLKtyx74AiVegsKO";
    public static final String SECRET_KEY = "0GCFmH9KVD6rnOpWF2uWaPTU1Mt6Taqm";
	
	public static String image2Str(String image) {
		AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
		
		HashMap<String, String> options = new HashMap<String, String>();
	    options.put("language_type", "CHN_ENG");
	    options.put("detect_direction", "true");
	    options.put("detect_language", "true");
	    options.put("probability", "true");

	    // 参数为本地图片路径
	    StringBuffer result = new StringBuffer();
	    JSONObject res = client.basicGeneral(image, options);
	    try {
	    	JSONArray words = res.getJSONArray("words_result");
	    	JSONObject row = null; 
			for (int i = 0; i < words.length(); i++) { 
				row = words.getJSONObject(i); 
				result.append(String.valueOf(row.get("words")));
				result.append(System.lineSeparator());
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	    
		return result.toString();
	}
/*	
	public static void main(String[] args) {
		ImageUtils.image2Str("F:\\app\\attach\\equipment\\manage\\pdf\\983254018612576257\\15282786025326179\\6.jpg");
	}*/
}

