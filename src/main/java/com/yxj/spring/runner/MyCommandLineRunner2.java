package com.yxj.spring.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @ProjectName: springBootDemo
 * @Package: com.yxj.spring.runner
 * @Description:
 * @Author: 阿杰
 * @CreateDate: 2019/1/25 23:10
 * @UpdateUser: 暂无
 * @UpdateDate: 2019/1/25 23:10
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
@Component
@Order(value = 1)
public class MyCommandLineRunner2 implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("order value is 1   。MyCommandLineRunner2 run.  get args : "+Arrays.asList(args));
    }
}
