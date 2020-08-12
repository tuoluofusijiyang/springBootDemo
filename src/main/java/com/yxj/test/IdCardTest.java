package com.yxj.test;

import com.yxj.spring.config.bean.Result;
import com.yxj.spring.utils.ValidUtils;

import java.util.ArrayList;
import java.util.Arrays;

public class IdCardTest {

    public static void main(String[] args) {
        int count = 0;
        String prefix = "14272919980324";
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 1; k < 10; k+=2) {
                    for (int l = 0; l < 11; l++) {
                        count ++;
                        String yy = String.valueOf(l);
                        if(l==10){
                            yy="X";
                        }
                        Result result = ValidUtils.verifyCheckBit(prefix+i+j+k+yy);
                        if(result.getSuccess()){
                            strings.add(prefix+i+j+k+yy);
                        }
                    }
                }
            }
        }
        int x =0;
        System.out.println(count);
        System.out.println(strings.size());

        for (String string : strings) {
            System.out.println(string);
        }

    }
}
