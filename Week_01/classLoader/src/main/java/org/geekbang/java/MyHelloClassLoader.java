package org.geekbang.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;

/**
 * @Description: 自定义一个ClassLoader类，使其加载 Hello.xlass 文件，
 *               然后执行 hello 方法，此文件内容是一个 Hello.class 文件所有字节（x=255-x）处理后的文件
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/10/19
 * @Modify
 * @since
 */
public class MyHelloClassLoader extends ClassLoader{

    public static void main(String[] args) {
        try {
            Class<?> aClass = new MyHelloClassLoader().findClass("Hello", "/Hello.xlass");
            Object obj = aClass.newInstance();
            Method method = aClass.getMethod("hello");
            method.invoke(obj);
//            System.out.println(method.invoke(obj));
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过文件名查找 Class
     * @param className
     * @param fileName
     * @return
     * @throws ClassNotFoundException
     */
    protected Class<?> findClass(String className, String fileName) throws ClassNotFoundException {
        File f = new File(getResource(fileName).getPath());
        int length = (int)f.length();
        byte[] bytes = new byte[length];
        try {
            new FileInputStream(f).read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
            return super.findClass(className);
        }
        for (int i = 0; i < bytes.length; ++i) {
            bytes[i] = (byte)(255 - bytes[i]);
        }
        return defineClass(className, bytes, 0, bytes.length);
    }

    /**
     * 通过 fileName 获取资源 URL
     * @param fileName
     * @return
     */
    public URL getResource(String fileName) {
        URL resource = this.getClass().getResource(fileName);
        return resource;
    }

}
