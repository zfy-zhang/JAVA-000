package com.alisha.rpcfx.api;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
public interface OrderService {

    /**
     * 根据订单Id查找订单
     *
     * @param id
     * @return
     */
    Order findOrderById(int id);

}
