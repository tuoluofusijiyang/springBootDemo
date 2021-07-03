package com.yxj.spring.service.impl;

import com.yxj.spring.config.CallBackFactory;
import com.yxj.spring.service.TestService2;
import com.yxj.spring.service.TestService3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl3 implements TestService3 {

    @Autowired
    private TestService2 testService2;
    @Autowired
    private TestService3 testService3;


    public void add(){
        System.out.println("add");
    }

    public void del(){
        System.out.println(3);
        testService2.add(new CallBackFactory() {
            @Override
            public void init() {
                testService3.add();
            }
        });
    }
}
