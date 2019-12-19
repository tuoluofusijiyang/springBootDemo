package com.yxj.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("testWeb")
    public String testWeb(HttpServletRequest request) {
        System.out.println("测试");
        return "测试";
    }

    @GetMapping(value = "/pathParam/{id}")
    public String pathParam(@PathVariable(value = "id") String id) {
        return "测试, id = " + id;
    }

    @GetMapping(value = "/testException")
    public String testException() {
        throw new IllegalArgumentException("请求参数异常");
    }

    @GetMapping("/download/**")
    public String download(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println(request.getQueryString());
        String a = "1";
        return null;
    }

    @GetMapping("/baidu")
    public void baidu(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String api_url = "http://data.zz.baidu.com/urls?site=www.yangxj.top&token=iNwm3wbpwdfOVEfF";
        List<String> urlList = new ArrayList<>();
        urlList.add("http://www.yangxj.top/2019/springboot001/");
        urlList.add("http://www.yangxj.top/2019/springboot002/");
        urlList.add("http://www.yangxj.top/2019/springboot003/");
        urlList.add("http://www.yangxj.top/2019/springboot004/");
        urlList.add("http://www.yangxj.top/2019/springboot005/");
        urlList.add("http://www.yangxj.top/2019/leetcode001/");
        urlList.add("http://www.yangxj.top/2019/dataStructure001/");
        urlList.add("http://www.yangxj.top/2019/dataStructure002/");
        urlList.add("http://www.yangxj.top/2019/dataStructure003/");
        urlList.add("http://www.yangxj.top/2019/design001/");
        urlList.add("http://www.yangxj.top/2019/design002/");
        urlList.add("http://www.yangxj.top/2019/design003/");
        urlList.add("http://www.yangxj.top/2019/design004/");
        urlList.add("http://www.yangxj.top/2019/design005/");
        urlList.add("http://www.yangxj.top/2019/design006/");
        urlList.add("http://www.yangxj.top/2019/design007/");
        StringBuffer urlBuffer = new StringBuffer();
        for (String url : urlList) {
            urlBuffer.append(url + "\n");
        }
        System.out.println(urlBuffer.toString());
        HttpHeaders headers = new HttpHeaders();
        headers.add("Host", "data.zz.baidu.com");
        headers.add("User-Agent", "curl/7.12.1");
        headers.add("Content-Length", "83");
        headers.add("Content-Type", "text/plain");
        HttpEntity<String> entity = new HttpEntity<String>(urlBuffer.toString(), headers);
        String result = restTemplate.postForObject(api_url, entity, String.class);
        System.out.println(result);
    }
}
