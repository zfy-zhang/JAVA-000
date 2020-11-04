package org.geekbang.java.netty.gateway.router;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import org.geekbang.java.netty.gateway.outbound.httpclient.HttpOutboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/11/1
 * @Modify
 * @since
 */
public class HttpEndpointRouterRandom implements HttpEndpointRouter {

    static Random random = new Random();

    @Override
    public String route(List<String> backendUrls) {
        return this.getRandom(backendUrls);
    }


    private String getRandom(List<String> backendUrls){
        int number = random.nextInt(backendUrls.size());
        return backendUrls.get(number);
    }

}
