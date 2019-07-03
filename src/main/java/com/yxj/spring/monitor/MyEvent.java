package com.yxj.spring.monitor;

import org.springframework.context.ApplicationEvent;

/**
 * @ProjectName: springBootDemo
 * @Package: com.yxj.spring.monitor
 * @Description: 定义事件
 * @Author: 阿杰
 * @CreateDate: 2019/1/23 22:16
 * @UpdateUser: 暂无
 * @UpdateDate: 2019/1/23 22:16
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class MyEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public MyEvent(String source) {
        super(source);
    }
}
