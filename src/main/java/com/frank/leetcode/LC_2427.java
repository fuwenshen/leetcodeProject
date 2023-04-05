package com.frank.leetcode;


/**
 * 给你两个正整数 a 和 b ，返回 a 和 b 的 公 因子的数目。
 *
 * 如果 x 可以同时整除 a 和 b ，则认为 x 是 a 和 b 的一个 公因子 。
 */
public class LC_2427 {


    public static void main(String[] args) {
        LC_2427 lc_2427 = new LC_2427();


        int result = lc_2427.commonFactors(25, 30);
        System.out.println(result);


    }

    public int commonFactors(int a, int b) {

        int k = a >= b ? a : b;
        int count = 0;

        for (int i = 1; i <= k; i++) {
            if (a % i == 0 && (b % i) == 0) {
                count++;
            }
        }

        return count;
    }
}
