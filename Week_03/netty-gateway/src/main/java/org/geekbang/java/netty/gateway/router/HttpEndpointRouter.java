package org.geekbang.java.netty.gateway.router;

import java.util.List;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/11/1
 * @Modify
 * @since
 */
public interface HttpEndpointRouter {
    String route(List<String> backendUrl);
}
