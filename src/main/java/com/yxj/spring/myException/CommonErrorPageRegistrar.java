package com.yxj.spring.myException;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: springBootDemo
 * @Package: com.yxj.spring.myException
 * @Description:
 * @Author: 阿杰
 * @CreateDate: 2019/1/29 14:51
 * @UpdateUser: 暂无
 * @UpdateDate: 2019/1/29 14:51
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
//@Component
public class CommonErrorPageRegistrar implements ErrorPageRegistrar {

    /**
     * 如果相对某个异常做单独页面的跳转处理
     * ErrorPage(Class<? extends Throwable> exception, String path)
     * 可以添加一个Class对象，和跳转路径。
     * @param registry
     */
    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        ErrorPage ep404 = new ErrorPage(HttpStatus.NOT_FOUND,"/html/404.html");
        ErrorPage ep500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/html/500.html");
        registry.addErrorPages(ep404,ep500);
    }
}
