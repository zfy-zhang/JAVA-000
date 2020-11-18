package org.geekbang.java.starter.resolver;


import org.geekbang.java.starter.factory.BeanFactory;
import org.geekbang.java.starter.ioc.RuntimeBeanReference;
import org.geekbang.java.starter.ioc.TypedStringValue;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/10/14
 * @Modify
 * @since
 */
public class BeanDefinitionValueResolver {
    private BeanFactory beanFactory;

    public BeanDefinitionValueResolver(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public Object resolveValue(Object value) throws Exception{
        Object valueToUse = null;
        if (value instanceof TypedStringValue){
            TypedStringValue typedStringValue = (TypedStringValue) value;
            String stringValue = typedStringValue.getValue();
            Class<?> targetType = typedStringValue.getTargetType();

            valueToUse = handleType(stringValue,targetType);
        }else if(value instanceof RuntimeBeanReference){
            RuntimeBeanReference beanReference = (RuntimeBeanReference) value;
            String ref = beanReference.getRef();
            // 此处有可能会发生循环依赖问题
            valueToUse = beanFactory.getBean(ref);
        }
        return valueToUse;
    }

    private Object handleType(String stringValue, Class<?> targetType) {
        if (targetType == Integer.class){
            return Integer.parseInt(stringValue);
        }else if (targetType == String.class){
            return stringValue;
        }// ......
        return null;
    }
}
