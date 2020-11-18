package org.geekbang.java.starter.ioc;

/**
 * @Description: 封装<bean>标签中子标签<property>的ref属性值
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/10/9
 * @Modify
 * @since
 */
public class RuntimeBeanReference {

    // ref的属性值
    private String ref;

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public RuntimeBeanReference(String ref) {
        super();
        this.ref = ref;
    }

}
