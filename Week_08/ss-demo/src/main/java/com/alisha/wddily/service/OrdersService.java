package com.alisha.wddily.service;

import com.alisha.wddily.entiry.Orders;
import org.springframework.core.annotation.Order;

import java.math.BigInteger;
import java.util.List;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
public interface OrdersService {
    /**
     * 生成订单
     *
     * @param order 订单
     */
    void addOrder(final Orders order);

    /**
     * 删除订单
     *
     * @param id 订单id
     * @param userId 买家id
     */
    void deleteOrder(final String id, final String userId);

    /**
     * 更新订单
     *
     * @param order 订单
     */
    void updateOrder(final Orders order);

    /**
     * 查询订单
     *
     * @return
     */
    Orders getOrder(final String id, final String userId);

    /**
     * 查询订单
     *
     * @return
     */
    List<Orders> getOrderList();

    /**
     *
     * @return
     */
    long getCount();
}
