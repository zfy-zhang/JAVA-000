package com.alisha.rpcfx.core.server;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alisha.rpcfx.core.api.RpcRequest;
import com.alisha.rpcfx.core.api.RpcResponse;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
public class RpcInvoker {

    private RpcResolver resolver;

    public RpcInvoker(RpcResolver resolver) {
        this.resolver = resolver;
    }

    public RpcResponse invoke(RpcRequest request) {
        RpcResponse response = new RpcResponse();
        String serviceClass = request.getServiceClass();

        Object service = resolver.resolve(serviceClass);

        try {
            Method method = resolveMethodFromClass(service.getClass(), request.getMethod());
            Object result = method.invoke(service, request.getParams());
            response.setResult(JSON.toJSONString(result, SerializerFeature.WriteClassName));
            response.setStatus(true);
            return response;
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException e) {

            e.printStackTrace();
            response.setException(e);
            response.setStatus(false);
            return response;
        }
    }

    private Method resolveMethodFromClass(Class<?> klass, String methodName) {
        Optional<Method> methodOptional = Arrays.stream(klass.getMethods())
                .filter(m -> methodName.equals(m.getName()))
                .findFirst();
        if (methodOptional.isPresent()) {
            return methodOptional.get();
        }
        throw new IllegalArgumentException("方法不存在");
    }

}
