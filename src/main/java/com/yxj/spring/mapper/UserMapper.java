/*
package com.yxj.spring.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;

*/
/**
 * @ProjectName: springBootDemo
 * @Package: com.yxj.spring.mapper
 * @Description:
 * @Author: 阿杰
 * @CreateDate: 2019/1/31 20:49
 * @UpdateUser: 暂无
 * @UpdateDate: 2019/1/31 20:49
 * @UpdateRemark: The modified content
 * @Version: 1.0
 *//*

@Repository
public class UserMapper {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    */
/**
     * 添加用户
     * @param userName 用户名
     * @param passWord 密码
     * @param exceptionClass
     * @methodResult
     * 1.单独的一个@Transactional注解，如果抛出的异常继承与运行时异常，事物生效，非运行时异常，事物失效
     * 2.rollbackFor和noRollbackFor分别指定可以回滚的异常，和不可以回滚的异常
     *//*

    //@Transactional(rollbackFor = FileNotFoundException.class,noRollbackFor = NullPointerException.class)
    @Transactional
    public void addUser(String userName, String passWord, String isCallBack,Throwable exceptionClass) throws Throwable {
        String sql="insert into user(name,password) values('"+userName+"','"+passWord+"')";
        jdbcTemplate.execute(sql);
        if(!"N".equalsIgnoreCase(isCallBack)){
            throw exceptionClass;
        }else{
            System.out.println("无异常");
        }
    }
}
*/
