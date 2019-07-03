package com.yxj.spring.monitor;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: springBootDemo
 * @Package: com.yxj.spring.monitor
 * @Description: 定义事件监听器
 * @Author: 阿杰
 * @CreateDate: 2019/1/23 22:18
 * @UpdateUser: 暂无
 * @UpdateDate: 2019/1/23 22:18
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class MyApplicationListener implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent event) {
        System.out.println("接收到事件:"+event.getClass());
    }
}
