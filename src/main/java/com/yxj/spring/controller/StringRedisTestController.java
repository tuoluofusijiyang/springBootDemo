package com.yxj.spring.controller;

import com.yxj.spring.utils.RedisUtils;
import com.yxj.spring.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    @PostMapping("/redis")
    public String updateRedis(User user){
        redisUtils.set(user.getId(),user.getUserName());
        return "success";
    }

    @GetMapping("/redis/{key}")
    public String insertRedisTest(@PathVariable String key){
        return redisUtils.get(key);
    }
}
