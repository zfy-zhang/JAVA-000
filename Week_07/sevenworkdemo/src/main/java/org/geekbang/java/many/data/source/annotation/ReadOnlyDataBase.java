package org.geekbang.java.many.data.source.annotation;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
public @interface ReadOnlyDataBase {
    boolean readOnly() default true;
}
