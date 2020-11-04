package org.geekbang.java.netty.gateway.inbound;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpRequest;
import org.geekbang.java.netty.gateway.filter.AddHttpRequestFilter;
import org.geekbang.java.netty.gateway.filter.HttpRequestFilter;
import org.geekbang.java.netty.gateway.outbound.httpclient.HttpOutboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/11/2
 * @Modify
 * @since
 */
public class HttpInboundHandler extends ChannelInboundHandlerAdapter {

    private static Logger logger = LoggerFactory.getLogger(HttpInboundHandler.class);
    private final List<String> proxyServer;
    private HttpOutboundHandler handler;

    public HttpInboundHandler(List<String> proxyServer) {
        this.proxyServer = proxyServer;
        handler = new HttpOutboundHandler(this.proxyServer);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        logger.info("channelRead流量接口请求开始------");
        FullHttpRequest fullHttpRequest = (FullHttpRequest)msg;
        String uri = fullHttpRequest.uri();
        logger.info("接收到的请求URL为{}",uri);
        HttpRequestFilter httpRequestFilter = new AddHttpRequestFilter();
        httpRequestFilter.filter(fullHttpRequest,ctx);
        handler.handle(fullHttpRequest,ctx);
    }
}
