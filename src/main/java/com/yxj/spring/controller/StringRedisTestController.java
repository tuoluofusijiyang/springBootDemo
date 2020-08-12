package com.yxj.spring.controller;

import com.yxj.spring.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @version v1.0
 * @Copyright(c): 2020-2020
 * @FileName: RedisTestController.java
 * @Description:
 * @autho Admin
 * @date 2020/1/17 13:55
 */
@RestController
@RequestMapping("/test")
public class StringRedisTestController {

    @Autowired
    private RedisUtils redisUtils;

    private static Integer nowCount = 10000;
    /**
     * 减少，库存等等
     * @return
     */
    @GetMapping("/redis/reduce")
    public String lockTest(){
        if(nowCount<=0){
            System.out.println("------库存不足------");
            return "------库存不足------";
        }
        if(redisUtils.setIfAbsent(String.valueOf(nowCount), "true")){
            redisUtils.expire(String.valueOf(nowCount),3000,TimeUnit.SECONDS);
            Integer count = nowCount;
            --nowCount;
            redisUtils.delete(String.valueOf(count));
            System.out.println("----库存剩余----"+nowCount);
            return String.valueOf(nowCount);
        }else{
            System.out.println("系统繁忙");
            return "系统繁忙";
        }
    }
}
