package com.yxj.spring.config;

import com.yxj.spring.mapper.AopMapper;
import org.springframework.context.annotation.Bean;

/**
 * @ProjectName: springBootDemo
 * @Package: com.yxj.spring.config
 * @Description:
 * @Author: 阿杰
 * @CreateDate: 2019/2/26 18:14
 * @UpdateUser: 暂无
 * @UpdateDate: 2019/2/26 18:14
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
//@org.springframework.boot.SpringBootConfiguration
public class SpringBootConfiguration {
    @Bean
    public AopMapper getAopMapper(){
        return new AopMapper();
    }
}
