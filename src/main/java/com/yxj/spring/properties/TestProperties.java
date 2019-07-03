package com.yxj.spring.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @ProjectName: springBootDemo
 * @Package: com.yxj.spring.properties
 * @Description: @ConfigurationProperties(prefix="test")，该注解会自动，将配置文件前缀是test的各项，加载至该bean中
 * @Author: 阿杰
 * @CreateDate: 2019/1/23 20:00
 * @UpdateUser: 暂无
 * @UpdateDate: 2019/1/23 20:00
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
@ConfigurationProperties(prefix="test")
public class TestProperties {
    private String age;

    private String name;

    private String[] friends;

    private List<String> utils;

    public String[] getFriends() {
        return friends;
    }

    public TestProperties setFriends(String[] friends) {
        this.friends = friends;
        return this;
    }

    public String getAge() {
        return age;
    }

    public TestProperties setAge(String age) {
        this.age = age;
        return this;
    }

    public String getName() {
        return name;
    }

    public TestProperties setName(String name) {
        this.name = name;
        return this;
    }

    public List<String> getUtils() {
        return utils;
    }

    public TestProperties setUtils(List<String> utils) {
        this.utils = utils;
        return this;
    }

    @Override
    public String toString() {
        return "TestProperties{" +
                "age='" + age + '\'' +
                ", name='" + name + '\'' +
                ", friends=" + Arrays.toString(friends) +
                ", utils=" + utils +
                '}';
    }
}
