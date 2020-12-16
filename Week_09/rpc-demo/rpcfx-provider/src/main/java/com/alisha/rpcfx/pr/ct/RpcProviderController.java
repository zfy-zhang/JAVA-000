package com.alisha.rpcfx.pr.ct;

import com.alisha.rpcfx.core.api.RpcRequest;
import com.alisha.rpcfx.core.api.RpcResponse;
import com.alisha.rpcfx.core.server.RpcInvoker;
import com.alisha.rpcfx.core.server.RpcResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
@RestController
public class RpcProviderController {

    @Autowired
    private RpcResolver rpcResolver;


    @PostMapping("/")
    public RpcResponse invoke(@RequestBody RpcRequest rpcRequest) {
        RpcInvoker rpcInvoker = new RpcInvoker(rpcResolver);
        return rpcInvoker.invoke(rpcRequest);
    }
}
