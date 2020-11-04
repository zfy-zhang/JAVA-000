package org.geekbang.java.netty.gateway.utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.Map;


/**
 * @Description: 突然发现上次写的代码不对，于是重写了一下
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/10/26
 * @Modify
 * @since
 */
public class HttpClientUtils {


    public static HttpUriRequest doGet(Map<String, String> headers,String url) {

        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        HttpGet httpGet = new HttpGet(url);

        try {
            httpClient = HttpClients.createDefault();

            headers.forEach((k,v) -> httpGet.setHeader(k,v));
            response = httpClient.execute(httpGet);

            HttpEntity entity = response.getEntity();
            String str = EntityUtils.toString(entity, "UTF-8");

        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭连接,释放资源
                if (response != null) {
                    response.close();
                }
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return httpGet;
    }
}
