package com.yxj.spring.vo;

/**
 * @Copyright(c): 2015-2020
 * @FileName: User.java
 * @Description:
 * @History:
 * @name 版本号       作者         日期                  简要介绍     相关操作
 * @value v1.0       杨小杰       2020/1/6 17:26
 */
public class User {
    private String userName;
    private String passWord;

    public String getUserName() {
        return userName;
    }

    public User setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassWord() {
        return passWord;
    }

    public User setPassWord(String passWord) {
        this.passWord = passWord;
        return this;
    }
}
