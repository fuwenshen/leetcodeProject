package com.frank.nowcoder;

import java.util.Scanner;

/**
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
 *
 * 数据范围：保证结果在
 */
public class Nc_huawei_03 {


    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);


        String ox = sc.nextLine();


        String value = getTenValue(ox);

        System.out.println(value);

    }



    public static String getTenValue(String ox){


        if(ox ==null ){
            return null;
        }

        if(ox.startsWith("0x")){
            ox = ox.substring(2);
        }


        int n = ox.length();


        int res = 0;
        for (int i = 0; i < n; i++) {

            char ch = ox.charAt(n-1-i);
            int val = 0;
            if(ch >= 'A'){
                val = ch-'A'+10;
            }else {
                val = ch - '0';
            }

            res += val * Math.pow(16,i);
        }


        return String.valueOf(res);
    }
}
