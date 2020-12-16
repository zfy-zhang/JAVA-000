package com.alisha.rpcfx.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private int id;

    private String name;

    private float amount;
}
