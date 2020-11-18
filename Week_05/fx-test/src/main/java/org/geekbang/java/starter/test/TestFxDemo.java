package org.geekbang.java.starter.test;


import org.geekbang.java.starter.factory.support.DefaultListableBeanFactory;
import org.geekbang.java.starter.po.User;
import org.geekbang.java.starter.reader.XmlBeanDefinitionReader;
import org.geekbang.java.starter.resource.ClasspathResource;
import org.geekbang.java.starter.resource.Resource;
import org.geekbang.java.starter.service.UserService;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.*;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/10/9
 * @Modify
 * @since
 */
public class TestFxDemo{

    private DefaultListableBeanFactory beanFactory;

    @Before
    public void before(){

        String location = "beans.xml";
        // 获取流对象
        // 策略模式
        Resource resource = new ClasspathResource(location);
        InputStream inputStream = resource.getResource();

        // 按照spring定义的标签语义去解析Document文档
        beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);

        beanDefinitionReader.loadBeanDefinitions(inputStream);
    }

    @Test
    public void testQuery() throws Exception{
        UserService userService = (UserService) beanFactory.getBean("userService");

        Map<String,Object> map = new HashMap<>();
        map.put("username","千年老亚瑟");
        List<User> users = userService.queryUsers(map);
        System.out.println(users);
    }

    @Test
    public void testAdd() throws Exception{
        UserService userService = (UserService) beanFactory.getBean("userService");
//        Map<String,Object> map = new HashMap<>();
//        map.put("id","6");
//        map.put("username","干不倒的程咬金");
//        map.put("birthday",new Date());
//        map.put("sex","男");
//        map.put("address","瓦岗寨");

        String table = "user";
        String columns = "(username, sex, address)";
        User user = createUser();
        List<Object> values = Arrays.asList(0, "干不倒的程咬金", "男", "瓦岗寨");
        boolean res = userService.insert(table, columns, values);
        System.out.println(res);
    }

    private User createUser() {
        User user = new User();
//        user.setId(6);
        user.setUsername("干不倒的程咬金");
        user.setSex("男");
        user.setAddress("瓦岗寨");

        return user;
    }


}
