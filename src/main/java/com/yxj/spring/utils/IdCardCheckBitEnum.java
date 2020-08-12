package com.yxj.spring.utils;

public enum  IdCardCheckBitEnum {
    REMAINDER_0(0,'1',"余数为0，校验位为1"),
    REMAINDER_1(1,'0',"余数为1，校验位为0"),
    REMAINDER_2(2,'X',"余数为2，校验位为X"),
    REMAINDER_3(3,'9',"余数为3，校验位为9"),
    REMAINDER_4(4,'8',"余数为4，校验位为8"),
    REMAINDER_5(5,'7',"余数为5，校验位为7"),
    REMAINDER_6(6,'6',"余数为6，校验位为6"),
    REMAINDER_7(7,'5',"余数为7，校验位为5"),
    REMAINDER_8(8,'4',"余数为8，校验位为4"),
    REMAINDER_9(9,'3',"余数为9，校验位为3"),
    REMAINDER_10(10,'2',"余数为10，校验位为2");

    private Integer remainder; //余数
    private char checkBit; //校验位数字
    private String explain; //阐述

    public static IdCardCheckBitEnum getByRemainder(Integer remainder){
        if (remainder == null) {
            return null;
        }
        IdCardCheckBitEnum[] values = IdCardCheckBitEnum.values();
        for(IdCardCheckBitEnum enum1 : values){
            if (remainder.equals(enum1.getRemainder())) {
                return enum1;
            }
        }
        return null;
    }

    IdCardCheckBitEnum(Integer remainder, char checkBit, String explain){
        this.remainder = remainder;
        this.checkBit = checkBit;
        this.explain = explain;
    }

    public Integer getRemainder() {
        return remainder;
    }

    public void setRemainder(Integer remainder) {
        this.remainder = remainder;
    }

    public char getCheckBit() {
        return checkBit;
    }

    public void setCheckBit(char checkBit) {
        this.checkBit = checkBit;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }
}
