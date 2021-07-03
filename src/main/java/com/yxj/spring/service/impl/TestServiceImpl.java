package com.yxj.spring.service.impl;

import com.yxj.spring.service.TestService;
import com.yxj.spring.service.TestService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestService1 testService1;

    public void test(){
        testService1.add();
    }
}
