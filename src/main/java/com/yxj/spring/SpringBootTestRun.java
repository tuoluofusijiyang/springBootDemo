package com.yxj.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;

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
@Import(RestTemplate.class)
public class SpringBootTestRun {

    public static void main(String[] args){
       /* SpringApplication.run(SpringBootTestRun.class, args);*/
        ApplicationContext ctx = SpringApplication.run(SpringBootTestRun.class, args);
        String[] beanNames = ctx.getBeanDefinitionNames();
        //String[] beanNames = ctx.getBeanNamesForAnnotation(RestController.class);//所有添加该注解的bean
        int i = 0;
        for (String str : beanNames) {
            System.out.println(str);
        }

        /*SpringApplication springBootTestRun = new SpringApplication(SpringBootTestRun.class);
        ConfigurableApplicationContext run = springBootTestRun.run(args);
        run.start();*/
        /*System.out.println("--------分割线--------");
        ArrayList<Map> maps = new ArrayList<>();
        HashMap<String, Object> map = new HashMap<>();
        maps.add(map);
        System.out.println("1111");*/
    }
}
