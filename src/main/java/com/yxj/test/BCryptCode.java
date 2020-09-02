package com.yxj.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptCode {
    public static void main(String[] args) {
        String pwd = new BCryptPasswordEncoder().encode("root");
        System.out.println(pwd);
    }
}
