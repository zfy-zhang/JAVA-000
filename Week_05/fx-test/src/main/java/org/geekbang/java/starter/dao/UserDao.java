package org.geekbang.java.starter.dao;


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
public interface UserDao {
    List<User> queryUserList(Map<String, Object> param);

    boolean insert(String table, String column, List<Object> values);
}
