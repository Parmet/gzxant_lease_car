package com.gzxant.util.image.ocr;

import com.alibaba.cloudapi.sdk.core.BaseApiClient;
import com.alibaba.cloudapi.sdk.core.BaseApiClientBuilder;
import com.alibaba.cloudapi.sdk.core.annotation.NotThreadSafe;
import com.alibaba.cloudapi.sdk.core.annotation.ThreadSafe;
import com.alibaba.cloudapi.sdk.core.enums.Method;
import com.alibaba.cloudapi.sdk.core.enums.ParamPosition;
import com.alibaba.cloudapi.sdk.core.enums.Scheme;
import com.alibaba.cloudapi.sdk.core.model.ApiCallBack;
import com.alibaba.cloudapi.sdk.core.model.ApiRequest;
import com.alibaba.cloudapi.sdk.core.model.BuilderParams;

@ThreadSafe
public class AsyncApiClient extends BaseApiClient {

	public final static String GROUP_HOST = "ocr.market.alicloudapi.com";

    private AsyncApiClient(BuilderParams builderParams) {
        super(builderParams);
    }

    @NotThreadSafe
    public static class Builder extends BaseApiClientBuilder<AsyncApiClient.Builder, AsyncApiClient>{

        @Override
        protected AsyncApiClient build(BuilderParams params) {
            return new AsyncApiClient(params);
        }
    }

    public static Builder newBuilder(){
        return new AsyncApiClient.Builder();
    }

    public static AsyncApiClient getInstance(){
        return getApiClassInstance(AsyncApiClient.class);
    }

    public void ocr(String userid, byte[] _body, ApiCallBack _callBack) {
        String _apiPath = "/aliyunapp/[userid]";

        ApiRequest _apiRequest = new ApiRequest(Scheme.HTTP, Method.POST_BODY, GROUP_HOST, _apiPath, _body);

        _apiRequest.addParam("userid", userid, ParamPosition.PATH, true);

        asyncInvoke(_apiRequest, _callBack);
    }
}
