package com.yxj.spring.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: springBootDemo
 * @Package: com.yxj.spring.runner
 * @Description:
 * @Author: 阿杰
 * @CreateDate: 2019/1/25 23:27
 * @UpdateUser: 暂无
 * @UpdateDate: 2019/1/25 23:27
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
@Component
@Order(value = 2)
public class MyApplicationRunner2 implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        for(String argsString :args.getOptionNames()){
            System.out.println("order value is 2   。MyApplicationRunner2 is ApplicationArguments key : ("+argsString + ")   ApplicationArguments value : ("+args.getOptionValues(argsString)+")");
        }
    }
}
