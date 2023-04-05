package com.frank.nowcoder;


import java.util.Scanner;

/**
 * 某商店规定：三个空汽水瓶可以换一瓶汽水，允许向老板借空汽水瓶（但是必须要归还）。
 * 小张手上有n个空汽水瓶，她想知道自己最多可以喝到多少瓶汽水。
 * 数据范围：输入的正整数满足
 *
 * 注意：本题存在多组输入。输入的 0 表示输入结束，并不用输出结果。
 */
public class Nc_huawei_01 {


    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        
        while (sc.hasNext()){

//            Integer n = Integer.valueOf(sc.nextLine());

            int n = sc.nextInt();

            if(n == 0){
                break;
            }

            System.out.println(n/2);

        }

    }


}
