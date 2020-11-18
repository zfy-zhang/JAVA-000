package org.geekbang.java.starter.registry;

/**
 * @Description: 提供对实现类中的管理的单例bean集合进行操作的功能
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/10/13
 * @Modify
 * @since
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

    void addSingleton(String beanName, Object bean);
}
