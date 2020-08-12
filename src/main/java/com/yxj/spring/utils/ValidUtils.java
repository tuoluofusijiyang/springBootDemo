package com.yxj.spring.utils;

import com.yxj.spring.config.bean.Result;
import org.apache.commons.lang3.StringUtils;

public class ValidUtils {

    /**
     * 判断身份证校验位是否正确
     * @param idCardNo
     * @return
     * @auther ServerZhang
     * @date 2018年5月28日
     */
    public static Result verifyCheckBit(String idCardNo){
        if (StringUtils.isEmpty(idCardNo)) {
            return new Result(false, "身份证号为空");
        }

        char[] charArray = idCardNo.toCharArray();
        int length = charArray.length;
        if (length != 18) {
            return new Result(false, "身份证号长度不正确");
        }

        //1.前17位分别乘指定数字并求和
        Integer sum = 0;
        for(int i=0; i<length-1; i++){
            IdCardMulEnum mulEnum = IdCardMulEnum.getByBitNum(i);
            if (mulEnum == null) {
                return new Result(false, "系统参数配置有误 ，请联系管理员处理");
            }
            Integer mulNum = mulEnum.getMulNum();
            int number = charArray[i] - '0';
            sum += mulNum * number;
        }

        //2.将和值模11
        int remainder = sum % 11;

        IdCardCheckBitEnum checkBitEnum = IdCardCheckBitEnum.getByRemainder(remainder);
        if (checkBitEnum == null) {
            return new Result(false, "系统参数配置有误 ，请联系管理员处理");
        }

        int lastNum = (int)charArray[17];
        if (lastNum == checkBitEnum.getCheckBit()) {
            return new Result(true, "正确的身份证号");
        }
        return new Result(false, "该身份证号校验位不正确");
    }
}
