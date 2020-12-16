package com.alisha.rpcfx.core.client;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
public interface RpcClient {

    /**
     * 创建rpc请求
     *
     * @param serviceClass
     * @param url
     * @param <T>
     * @return
     */
    <T> T create(final Class<T> serviceClass, final String url);


}
