package com.frank.leetcode;

import java.util.Arrays;

public class LC_198   {


    public static void main(String[] args) {
        int[] nums = {2,1,1,2};

        LC_198 lc_198 = new LC_198();
        int result = lc_198.rob(nums);

        System.out.println("result="+result);


    }


    public int rob(int[] nums) {

        if(nums == null || nums.length ==0 ){
            return 0 ;
        }

        int length = nums.length;

        // 表示偷前i家， 能获取到的最大收益
        int [] dp = new int[length+1];

        int preTwo = 0;
        int preOne = nums[0];
        int curr = preOne;

        for(int i =2;i<=length;i++){

            curr =  Math.max(preTwo+nums[i-1],preOne);
            preTwo =preOne;
            preOne = curr;
        }

        return curr;
    }

    public int rob1(int[] nums) {


        int length = nums.length;

        // 表示偷前i家， 能获取到的最大收益
        int [] dp = new int[length+1];

        dp[0] = 0;
        dp[1] = nums[0];

        for(int i =2;i<=length;i++){
            dp[i] =Math.max(dp[i-2]+nums[i-1],dp[i-1]);
        }

        return dp[length];
    }
}
