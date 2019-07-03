    package com.yxj.spring.controller;

    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.servlet.ModelAndView;

    /**
     * @ProjectName: springBootDemo
     * @Package: com.yxj.spring.controller
     * @Description:
     * @Author: 阿杰
     * @CreateDate: 2019/1/28 0:00
     * @UpdateUser: 暂无
     * @UpdateDate: 2019/1/28 0:00
     * @UpdateRemark: The modified content
     * @Version: 1.0
     */
    @Controller
    public class JspController {

        @GetMapping(value = "/toTsetJsp/{id}")
        public ModelAndView toTsetJsp(@PathVariable String id){
            ModelAndView modelAndView = new ModelAndView("/test");
            modelAndView.addObject("testParam",id);
            return modelAndView;
        }
    }
