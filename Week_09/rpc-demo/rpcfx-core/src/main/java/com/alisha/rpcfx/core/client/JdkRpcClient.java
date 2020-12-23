package com.alisha.rpcfx.core.client;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alisha.rpcfx.core.api.RpcRequest;
import com.alisha.rpcfx.core.api.RpcResponse;
import com.alisha.rpcfx.core.util.HttpClient;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
public final class JdkRpcClient implements RpcClient {

    static {
        ParserConfig.getGlobalInstance().addAccept("com.alisha.rpcfx");

        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
    }

    @Override
    public <T> T create(final Class<T> serviceClass, final String url) {
        ClassLoader classLoader = JdkRpcClient.class.getClassLoader();

        return (T) Proxy.newProxyInstance(classLoader, new Class[]{serviceClass}, new RpcInvocationHandler(serviceClass, url));

    }

    public static class RpcInvocationHandler implements InvocationHandler {

        private final Class<?> serviceClass;
        private final String url;

        public <T> RpcInvocationHandler(Class<T> serviceClass, String url) {
            this.serviceClass = serviceClass;
            this.url = url;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] params) throws Throwable {
            RpcRequest request = new RpcRequest();
            request.setServiceClass(this.serviceClass.getSimpleName());
            request.setMethod(method.getName());
            request.setParams(params);

            RpcResponse response = HttpClient.post(request, url);
            return JSON.parse(response.getResult().toString());
        }
    }
}
