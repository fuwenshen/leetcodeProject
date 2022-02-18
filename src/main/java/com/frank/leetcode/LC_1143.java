package com.frank.leetcode;

/**
 * @author fuwenshen
 * @version 1.0.0
 * @ClassName LC_1143.java
 * @Description 1143. 最长公共子序列
 * @createTime 2022年02月18日 12:53:00
 */
public class LC_1143 {


    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";

        LC_1143 lc1143 = new LC_1143();
        int result = lc1143.longestCommonSubsequence(text1, text2);

        System.out.println("result="+result);

    }

    public int longestCommonSubsequence(String text1, String text2) {


        int l1 = text1.length();
        int l2 = text2.length();

        int[][] dp  = new int[l1+1][l2+1];

        StringBuilder result = new StringBuilder();

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] =  dp[i-1][j-1]+1;
                    result.append(text1.charAt(i-1));
                }else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]) ;
                }
            }
        }

        System.out.println(result.toString());
        return  dp[l1][l2];

    }
}
