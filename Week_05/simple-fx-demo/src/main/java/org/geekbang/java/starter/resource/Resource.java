package org.geekbang.java.starter.resource;

import java.io.InputStream;

/**
 * @Description: 提供对资源的操作功能（资源可能存在于磁盘的默认文件路径中，或者网络中，或者classpath下）
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/10/14
 * @Modify
 * @since
 */
public interface Resource {
    InputStream getResource();
}
