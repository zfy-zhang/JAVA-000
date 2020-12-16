package com.alisha.rpcfx.core.util;

import com.alibaba.fastjson.JSON;
import com.alisha.rpcfx.core.api.RpcRequest;
import com.alisha.rpcfx.core.api.RpcResponse;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.IOException;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
@Slf4j
public class HttpClient {

    public static final MediaType JSON_TYPE = MediaType.get("application/json; charset=utf-8");

    public static RpcResponse post(RpcRequest req, String url) throws IOException {
        String reqJson = JSON.toJSONString(req);
        log.info("req:{}", reqJson);

        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .post(RequestBody.create(JSON_TYPE, reqJson))
                .build();
        String respJson = client.newCall(request).execute().body().string();
        log.info("resp:{}", respJson);
        return JSON.parseObject(respJson, RpcResponse.class);
    }
}
