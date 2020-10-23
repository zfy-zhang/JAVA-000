package org.geekbang.java;

import java.util.*;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/10/23
 * @Modify
 * @since
 */
public class ArithmeticTest {

    public static void main(String[] args) {

        int a = 1;
        int b = 7;

        int c = b - a;
        int d = a + b;
        int e = a * b;
        int f = b / a;

        Map<Integer, String> map = new HashMap<>();
        map.put(c , "我是减法运算.......");
        map.put(d , "我是加法运算.......");
        map.put(e , "我是乘法运算.......");
        map.put(f , "我是除法运算.......");

        List<Integer> list = Arrays.asList(c, d, e, f);

        for (Integer integer : list) {
            if (integer == ((integer / 2)%1)) {
                System.out.println(map.get(integer));
            }
        }

    }
}
