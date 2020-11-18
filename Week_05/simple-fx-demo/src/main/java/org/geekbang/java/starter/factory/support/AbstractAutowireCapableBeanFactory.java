package org.geekbang.java.starter.factory.support;


import org.geekbang.java.starter.ioc.BeanDefinition;
import org.geekbang.java.starter.ioc.PropertyValue;
import org.geekbang.java.starter.ioc.RuntimeBeanReference;
import org.geekbang.java.starter.ioc.TypedStringValue;
import org.geekbang.java.starter.resolver.BeanDefinitionValueResolver;
import org.geekbang.java.starter.utils.ReflectUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.List;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/10/13
 * @Modify
 * @since
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    /**
     * 真正实现 Bean 创建的类
     * @param bd
     * @return
     */
    @Override
    protected Object createBean(BeanDefinition bd) {
        // 5、创建 Bean

        //  5.1、Bean的实例化 （new）
        Object bean = null;
        try {
            bean = createBeanInstance(bd);

            //  5.2、Bean的属性填充（依赖注入）
            populateBean(bean, bd);

            //  5.3、Bean的初始化（调用初始化，完成初始化操作）
            initializeBean(bean, bd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    private void initializeBean(Object bean, BeanDefinition bd) throws Exception {

        // TODO 处理 Aware 接口

        // TODO 处理 initializingBean接口的初始化操作

        // 处理 init-method 标签属性对应的初始化方法
        invokeInitMethod(bean, bd);
    }

    private void invokeInitMethod(Object bean, BeanDefinition bd) throws Exception {
        String initMethod = bd.getInitMethod();
        if (initMethod == null) {
            return;
        }
        ReflectUtils.invokeMethod(bean, initMethod);
    }

    private void populateBean(Object bean, BeanDefinition bd) throws Exception {
        List<PropertyValue> propertyValues = bd.getPropertyValues();
        for (PropertyValue propertyValue : propertyValues) {
            String name = propertyValue.getName();
            Object value = propertyValue.getValue();
            BeanDefinitionValueResolver valueResolver = new BeanDefinitionValueResolver(this);
            Object valueToUse = valueResolver.resolveValue(value);
            ReflectUtils.setProperty(bean, name, valueToUse);
        }
    }

    private void setProperty(Object bean, String name, Object valueToUse, BeanDefinition bd) throws Exception {
        Class<?> clazzType = bd.getClazzType();
        Field field = clazzType.getDeclaredField(name);
        field.setAccessible(true);
        field.set(bean, valueToUse);
    }


    private Object resolveValue(Object value) throws Exception {
        Object valueToUse = null;
        if (value instanceof TypedStringValue) {
            TypedStringValue typedStringValue = (TypedStringValue) value;
            String stringValue = typedStringValue.getValue();
            Class<?> targetType = typedStringValue.getTargetType();
            valueToUse = handleType(stringValue, targetType);
        } else if (value instanceof RuntimeBeanReference){
            RuntimeBeanReference runtimeBeanReference = (RuntimeBeanReference) value;
            String ref = runtimeBeanReference.getRef();
            // 此处有可能发生循环依赖
            valueToUse = getBean(ref);
        }
        return valueToUse;
    }

    private Object handleType(String stringValue, Class<?> targetType) {
        if (targetType == Integer.class) {
            return Integer.parseInt(stringValue);
        } else if (targetType == String.class) {
            return stringValue;
        }
        return null;
    }

    private Object createBeanInstance(BeanDefinition bd) throws Exception {

        // TODO 1、通过静态工厂方法去创建 Bean 的实例

        // TODO 2、通过对象工厂去创建 Bean 实例

        // 3、通过构造方法去创建 Bean 的实例

        Class<?> clazzType = bd.getClazzType();
        // 获取默认无参构造
        Constructor<?> constructor = clazzType.getDeclaredConstructor();
        Object bean = constructor.newInstance();
        return bean;
    }
}
