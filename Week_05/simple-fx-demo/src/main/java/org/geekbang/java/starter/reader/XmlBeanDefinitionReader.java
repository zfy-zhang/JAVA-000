package org.geekbang.java.starter.reader;


import org.dom4j.Document;
import org.geekbang.java.starter.registry.BeanDefinitionRegistry;
import org.geekbang.java.starter.utils.DocumentUtils;

import java.io.InputStream;

/**
 * @Description: 它主要是针对流对象进行读取
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/10/14
 * @Modify
 * @since
 */
public class XmlBeanDefinitionReader {
    private BeanDefinitionRegistry registry;

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    public void loadBeanDefinitions(InputStream inputStream) {
        // 创建文档对象
        Document document = DocumentUtils.getDocument(inputStream);
        XmlBeanDefinitionDocumentReader documentReader = new XmlBeanDefinitionDocumentReader(registry);
        documentReader.registerBeanDefinitions(document.getRootElement());
    }
}
