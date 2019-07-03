package com.yxj.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Copyright(c): 2015-2019
 * @FileName: ParentTest.java
 * @Description:
 * @History:
 * @name 版本号       作者         日期                  简要介绍     相关操作
 * @value v1.0       杨小杰       2019/5/22 13:20
 */
public class ParentTest {
    public static void main(String[] args) {
        //String str1 = "12.mp4";
        String str1 = "c5612_20190503121212.mp4";
        String pattern1 = "^[\\w]*_[\\d]{14}\\.mp4$";

        Pattern r = Pattern.compile(pattern1);
        Matcher m = r.matcher(str1);
        System.out.println(m.matches());
    }
}
