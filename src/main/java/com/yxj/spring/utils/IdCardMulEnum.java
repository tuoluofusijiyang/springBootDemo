package com.yxj.spring.utils;

public enum  IdCardMulEnum {
    BIT_0(0,7,"身份证第1位乘以7"),
    BIT_1(1,9,"身份证第2位乘以9"),
    BIT_2(2,10,"身份证第3位乘以10"),
    BIT_3(3,5,"身份证第4位乘以5"),
    BIT_4(4,8,"身份证第5位乘以8"),
    BIT_5(5,4,"身份证第6位乘以4"),
    BIT_6(6,2,"身份证第7位乘以2"),
    BIT_7(7,1,"身份证第8位乘以1"),
    BIT_8(8,6,"身份证第9位乘以6"),
    BIT_9(9,3,"身份证第10位乘以3"),
    BIT_10(10,7,"身份证第11位乘以7"),
    BIT_11(11,9,"身份证第12位乘以9"),
    BIT_12(12,10,"身份证第13位乘以10"),
    BIT_13(13,5,"身份证第14位乘以5"),
    BIT_14(14,8,"身份证第15位乘以8"),
    BIT_15(15,4,"身份证第16位乘以4"),
    BIT_16(16,2,"身份证第18位乘以2");

    private Integer bitNum; //位数
    private Integer mulNum; //乘数
    private String explain; //阐述

    public static IdCardMulEnum getByBitNum(Integer bitNum){
        if (bitNum == null) {
            return null;
        }
        IdCardMulEnum[] values = IdCardMulEnum.values();
        for(IdCardMulEnum enum1 : values){
            if (bitNum.equals(enum1.getBitNum())) {
                return enum1;
            }
        }
        return null;
    }

    IdCardMulEnum(Integer bitNum, Integer mulNum, String explain){
        this.bitNum = bitNum;
        this.mulNum = mulNum;
        this.explain = explain;
    }

    public Integer getBitNum() {
        return bitNum;
    }

    public void setBitNum(Integer bitNum) {
        this.bitNum = bitNum;
    }

    public Integer getMulNum() {
        return mulNum;
    }

    public void setMulNum(Integer mulNum) {
        this.mulNum = mulNum;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }
}
