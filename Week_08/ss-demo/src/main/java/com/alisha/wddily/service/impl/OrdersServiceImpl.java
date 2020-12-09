package com.alisha.wddily.service.impl;

import com.alisha.wddily.entiry.Orders;
import com.alisha.wddily.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
@Service
public class OrdersServiceImpl implements OrdersService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public OrdersServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addOrder(final Orders order) {
        jdbcTemplate.update("insert into `orders` (`user_id`, `is_delete`) values (?, ?)",
                order.getUserId(), 0);
    }

    @Override
    @Transactional
    public void deleteOrder(final String id, final String userId) {
        jdbcTemplate.update("delete from `orders` where id = ? and user_id = ?", id, userId);
    }

    @Override
    public void updateOrder(final Orders order) {
        jdbcTemplate.update("update `orders` set `is_delete` = ? where `id` = ? and `buyer_id` = ?",
                order.getIsDelete(), order.getId(), order.getUserId());
    }

    @Override
    public Orders getOrder(final String id, final String userId) {
        return jdbcTemplate.queryForObject("select * from `orders` where id = ? and user_is = ?",
                (rs, rowNum) -> new Orders()
                        .setId(rs.getString("id"))
                        .setUserId(rs.getString("user_id")),
                id, userId);
    }

    @Override
    public List<Orders> getOrderList() {
        return jdbcTemplate.query("select * from `orders`",
                (rs, rowNum) -> new Orders()
                        .setId((rs.getString("id")))
                        .setUserId(rs.getString("user_id")));
    }

    @Override
    public long getCount() {
        return jdbcTemplate.queryForObject("select count(1) from `orders`", Long.class);
    }
}

