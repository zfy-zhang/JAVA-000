package org.geekbang.java.starter.utils;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;

import java.io.InputStream;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/10/14
 * @Modify
 * @since
 */
public class DocumentUtils {
    public static Document getDocument(InputStream inputStream){
        try {
            SAXReader reader = new SAXReader();
            return reader.read(inputStream);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
