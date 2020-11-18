package org.geekbang.java.starter.service;


import org.geekbang.java.starter.dao.UserDao;
import org.geekbang.java.starter.po.User;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/10/9
 * @Modify
 * @since
 */

public class UserServiceImpl implements UserService {

    // 依赖注入UserDao
    private UserDao userDao;

    // setter方法注入UserDao
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> queryUsers(Map<String, Object> param) {
        return userDao.queryUserList(param);
    }

    @Override
    public boolean insert(String table, String column, List<Object> values) {

        return userDao.insert(table, column, values);
    }

}
