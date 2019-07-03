package com.yxj.spring.myException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ProjectName: springBootDemo
 * @Package: com.yxj.spring.myException
 * @Description:
 * @Author: 阿杰
 * @CreateDate: 2019/1/29 15:18
 * @UpdateUser: 暂无
 * @UpdateDate: 2019/1/29 15:18
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler({Exception.class})
    @ResponseBody
    public String handleException(Exception e){
        return "检测到异常："+e.getMessage();
    }
}
