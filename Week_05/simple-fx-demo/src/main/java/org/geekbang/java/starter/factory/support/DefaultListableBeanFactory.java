package org.geekbang.java.starter.factory.support;

import org.geekbang.java.starter.ioc.BeanDefinition;
import org.geekbang.java.starter.registry.BeanDefinitionRegistry;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/10/13
 * @Modify
 * @since
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    @Override
    public BeanDefinition getBeanDefinition(String beanName) {
        return this.beanDefinitionMap.get(beanName);
    }

    @Override
    public List<BeanDefinition> getBeanDefinitions() {
        // TODO
        return null;
    }

    @Override
    public void registryBeanDefinition(String beanName, BeanDefinition bd) {
        this.beanDefinitionMap.put(beanName, bd);
    }
}
