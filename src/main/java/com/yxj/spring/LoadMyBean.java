package com.yxj.spring;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

/**
 * @ProjectName: springBootDemo
 * @Package: com.yxj.spring
 * @Description:  @SpringBootConfiguration继承自@Configuration，
 * 二者功能也一致，标注当前类是配置类，
 * 并会将当前类内声明的一个或多个以@Bean注解标记的方法的实例纳入到spring容器中，
 * 并且实例名就是方法名。
 * @Author: 阿杰
 * @CreateDate: 2019/1/22 22:14
 * @UpdateUser: 暂无
 * @UpdateDate: 2019/1/22 22:14
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class LoadMyBean {

    @Bean
    @Conditional(WechatCondition.class)
    public MakeApp createWechat(){
        return new Wechat();
    }


    @Bean
    @Conditional(PipiXiaCondition.class)
    public MakeApp createPipiXia(){
        return new PipiXia();
    }
}
