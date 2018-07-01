package com.gzxant.util.image.ocr;

import com.alibaba.cloudapi.sdk.core.model.ApiCallBack;
import com.alibaba.cloudapi.sdk.core.model.ApiRequest;
import com.alibaba.cloudapi.sdk.core.model.ApiResponse;

public class OcrAsyncApi {

	private AsyncApiClient asyncClient = null;

    public OcrAsyncApi() {
        this.asyncClient = AsyncApiClient.newBuilder()
                .appKey("24852692")
                .appSecret("b75ce150943933a40e981b1c2d754039")
                .build();
    }

    public void ocr(byte[] body) {
        asyncClient.ocr("OcrService.aspx", body, new ApiCallBack() {
            @Override
            public void onFailure(ApiRequest request, Exception e) {
                System.out.println("failure");
                e.printStackTrace();
            }

            @Override
            public void onResponse(ApiRequest request, ApiResponse response) {
                System.out.println("success");
                printResponse(response);
            }
        });
    }

    private static void printResponse(ApiResponse response) {
        try {
            System.out.println("response code = " + response.getStatusCode());
            System.out.println("response content = " + new String(response.getBody(), "utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
