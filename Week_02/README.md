## 学习笔记

#### 作业六：（Week02 作业题目（周六））
``要求：写一段代码，使用 HttpClient 或 OkHttp 访问 http://localhost:8801 ，代码提交到 Github。
``

###### HttpURLConnection类：HttpURLConnection 获取类
```java
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
```

###### HttpClientSend类：发送方式接口
```java
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
```

###### HttpClientUtils类：HttpClientSend 的实现类
```java
package org.geekbang.java.httpclient;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

import static org.geekbang.java.httpclient.URLConnectionResources.getUrlConnection;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/10/26
 * @Modify
 * @since
 */
public class HttpClientUtils implements HttpClientSend {


    public String doGet(String url) {

        InputStream is = null;
        BufferedReader br = null;
        // 返回结果
        String result = null;
        HttpURLConnection connection = getUrlConnection(url);

        try {
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(15000);
            connection.setReadTimeout(40000);
            connection.connect();

            if (connection.getResponseCode() == 200) {
                // 通过connection连接，获取输入流
                is = connection.getInputStream();
                // 封装输入流is，并指定字符集
                br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                // 存放数据
                StringBuffer sbf = new StringBuffer();
                String temp = null;
                while ((temp = br.readLine()) != null) {
                    sbf.append(temp);
                    sbf.append("\r\n");
                }
                result = sbf.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            // 关闭远程连接
            connection.disconnect();
        }
        return result;
    }

    public String doPost(String url, String param) {

        InputStream is = null;
        OutputStream os = null;
        BufferedReader br = null;
        String result = null;
        HttpURLConnection connection = null;

        try {
            connection = getUrlConnection(url);

            // 设置连接请求方式
            connection.setRequestMethod("POST");
            // 设置连接主机服务器超时时间：15000毫秒
            connection.setConnectTimeout(15000);
            // 设置读取主机服务器返回数据超时时间：60000毫秒
            connection.setReadTimeout(60000);

            // 默认值为：false，当向远程服务器传送数据/写数据时，需要设置为true
            connection.setDoOutput(true);
            // 默认值为：true，当前向远程服务读取数据时，设置为true
            // connection.setDoInput(true);
            // 设置传入参数的格式:请求参数应该是 key1=value1&key2=value2 的形式。
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            // 设置鉴权信息：Authorization: Bearer da3efcbf-0845-4fe3-8aba-ee040be542c0
            connection.setRequestProperty("Authorization", "Bearer da3efcbf-0845-4fe3-8aba-ee040be542c0");
            // 通过连接对象获取一个输出流
            os = connection.getOutputStream();
            // 通过输出流对象将参数写出去/传输出去,它是通过字节数组写出的
            os.write(param.getBytes());
            // 通过连接对象获取一个输入流，向远程读取
            if (connection.getResponseCode() == 200) {

                is = connection.getInputStream();
                // 对输入流对象进行包装:charset根据工作项目组的要求来设置
                br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

                StringBuffer sbf = new StringBuffer();
                String temp = null;
                // 循环遍历一行一行读取数据
                while ((temp = br.readLine()) != null) {
                    sbf.append(temp);
                    sbf.append("\r\n");
                }
                result = sbf.toString();
            }
        } catch (
        MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != os) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            // 断开与远程地址url的连接
            connection.disconnect();
        }
        return result;
    }
}
```

##### MainTest: 测试类
```java
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
//        String res = hcu.doPost("https://www.baidu.com?tstmp="+Math.random(),"p=2");
        String res = hcu.doGet("http://localhost:8808/test");
        System.out.println(res);
    }
}
```
###### httpClient 执行结果：
``
get方式：hello,kimmking
post方式结果： 
<!DOCTYPE html>
    <!--STATUS OK--><html> <head><meta http-equiv=content-type content=text/html;charset=utf-8><meta http-equiv=X-UA-Compatible content=IE=Edge><meta content=always name=referrer><link rel=stylesheet type=text/css href=https://ss1.bdstatic.com/5eN1bjq8AAUYm2zgoY3K/r/www/cache/bdorz/baidu.min.css><title>百度一下，你就知道</title></head> <body link=#0000cc> <div id=wrapper> <div id=head> <div class=head_wrapper> <div class=s_form> <div class=s_form_wrapper> <div id=lg> <img hidefocus=true src=//www.baidu.com/img/bd_logo1.png width=270 height=129> </div> <form id=form name=f action=//www.baidu.com/s class=fm> <input type=hidden name=bdorz_come value=1> <input type=hidden name=ie value=utf-8> <input type=hidden name=f value=8> <input type=hidden name=rsv_bp value=1> <input type=hidden name=rsv_idx value=1> <input type=hidden name=tn value=baidu><span class="bg s_ipt_wr"><input id=kw name=wd class=s_ipt value maxlength=255 autocomplete=off autofocus=autofocus></span><span class="bg s_btn_wr"><input type=submit id=su value=百度一下 class="bg s_btn" autofocus></span> </form> </div> </div> <div id=u1> <a href=http://news.baidu.com name=tj_trnews class=mnav>新闻</a> <a href=https://www.hao123.com name=tj_trhao123 class=mnav>hao123</a> <a href=http://map.baidu.com name=tj_trmap class=mnav>地图</a> <a href=http://v.baidu.com name=tj_trvideo class=mnav>视频</a> <a href=http://tieba.baidu.com name=tj_trtieba class=mnav>贴吧</a> <noscript> <a href=http://www.baidu.com/bdorz/login.gif?login&amp;tpl=mn&amp;u=http%3A%2F%2Fwww.baidu.com%2f%3fbdorz_come%3d1 name=tj_login class=lb>登录</a> </noscript> <script>document.write('<a href="http://www.baidu.com/bdorz/login.gif?login&tpl=mn&u='+ encodeURIComponent(window.location.href+ (window.location.search === "" ? "?" : "&")+ "bdorz_come=1")+ '" name="tj_login" class="lb">登录</a>');
          </script> <a href=//www.baidu.com/more/ name=tj_briicon class=bri style="display: block;">更多产品</a> </div> </div> </div> <div id=ftCon> <div id=ftConw> <p id=lh> <a href=http://home.baidu.com>关于百度</a> <a href=http://ir.baidu.com>About Baidu</a> </p> <p id=cp>&copy;2017&nbsp;Baidu&nbsp;<a href=http://www.baidu.com/duty/>使用百度前必读</a>&nbsp; <a href=http://jianyi.baidu.com/ class=cp-feedback>意见反馈</a>&nbsp;京ICP证030173号&nbsp; <img src=//www.baidu.com/img/gs.gif> </p> </div> </div> </div> </body> </html>
``

#### OkHttpDemo 类：OkHttp 的简单实现 Demo
```java
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
        Response response;
        String url = "http://localhost:8808/test";
        Request request = new Request.Builder().url(url).get().build();
        try {
            response = okHttpClient.newCall(request).execute();

            System.out.println(response.body().string());


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```


