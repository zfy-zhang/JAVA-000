package org.geekbang.java.starter;

import java.util.List;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/11/17
 * @Modify
 * @since
 */
public class School {

    private List<Klass> myClasses;

    public School(List<Klass> myClasses) {
        this.myClasses = myClasses;
    }

    @Override
    public String toString() {
        return "School{" +
                "myClasses=" + myClasses +
                '}';
    }
}
