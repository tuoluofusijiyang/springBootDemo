package com.yxj.spring.mapper;

import org.springframework.stereotype.Repository;

/**
 * @ProjectName: springBootDemo
 * @Package: com.yxj.spring.mapper
 * @Description:
 * @Author: 阿杰
 * @CreateDate: 2019/2/6 22:33
 * @UpdateUser: 暂无
 * @UpdateDate: 2019/2/6 22:33
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class AopMapper {

    public void add(String userName,String passWord){
        System.out.println("userName: " +userName + "passWord: "+passWord);
    }
    public void delete(String userName){
        System.out.println("userName: " +userName);
    }
}
