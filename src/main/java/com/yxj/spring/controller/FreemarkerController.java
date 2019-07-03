package com.yxj.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ProjectName: springBootDemo
 * @Package: com.yxj.spring.controller
 * @Description:
 * @Author: 阿杰
 * @CreateDate: 2019/1/28 20:47
 * @UpdateUser: 暂无
 * @UpdateDate: 2019/1/28 20:47
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
@Controller
public class FreemarkerController {

    @GetMapping(value = "/testFreeMarker/{id}")
    public ModelAndView testFreeMarker(@PathVariable(value = "id") String id){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("a");
        mv.addObject("userName",id);
        return mv;
    }
}
