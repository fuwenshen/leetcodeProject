package com.frank.leetcode;

/**
 *  最长重复子数组
 *  给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
 *
 */
public class LC_718 {


    public static void main(String[] args) {
       int[] nums1 = {0,0,0,0,1}, nums2 = {1,0,0,0,0};

        LC_718 leetcode  = new LC_718();

        int length = leetcode.findLength(nums1, nums2);

        System.out.printf("result="+length);

    }

    public int findLength(int[] nums1, int[] nums2) {

        int l1 = nums1.length;
        int l2 = nums2.length;


        // dp 表示包含 num1第i位和num2的第j位的最大公共子序列长度
        int [][]dp = new int[l1+1][l2+1];


        int max = 0;
        for (int i = 1; i <= l1; i++) {

            for (int j = 1; j <= l2; j++) {
                if(nums1[i-1] ==nums2[j-1]){
                    dp[i][j]= dp[i-1][j-1]+1;
                    max = Math.max(dp[i][j],max);
                }
            }
        }

        return max;

    }

}
