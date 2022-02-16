package com.frank.leetcode;


/**
 * 152. 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 */
public class LC_152 {


    public static void main(String[] args) {

        LC_152 lc_152 = new LC_152();


        int[] nums = {-1,-2,-9,-6};

        int result = lc_152.maxProduct(nums);

        System.out.println("result="+result);
    }


    public int maxProduct(int[] nums) {

        int curMax = nums[0];
        int curMin = nums[0];
        int result = nums[0];


        for (int i = 1; i < nums.length; i++) {

            int curValue = nums[i];
            int curMax1 = curMax * curValue;
            int curMin1 = curMin * curValue;


            curMax = Math.max( Math.max(curMax1,curMin1),curValue);
            curMin = Math.min( Math.min(curMax1,curMin1),curValue);

            result = Math.max(result,curMax);
        }


        return  result;
    }

    
}
