package com.alisha.rpcfx.core.server;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
public interface RpcResolver {

    /**
     * @param serviceClass
     * @return
     */
    Object resolve(String serviceClass);

}
