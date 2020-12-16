package com.alisha.rpcfx.core.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RpcResponse {

    private Object result;

    private boolean status;

    private Exception exception;
}
