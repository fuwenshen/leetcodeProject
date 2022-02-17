package com.frank.leetcode;

/**
 * @author fuwenshen
 * @version 1.0.0
 * @ClassName LC_53.java
 * @Description 53. 最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 *
 */
public class LC_53 {


    public static void main(String[] args) {
       int [] nums = {-2,1,-3,4,-1,2,1,-5,4};

       LC_53 lc53 = new LC_53();

        int result = lc53.maxSubArray(nums);

        System.out.println("result="+result);


    }
    public int maxSubArray(int[] nums) {


        // 当前前i个数据的最大和;
        int []dp = new int[nums.length];

        int max = dp[0] =nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i];
            dp[i] = Math.max(dp[i],dp[i-1]+nums[i]);
            max = Math.max(dp[i],max);
        }

        return max;

    }
}
