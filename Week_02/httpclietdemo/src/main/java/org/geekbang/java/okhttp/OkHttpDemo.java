package org.geekbang.java.okhttp;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/10/26
 * @Modify
 * @since
 */
public class OkHttpDemo {

    public static void main(String[] args) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Response res;
        String url = "http://localhost:8808/test";
        Request req = new Request.Builder().url(url).get().build();
        try {
            res = okHttpClient.newCall(req).execute();
            System.out.println(res.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
