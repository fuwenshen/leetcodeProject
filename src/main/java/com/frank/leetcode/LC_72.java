package com.frank.leetcode;


import java.util.Arrays;

/**
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/edit-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC_72 {


    public static void main(String[] args) {

        LC_72 lc_72 = new LC_72();
        String world1 = "horse";
        String world2 = "ros";

        int reuslt = lc_72.minDistance(world1, world2);


        System.out.printf("result="+reuslt);


    }
    
    public int minDistance(String word1, String word2) {
        
        int len1 = word1.length();
        int len2 = word2.length();
        
        
        int [][] dp = new int[len1+1][len2+1];

        // 初始化边界
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= len2; i++) {
            dp[0][i] = i;
        }


        for (int i = 1; i <= len1; i++) {

            for (int j = 1; j <= len2; j++) {
                int step = 1;
                // 如果 world1 第i个字符和world2第j个字符一样，那直接 =dp[i-1][j-1]
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    step = 0;
                }
                dp[i][j] =Math.min( Math.min(dp[i-1][j], dp[i][j-1])+1,dp[i-1][j-1]+step);
            }
        }

        return dp[len1][len2];

    }
}
