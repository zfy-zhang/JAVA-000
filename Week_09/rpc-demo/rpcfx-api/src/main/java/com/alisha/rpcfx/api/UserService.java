package com.alisha.rpcfx.api;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
public interface UserService {

    /**
     * 通过用户Id查找用户
     *
     * @param id
     * @return
     */
    User findById(int id);

}
