package com.alisha.rpcfx.pr.service;

import com.alisha.rpcfx.api.User;
import com.alisha.rpcfx.api.UserService;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
@Service("UserService")
public class UserServiceImpl implements UserService {

    @Override
    public User findById(int id) {
        return new User(id, "user" + System.currentTimeMillis());
    }
}
