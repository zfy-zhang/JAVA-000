package com.alisha.service;

import com.alisha.lock.RedisLock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
@Service
@Slf4j
public class SchedulerService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Scheduled(cron = "0/5 * * * * ?")
    public void sendSms(){
        try(RedisLock redisLock = new RedisLock(redisTemplate,"autoSms",30)) {
            if (redisLock.getLock()){
                log.info("向138xxxxxxxx发送短信！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
