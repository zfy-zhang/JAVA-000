package org.geekbang.java.starter.factory;

import java.util.List;

/**
 * @Description: 可列表操作的 Bean 工厂
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/10/13
 * @Modify
 * @since
 */
public interface ListableBeanFactory extends BeanFactory {

    /**
     * 根据给定类型，获取它以及它子类的所有实例
     * @param type
     * @param <T>
     * @return
     */
    <T> List<T> getBeanByType(Class type);

    /**
     *
     * @param type
     * @return
     */
    List<String> getBeanNameByType(Class type);
}
