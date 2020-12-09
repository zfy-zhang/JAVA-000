package org.geekbang.java.httpclient;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/10/26
 * @Modify
 * @since
 */
public class MainTest {

    public static void main(String[] args) {
        HttpClientUtils hcu = new HttpClientUtils();
        String res = hcu.doPost("https://www.baidu.com?tstmp="+Math.random(),"p=2");
//        String res = hcu.doGet("http://localhost:8808/test");
        System.out.println(res);
    }
}
