package com.yxj.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ProjectName: springBootDemo
 * @Package: com.yxj.spring.controller
 * @Description: @RestController表示当前controller方法的返回值可以直接用于返回值输出==@ResponseBody
 * @Author: 阿杰
 * @CreateDate: 2019/1/27 23:21
 * @UpdateUser: 暂无
 * @UpdateDate: 2019/1/27 23:21
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
@RestController
@RequestMapping("my")
public class MyController {

    @GetMapping("testWeb")
    public String testWeb(HttpServletRequest request){
        System.out.println("测试");
        return "测试";
    }

    @GetMapping(value = "/pathParam/{id}")
    public String pathParam(@PathVariable(value = "id") String id){
        return "测试, id = "+id;
    }

    @GetMapping(value = "/testException")
    public String testException(){
        throw new IllegalArgumentException("请求参数异常");
    }

    @GetMapping("/download/**")
    public String download(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println(request.getQueryString());
        String a="1";
        return null;
    }
}
