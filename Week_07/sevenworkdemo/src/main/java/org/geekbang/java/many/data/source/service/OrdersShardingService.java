package org.geekbang.java.many.data.source.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
@Service
public class OrdersShardingService {

    private final DataSource dataSource;

    @Autowired
    public OrdersShardingService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Map<String, Object>> getOrders() throws SQLException {

        String sql = "SELECT  *  FROM  inserttest.orders where 1=1";
        final Connection connection = dataSource.getConnection();
        final PreparedStatement ps = connection.prepareStatement(sql);
        final ResultSet resultSet = ps.executeQuery();
        List<Map<String, Object>> result = new ArrayList<>();
        while (resultSet.next()){
            Map<String, Object> map = new HashMap<>();
            final String id = resultSet.getString("id");
            final String user_id = resultSet.getString("user_id");
            final String receiver_name = resultSet.getString("receiver_name");
            final String receiver_mobile = resultSet.getString("receiver_mobile");
            final String receiver_address = resultSet.getString("receiver_address");
            final int total_amount = resultSet.getInt("total_amount");
            final int real_pay_amount = resultSet.getInt("real_pay_amount");
            final int post_amount = resultSet.getInt("post_amount");
            final int pay_method = resultSet.getInt("pay_method");
            final int is_comment = resultSet.getInt("is_comment");
            final int is_delete = resultSet.getInt("is_delete");
            final Date created_time = resultSet.getDate("created_time");
            final Date updated_time = resultSet.getDate("updated_time");

            map.put("id", id);
            map.put("user_id", user_id);
            map.put("receiver_name", receiver_name);
            map.put("receiver_mobile", receiver_mobile);
            map.put("receiver_address", receiver_address);
            map.put("total_amount", total_amount);
            map.put("real_pay_amount", real_pay_amount);
            map.put("post_amount", post_amount);
            map.put("pay_method", pay_method);
            map.put("is_comment", is_comment);
            map.put("is_delete", is_delete);
            map.put("created_time", created_time);
            map.put("updated_time", updated_time);

            result.add(map);
        }
        return result;
    }
    public int saveOrder() throws SQLException {
        String sql = "INSERT INTO inserttest.orders" +
                "(id, user_id, receiver_name, receiver_mobile, receiver_address, total_amount, " +
                "real_pay_amount, post_amount, pay_method, is_comment, is_delete, created_time, updated_time) " +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?,sysdate(),sysdate())";
        final Connection connection = dataSource.getConnection();
        final PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, UUID.randomUUID().toString());
        preparedStatement.setString(2, "200509GYMFN89028");
        preparedStatement.setString(3, "不才人");
        preparedStatement.setString(4, "13298933324");
        preparedStatement.setString(5, "上海 上海 浦东新区 唐镇");
        preparedStatement.setInt(6, 2000);
        preparedStatement.setInt(7, 1700);
        preparedStatement.setInt(8, 0);
        preparedStatement.setInt(9, 1);
        preparedStatement.setInt(10, 1);
        preparedStatement.setInt(11, 0);
        preparedStatement.addBatch();
        final int[] results = preparedStatement.executeBatch();
        return results.length;
    }
}

