package com.yxj.test;

import java.util.Scanner;

public class App2_13 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int i, j, max, min, k, l;  //k,l分别表示数组的行数和列数
        int minrow = 0, maxrow = 0, mincolumn = 0, maxcolumn = 0;

        int m = 0;
        int[][] a = new int[4][5];
        System.out.println("请输入整数：");
        for (i = 0; i < a.length; i++) {
            for (j = 0; j < a[i].length; j++) {
                a[i][j] = reader.nextInt();
            }
        }
        for (int[] hang : a) {
            for (int lie : hang) {
                System.out.print(lie + "    ");
                m++;
                if (m % 5 == 0)
                    System.out.println();
            }
        }
        max = a[0][0];
        min = a[0][0];
        for (i = 0; i < a.length; i++) {
            for (j = 0; j < a[i].length; j++) {
                if (max < a[i][j]) {
                    max = a[i][j];
                    maxrow = i + 1;
                    maxcolumn = j + 1;
                }
                if (min > a[i][j]) {
                    min = a[i][j];
                    minrow = i + 1;
                    mincolumn = j + 1;
                }
            }
        }
        System.out.println("最大值：" + max);
        System.out.println("最大值的行数和列数分别为:" + maxrow + "  " + maxcolumn);
        System.out.println("最小值:" + min);
        System.out.println("最小值的行数和列数分别为:" + minrow + "   " + mincolumn);
    }
}
