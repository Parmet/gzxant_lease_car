package com.gzxant.util.image.ocr;

import com.alibaba.cloudapi.sdk.core.model.ApiResponse;

public class OcrSyncApi {
	private SyncApiClient syncClient = null;

    public OcrSyncApi() {
        this.syncClient = SyncApiClient.newBuilder()
                .appKey("24852692")
                .appSecret("b75ce150943933a40e981b1c2d754039")
                .build();
    }

    public String ocr(byte[] body) {
        ApiResponse response = syncClient.ocr("OcrService.aspx", body);
        System.out.println("response code = " + response.getStatusCode());
        if (response.getStatusCode() != 200) {
    		System.out.println("response message = " + response.getMessage());
    	}
        
        return printResponse(response);
    }

    private static String printResponse(ApiResponse response) {
        try {
        	String content = new String(response.getBody(), "utf-8");
            System.out.println("response content = " + content);
            return content;
        } catch (Exception e) {
            e.printStackTrace();
        } 
        
        return "";
    }
}
