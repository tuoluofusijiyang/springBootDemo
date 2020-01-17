package com.yxj.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @version v1.0
 * @Copyright(c): 2020-2020
 * @FileName: PatternTest.java
 * @Description:
 * @autho Admin
 * @date 2020/1/16 14:28
 */
public class PatternTest {

    public static void main(String[] args) {

        Pattern p = Pattern.compile(
                "([-+]?)P(([-+]?[0-9]+)D)?(T(([-+]?[0-9]+)H)?(([-+]?[0-9]+)M)?(([-+]?[0-9]+)([.,]([0-9]{0,9}))?S)?)?"
                ,
                Pattern.CASE_INSENSITIVE);
        String content = "-1DPT-2H-03M-1.3s";
        Matcher matcher = p.matcher(content);
        if ("T".equals(matcher.group(3)) == false) {
            boolean negate = "-".equals(matcher.group(1));
            String dayMatch = matcher.group(2);
            String hourMatch = matcher.group(4);
            String minuteMatch = matcher.group(5);
            String secondMatch = matcher.group(6);
            String fractionMatch = matcher.group(7);
            System.out.println("1");
        }
    }
}
