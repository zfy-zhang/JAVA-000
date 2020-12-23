package com.alisha.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
@Data
public class Account implements Serializable {

    private Long id;

    private String name;

    private Long cny_wallet;

    private Long us_wallet;
}