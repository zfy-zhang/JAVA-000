package org.geekbang.java.httpclient;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Description: 通过 url 地址获取 {@link HttpURLConnection}
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/10/26
 * @Modify
 * @since
 */
public class URLConnectionResources {

    public static HttpURLConnection getUrlConnection(String httpUrl) {
        try {
            URL url = new URL(httpUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            return urlConnection;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
