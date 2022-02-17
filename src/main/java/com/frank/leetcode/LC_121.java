package com.frank.leetcode;

/**
 * @author fuwenshen
 * @version 1.0.0
 * @ClassName LC_121.java
 * @Description 买卖股票的最佳时机
 * @createTime 2022年02月16日 18:02:00
 */
public class LC_121 {





    public static void main(String[] args) {
        LC_121 lc = new LC_121();

        int[] prices = {7,1,5,3,6,4};

        int result = lc.maxProfit1(prices);
        System.out.println("result:"+result);
    }

    /**
     * [7,1,5,3,6,4]    5
     * @param prices
     * @return
     */
    // 暴力求解
    public int maxProfit(int[] prices) {

        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                max = Math.max(max,prices[j]-prices[i]);
            }
        }
        return max;
    }



    public int maxProfit1(int[] prices) {

        int max = 0;
        int min =prices[0];

        for (int i = 1; i < prices.length; i++) {

            // 记录过程中的最小值
            min = Math.min(min,prices[i]);
            // 记录过程中卖出产生的最大值
            max = Math.max(max,prices[i] -min ) ;
        }

        return max;
    }

}
