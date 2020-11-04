package org.geekbang.java.netty.gateway;

import org.geekbang.java.netty.gateway.inbound.HttpInboundServer;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/11/1
 * @Modify
 * @since
 */
public class NettyServerApplication {

    public final static String GATEWAY_NAME = "NIOGateway";
    public final static String GATEWAY_VERSION = "1.0.0";

    public static void main(String[] args) {
        String proxyServer = System.getProperty("proxyServer1","http://localhost:8088");
        String proxyPort = System.getProperty("proxyPort","8888");

        //  http://localhost:8888/api/hello  ==> gateway API
        //  http://localhost:8088/api/hello  ==> backend service

        int port = Integer.parseInt(proxyPort);
        List<String> proxyServerList = new ArrayList<>();
        proxyServerList.add(proxyServer);

        HttpInboundServer server = new HttpInboundServer(port, proxyServerList);
        System.out.println(GATEWAY_NAME + " " + GATEWAY_VERSION +" started at http://localhost:" + port + " for server:" + proxyServerList);
        try {
            server.run();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
