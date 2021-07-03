package com.yxj.spring.service.impl;

import com.yxj.spring.config.CallBackFactory;
import com.yxj.spring.service.TestService2;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl2 implements TestService2 {

    public void add(CallBackFactory callBackFactory){
        System.out.println("testService1 add");
        callBackFactory.init();
    }
}
