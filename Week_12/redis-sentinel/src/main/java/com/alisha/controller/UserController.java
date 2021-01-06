package com.alisha.controller;

import com.alisha.entity.User;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
@RestController
@EnableAutoConfiguration
public class UserController {


    @RequestMapping("/user/find")
    User find(Integer id) {
        return new User(1,"KK", 28);
    }

    @RequestMapping("/user/list")
    List<User> list() {
        return Arrays.asList(new User(1,"KK", 28),
                new User(2,"CC", 18));
    }
}
