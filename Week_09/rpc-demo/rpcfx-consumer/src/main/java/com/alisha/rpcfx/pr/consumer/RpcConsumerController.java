package com.alisha.rpcfx.pr.consumer;

import com.alisha.rpcfx.api.UserService;
import com.alisha.rpcfx.core.client.JdkRpcClient;
import com.alisha.rpcfx.core.client.RpcClient;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
@SpringBootApplication
public class RpcConsumerController {

    public static void main(String[] args) {
        RpcClient rpcClient = new JdkRpcClient();
        UserService userService = rpcClient.create(UserService.class, "http://localhost:8080/");
        userService.findById(1);
    }

}