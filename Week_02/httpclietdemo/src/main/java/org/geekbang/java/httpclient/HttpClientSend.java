package org.geekbang.java.httpclient;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/10/26
 * @Modify
 * @since
 */
public interface HttpClientSend {

    /**
     * get 提交方式
     * @param url
     * @return
     */
    String doGet(String url);

    /**
     * post 提交方式
     * @param url
     * @param param
     * @return
     */
    String doPost(String url, String param);

}
