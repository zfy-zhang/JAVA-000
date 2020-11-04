package org.geekbang.java.netty.gateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/11/2
 * @Modify
 * @since
 */
public class AddHttpRequestFilter implements HttpRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(AddHttpRequestFilter.class);

    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        fullRequest.headers().add("nio","zhangfy");
        logger.info("nio header add to full request");
    }
}
