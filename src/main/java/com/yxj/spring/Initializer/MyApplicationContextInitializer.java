package com.yxj.spring.Initializer;

import com.yxj.spring.SpringBootTestRun;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @ProjectName: springBootDemo
 * @Package: com.yxj.spring.Initializer
 * @Description:
 * @Author: 阿杰
 * @CreateDate: 2019/1/25 22:39
 * @UpdateUser: 暂无
 * @UpdateDate: 2019/1/25 22:39
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class MyApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    /**
     * 1.springBoot执行ApplicationContextInitializer refresh方法之前会先执行
     * 2.在方法中设置活动配置文件为dev(该结果可以从其他途径去获取，这里给定默认值dev)
     * 3.在启动类最后获取name，查看最终结果
     * @param applicationContext
     */
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        applicationContext.getEnvironment().setActiveProfiles("dev");
        System.out.println("-------初始化---------");
    }
}
