package com.frank.leetcode;


import java.util.Arrays;
import java.util.OptionalInt;

/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 */
public class LC_300 {


    public static void main(String[] args) {

        LC_300 lc_300 = new LC_300();


        int[] nums =  {10,9,2,5,3,7,101,18};

        int result = lc_300.lengthOfLIS(nums);

        System.out.println("result="+result);
    }


    public int lengthOfLIS(int[] nums) {


        int len = nums.length;
        // 第i位参与的递增最长子序列长度
        int[] dp = new int[len];

        dp[0]= 1;
        int max =0;
        for(int i = 1 ;i<len;i++) {
            dp[i] = 1;
            for(int j=0;j<i;j++){
                if(nums[j] <nums[i]){
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                }
            }
            max = Math.max(max,dp[i]);
        }


        return max;

    }

    
}
