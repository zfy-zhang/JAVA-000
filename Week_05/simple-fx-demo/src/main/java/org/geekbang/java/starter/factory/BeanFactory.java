package org.geekbang.java.starter.factory;

/**
 * @Description: Spring IOC 容器
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/10/13
 * @Modify
 * @since
 */
public interface BeanFactory {

    /**
     * 根据 bean 名称获取对应的实例
     * @param beanName
     * @return
     */
    Object getBean(String beanName);
}
