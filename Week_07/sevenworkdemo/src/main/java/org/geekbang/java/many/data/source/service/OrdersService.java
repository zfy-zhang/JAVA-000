package org.geekbang.java.many.data.source.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
@Service
public class OrdersService {

    private final JdbcTemplate masterJdbcTemplate;
    private final JdbcTemplate slaveOneJdbcTemplate;

    @Autowired
    public OrdersService(@Qualifier("masterJdbcTemplate") JdbcTemplate masterJdbcTemplate, @Qualifier("slaveOneJdbcTemplate") JdbcTemplate slaveOneJdbcTemplate) {
        this.masterJdbcTemplate = masterJdbcTemplate;
        this.slaveOneJdbcTemplate = slaveOneJdbcTemplate;
    }

    public List<Map<String, Object>> getOrders(){
        String sql = "SELECT * FROM inserttest.orders";
        return slaveOneJdbcTemplate.queryForList(sql);
    }

    public int saveOrder(){
        String sql = "INSERT INTO inserttest.orders" +
                "(id, user_id, receiver_name, receiver_mobile, receiver_address, total_amount, real_pay_amount, post_amount, pay_method, is_comment, is_delete, created_time, updated_time) " +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?,sysdate(),sysdate())";
        Object[] params = new Object[]{UUID.randomUUID().toString(),
                "200509GYMFN89028",
                "不才人",
                "13298933324",
                "上海 上海 浦东新区 唐镇",
                2000,
                1700,
                0,
                1,
                1,
                0};
        return masterJdbcTemplate.update(sql, params);
    }
}
