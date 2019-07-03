package com.yxj.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @ProjectName: springBootDemo
 * @Package: com.yxj.spring.aspect
 * @Description:
 * @Author: 阿杰
 * @CreateDate: 2019/2/6 22:35
 * @UpdateUser: 暂无
 * @UpdateDate: 2019/2/6 22:35
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
@Aspect
@Component
public class LogAspect {

    @Pointcut("execution(* com.yxj.spring.mapper..*.*(..))")
    public void logAspect(){}
    /**
     * yxj.spring.mapper包下的所有class的所有方法
     */
    @Before("logAspect()")
    public void logBefore(){
        System.out.println("execution before log");
    }

    @After("logAspect()")
    public void logAfter(JoinPoint joinPoint){
        String targetMethodName = joinPoint.getSignature().getName();
        Class<?> targetClass = joinPoint.getTarget().getClass();
        Object[] args = joinPoint.getArgs();
        System.out.println("target method name : "+targetMethodName);
        System.out.println("target class : "+targetClass);
        System.out.println("target method args : "+Arrays.asList(args));
    }
}
