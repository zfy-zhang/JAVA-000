package org.geekbang.java.starter.registry;

import org.geekbang.java.starter.ioc.BeanDefinition;

import java.util.List;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/10/13
 * @Modify
 * @since
 */
public interface BeanDefinitionRegistry {

    BeanDefinition getBeanDefinition(String beanName);

    List<BeanDefinition> getBeanDefinitions();

    void registryBeanDefinition(String beanName, BeanDefinition bd);
}
