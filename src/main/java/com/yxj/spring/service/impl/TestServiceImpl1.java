package com.yxj.spring.service.impl;

import com.yxj.spring.config.CallBackFactory;
import com.yxj.spring.service.TestService1;
import com.yxj.spring.service.TestService2;
import com.yxj.spring.service.TestService3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl1 implements TestService1 {

    @Autowired
    private TestService2 testService2;
    @Autowired
    private TestService3 testService3;

    public void add(){
        System.out.println(1);
        testService2.add(new CallBackFactory() {
            @Override
            public void init() {
                testService3.add();
            }
        });
    }
}
