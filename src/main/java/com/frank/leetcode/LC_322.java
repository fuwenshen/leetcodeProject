package com.frank.leetcode;

import java.util.Arrays;

/**
 * @author fuwenshen
 * @version 1.0.0
 * @ClassName LC_322.java
 * @Description TODO
 * @createTime 2022年02月16日 12:43:00
 */
public class LC_322 {


    public static void main(String[] args) {

        LC_322 lc_322 = new LC_322();
        int []coins = {1, 2, 5};
        int amount = 11;

        int result = lc_322.coinChange(coins, amount);

        System.out.println("result:"+result);

    }
    public int coinChange(int[] coins, int amount) {


        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);

        dp[0] =0;
        for (int i = 1; i <= amount; i++) {

            for (int j = 0; j < coins.length; j++) {
                int coinValue = coins[j];
                if(i-coinValue >=0){
                    dp[i] = Math.min(dp[i],dp[i-coinValue]+1);
                }
            }
        }

        return dp[amount] > amount? -1:dp[amount];

    }
}
