package org.geekbang.java.starter.registry;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/10/13
 * @Modify
 * @since
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String, Object> singletonObject = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return this.singletonObject.get(beanName);
    }

    @Override
    public void addSingleton(String beanName, Object bean) {
        // TODO 可以使用双重检测检查锁的方式进行单例的处理
        this.singletonObject.put(beanName, bean);
    }
}
