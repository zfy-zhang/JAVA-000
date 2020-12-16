package com.alisha.rpcfx.pr.service;

import com.alisha.rpcfx.api.Order;
import com.alisha.rpcfx.api.OrderService;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
@Service("OrderService")
public class OrderServiceImpl implements OrderService {

    @Override
    public Order findOrderById(int id) {
        return new Order(id, "order" + System.currentTimeMillis(), 9.9f);
    }
}
