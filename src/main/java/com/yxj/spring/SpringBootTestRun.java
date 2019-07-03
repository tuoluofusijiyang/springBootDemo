package com.yxj.spring;

import com.yxj.spring.mapper.AopMapper;
import com.yxj.spring.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: springBootDemo
 * @Package: com.yxj.spring
 * @Description:
 * @Author: 阿杰
 * @CreateDate: 2019/1/18 20:18
 * @UpdateUser: 暂无
 * @UpdateDate: 2019/1/18 20:18
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */

/**
 * 排除springBoot对异常的默认处理（@SpringBootApplication(exclude = ErrorMvcAutoConfiguration.class)）
 * 开启事物（@EnableTransactionManagement）
 */
@SpringBootApplication
//@Import(AopMapper.class)
public class SpringBootTestRun {

    public static void main(String[] args){
        //SpringApplication.run(SpringBootTestRun.class, args);
        /*SpringApplication springBootTestRun = new SpringApplication(SpringBootTestRun.class);
        ConfigurableApplicationContext run = springBootTestRun.run(args);
        run.start();*/
        System.out.println("--------分割线--------");
        ArrayList<Map> maps = new ArrayList<>();
        HashMap<String, Object> map = new HashMap<>();
        maps.add(map);
        System.out.println("1111");
    }
}
