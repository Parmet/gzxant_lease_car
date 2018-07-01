package com.gzxant.util.image.ocr;

import com.alibaba.cloudapi.sdk.core.BaseApiClient;
import com.alibaba.cloudapi.sdk.core.BaseApiClientBuilder;
import com.alibaba.cloudapi.sdk.core.annotation.NotThreadSafe;
import com.alibaba.cloudapi.sdk.core.enums.Method;
import com.alibaba.cloudapi.sdk.core.enums.Scheme;
import com.alibaba.cloudapi.sdk.core.model.ApiRequest;
import com.alibaba.cloudapi.sdk.core.model.ApiResponse;
import com.alibaba.cloudapi.sdk.core.model.BuilderParams;

public class SyncApiClient extends BaseApiClient {

	public final static String GROUP_HOST = "tysbgpu.market.alicloudapi.com";

    private SyncApiClient(BuilderParams builderParams) {
        super(builderParams);
    }

    @NotThreadSafe
    public static class Builder extends BaseApiClientBuilder<SyncApiClient.Builder, SyncApiClient>{

        @Override
        protected SyncApiClient build(BuilderParams params) {
            return new SyncApiClient(params);
        }
    }

    public static Builder newBuilder(){
        return new SyncApiClient.Builder();
    }

    public static SyncApiClient getInstance(){
        return getApiClassInstance(SyncApiClient.class);
    }

    public ApiResponse ocr(String userid, byte[] _body) {
        String _apiPath = "/api/predict/ocr_general";

        ApiRequest _apiRequest = new ApiRequest(Scheme.HTTP, Method.POST_BODY, GROUP_HOST, _apiPath, _body);

        return syncInvoke(_apiRequest);
    }
}
