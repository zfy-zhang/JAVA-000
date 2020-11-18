package org.geekbang.java.starter.resource;

import java.io.InputStream;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/10/14
 * @Modify
 * @since
 */
public class ClasspathResource implements Resource {
    // 封装classpath下的路径
    private String location;

    public ClasspathResource(String location) {
        this.location = location;
    }

    @Override
    public InputStream getResource() {
        if (location.startsWith("classpath:")){
            location = location.substring(10);
        }
        return this.getClass().getClassLoader().getResourceAsStream(location);
    }
}
