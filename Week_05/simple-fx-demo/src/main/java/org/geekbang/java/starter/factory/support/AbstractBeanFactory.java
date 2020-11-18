package org.geekbang.java.starter.factory.support;

import org.geekbang.java.starter.factory.BeanFactory;
import org.geekbang.java.starter.ioc.BeanDefinition;
import org.geekbang.java.starter.registry.DefaultSingletonBeanRegistry;

/**
 * @Description: BeanFactory 的抽象实现
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/10/13
 * @Modify
 * @since
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String beanName) {

        // 1、先从 map 集合中查找
        Object singletonObject = getSingleton(beanName);

        // 2、如果存在，则直接返回
        if (singletonObject != null) {
            return singletonObject;
        }

        // 3、不存在，则从Bean的定义信息集合中查找对应的BeanDefinition
        BeanDefinition bd = getBeanDefinition(beanName);
        if (bd == null) {
            return  null;
        }

        // 4、判断该 Bean 是否为单例
        String scope = bd.getScope();
        if (bd.isSingleton()) {
            singletonObject = createBean(bd);
            addSingleton(beanName, singletonObject);
        } else if ("prototype".equals(scope)) {
            singletonObject = createBean(bd);
        }

        // 6、创建 Bean，加入单例 Bean 的集合
        return singletonObject;
    }

    /**
     * 使用抽象模板方法，将真正实现逻辑延续到子类去实现（DefaultListableBeanFactory）
     * @param name
     * @return
     */
    protected abstract BeanDefinition getBeanDefinition(String name);

    /**
     * 使用抽象模板方法，将真正实现逻辑延续到子类去实现（AbstractAutowireCapableBeanFactory）
     * @param bd
     * @return
     */
    protected abstract Object createBean(BeanDefinition bd);
}
